package edu.serjmaks.training_project.service.impl;

import edu.serjmaks.training_project.exception.NotFoundException;
import edu.serjmaks.training_project.mapper.DogMapper;
import edu.serjmaks.training_project.model.Dog;
import edu.serjmaks.training_project.repository.DogRepository;
import edu.serjmaks.training_project.service.DogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;
    private final DogMapper dogMapper;

    DogServiceImpl(DogRepository dogRepository, DogMapper dogMapper) {
        this.dogRepository = dogRepository;
        this.dogMapper = dogMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dog> getAll() {
        return dogRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Dog getById(Integer id) {
        return dogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Dog.class, id));
    }

    @Transactional
    @Override
    public Dog create(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Dog update(Dog newDog, Integer id) {
        Dog dog = getById(id);
        dogMapper.updateDog(newDog, dog);
        return dogRepository.save(dog);
    }

    @Override
    public void deleteById(Integer id) {
        if (!dogRepository.existsById(id)) {
            throw new NotFoundException(Dog.class, id);
        }
        dogRepository.deleteById(id);
    }

}
