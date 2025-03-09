package edu.serjmaks.training_project.service;

import edu.serjmaks.training_project.model.Dog;

import java.util.List;

public interface DogService {
    List<Dog> getAll();
    Dog getById(Integer id);
    Dog create(Dog dog);
    Dog update(Dog dog, Integer id);
    void deleteById(Integer id);
}
