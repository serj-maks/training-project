package edu.serjmaks.training_project.service.impl;

import edu.serjmaks.training_project.exception.NotFoundException;
import edu.serjmaks.training_project.mapper.DogMapper;
import edu.serjmaks.training_project.model.Dog;
import edu.serjmaks.training_project.repository.DogRepository;
import edu.serjmaks.training_project.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;
    private final DogMapper dogMapper;

    @Override
    public List<Dog> getAll() {
        return dogRepository.findAll();
    }

    @Override
    public Dog getById(Integer id) {
        return dogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Dog.class, id));
    }

    @Transactional
    @Override
    public Dog create(Dog dog) {
        if (dogRepository.existsByName(dog.getName())) {
            // здесь выбрасывается именно IllegalArgumentException, чтобы сработал код в
            // классе exception/GlobalExceptionHandler
            throw new IllegalArgumentException("Dog with same name already exists");
        }
        if (dogRepository.existsByAge(dog.getAge())) {
            throw new IllegalArgumentException("Dog with same age already exists");
        }
        return dogRepository.save(dog);
    }

    @Transactional
    @Override
    @Retryable(maxAttempts = 15)
    public Dog update(Dog newDog, Integer id) {
        Dog dog = getById(id);
        dogMapper.updateDog(newDog, dog);
        return dogRepository.save(dog);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        if (!dogRepository.existsById(id)) {
            throw new NotFoundException(Dog.class, id);
        }
        dogRepository.deleteById(id);
    }
}
