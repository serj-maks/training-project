package edu.serjmaks.training_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/*
тестовая сущность для hibernate, чтобы потестить аннотаций
@OneToMany, @ManyToOne, @ManyToMany
и @JoinTable, @JoinColumn
 */
@Entity
@Data
@Table
@Accessors(chain = true)
public class Mission {

    @Id
    private int id;

    @ManyToMany(mappedBy = "missions")
    private List<Human> humans = new ArrayList<>();
}
