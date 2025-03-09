package edu.serjmaks.training_project.repository;

import edu.serjmaks.training_project.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {
}
