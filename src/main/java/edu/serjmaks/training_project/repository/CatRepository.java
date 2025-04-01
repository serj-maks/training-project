package edu.serjmaks.training_project.repository;

import edu.serjmaks.training_project.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Integer> {

    boolean existsByName(String name);

    boolean existsByAge(int age);
}
