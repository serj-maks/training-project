package edu.serjmaks.training_project.repository;

import edu.serjmaks.training_project.IntegrationTest;
import edu.serjmaks.training_project.model.Cat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatRepositoryTest extends IntegrationTest {

    @Test
    void save() {
        transactionTemplate.executeWithoutResult(status -> {
            Cat cat = new Cat(1, "sunny", 5);
            Cat savedCat = catRepository.save(cat);
            Cat actualCat = catRepository.findById(savedCat.getId()).get();
            assertEquals(savedCat, actualCat);
        });
    }

    @Test
    void findById() {
        Cat cat= new Cat(1, "sunny", 5);
        catRepository.save(cat);
        Cat savedCat = catRepository.findById(cat.getId()).get();

        assertEquals(savedCat.getId(), cat.getId());
        assertEquals(savedCat.getName(), cat.getName());
        assertEquals(savedCat.getAge(), cat.getAge());
    }
}