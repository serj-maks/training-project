package edu.serjmaks.training_project.service;

import edu.serjmaks.training_project.model.Cat;

import java.util.List;

public interface CatService {
    List<Cat> getAll();
    Cat get(Integer id);
    String create(Cat cat);
    String update(Cat cat);
    String delete(Integer id);
}
