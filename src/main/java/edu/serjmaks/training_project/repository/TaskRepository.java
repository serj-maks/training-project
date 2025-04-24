package edu.serjmaks.training_project.repository;

import edu.serjmaks.training_project.model.Task;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    boolean existsByTitle(String title);

    @Override
    @EntityGraph(attributePaths = "humans")
    List<Task> findAll();

    @Override
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "humans")
    Optional<Task> findById(Integer id);
}
