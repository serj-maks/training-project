package edu.serjmaks.training_project.test.service;

import edu.serjmaks.training_project.test.model.Human;

import java.util.List;

public interface HumanService {
    Human getById(Long id);
    List<Human> getAll();
    Human create(Human human);
    Human update(Human human, Long id);
    void deleteById(Long id);
}
