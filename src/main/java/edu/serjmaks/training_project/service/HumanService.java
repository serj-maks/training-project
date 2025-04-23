package edu.serjmaks.training_project.service;

import edu.serjmaks.training_project.model.Human;

import java.util.List;

public interface HumanService {
    Human getById(Integer id);
    List<Human> getAll();
    Human create(Human human);
    Human update(Human human, Integer id);
    void deleteById(Integer id);
}
