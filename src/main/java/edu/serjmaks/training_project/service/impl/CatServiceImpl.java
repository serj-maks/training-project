package edu.serjmaks.training_project.service.impl;

import edu.serjmaks.training_project.exception.AlreadyExistsException;
import edu.serjmaks.training_project.exception.NotFoundException;
import edu.serjmaks.training_project.mapper.CatMapper;
import edu.serjmaks.training_project.model.Cat;
import edu.serjmaks.training_project.repository.CatRepository;
import edu.serjmaks.training_project.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;
    private final CatMapper catMapper;

    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat getById(Integer id) {
        return catRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Cat.class, id));
    }

    @Transactional
    @Override
    public Cat create(Cat cat) {
        if (catRepository.existsByName(cat.getName())) {
            throw new AlreadyExistsException(Cat.class, cat.getName());
        }
        if (catRepository.existsByAge(cat.getAge())) {
            throw new AlreadyExistsException(Cat.class, cat.getAge());
        }
        return catRepository.save(cat);
    }

    @Transactional
    @Override
    @Retryable(maxAttempts = 15)
    public Cat update(Cat newCat, Integer id) {
        Cat oldCat = getById(id);
        Cat updatedCat = catMapper.updateCat(newCat, oldCat);
        return catRepository.save(updatedCat);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        if (!catRepository.existsById(id)) {
            throw new NotFoundException(Cat.class, id);
        }
        catRepository.deleteById(id);
    }
}
