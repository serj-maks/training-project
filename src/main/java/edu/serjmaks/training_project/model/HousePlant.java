package edu.serjmaks.training_project.model;

import jakarta.persistence.*;

/*
тестовая сущность для hibernate, чтобы потестить аннотаций
@OneToMany, @ManyToOne, @ManyToMany
и @JoinTable, @JoinColumn
 */
@Entity
@Table
public class HousePlant {

    @Id
    @Column
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "human_id")
    private Human human;
}
