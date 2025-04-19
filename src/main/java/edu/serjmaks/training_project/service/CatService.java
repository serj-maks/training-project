package edu.serjmaks.training_project.service;

import edu.serjmaks.training_project.model.Cat;

import java.util.List;

public interface CatService {
    List<Cat> getAll();
    Cat getById(Integer id);
    Cat create(Cat cat);
    Cat update(Cat cat, Integer id);
    void deleteById(Integer id);
}
