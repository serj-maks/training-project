package edu.serjmaks.training_project.repository;

import edu.serjmaks.training_project.model.Human;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HumanRepository extends JpaRepository<Human, Integer> {
    boolean existsByName(String name);
    boolean existsByAge(int age);

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "tasks")
    List<Human> findAll();

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "tasks")
    Optional<Human> findById(Integer id);
}
