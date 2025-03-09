package edu.serjmaks.training_project.service.impl;

import edu.serjmaks.training_project.model.Cat;
import edu.serjmaks.training_project.repository.CatRepository;
import edu.serjmaks.training_project.service.CatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    CatRepository catRepository;

    CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cat> getAll() {
        return catRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Cat get(Integer id) {
        return catRepository.findById(id).get();
    }

    @Transactional
    @Override
    public String create(Cat cat) {
        catRepository.save(cat);
        return "success!";
    }

    @Transactional
    @Override
    public String update(Cat cat) {
        catRepository.save(cat);
        return "success!";
    }

    @Transactional
    @Override
    public String delete(Integer id) {
        catRepository.deleteById(id);
        return "success!";
    }
}
