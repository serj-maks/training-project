package edu.serjmaks.training_project.test.repository;

import edu.serjmaks.training_project.test.model.Human;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {

    boolean existsByName(String name);
    boolean existsByAge(int age);

    @Override
    @EntityGraph(attributePaths = "tasks", type = EntityGraph.EntityGraphType.FETCH)
    Optional<Human> findById(Long id);

    @Override
    @EntityGraph(attributePaths = "tasks", type = EntityGraph.EntityGraphType.FETCH)
    List<Human> findAll();
}
