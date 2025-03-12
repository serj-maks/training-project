package edu.serjmaks.training_project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
тестовая сущность для hibernate, чтобы потестить аннотаций
@OneToMany, @ManyToOne, @ManyToMany
и @JoinTable, @JoinColumn
 */
@Entity
@Table
public class Human {

    @Id
    @Column
    @SequenceGenerator(name = "human_id_seq", sequenceName = "human_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "human_id_seq")
    private int id;

    @Column
    private String firstName;

    //one direction link
    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    //bi direction link
    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;

    @OneToMany(mappedBy = "human")
    private List<HousePlant> plants = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "human_mission",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    private List<Mission> missions = new ArrayList<>();


    public Human() {

    }

    public Human(int id,
                 String firstName,
                 Dog dog,
                 Cat cat,
                 List<HousePlant> plants,
                 List<Mission> missions) {
        this.id = id;
        this.firstName = firstName;
        this.dog = dog;
        this.cat = cat;
        this.plants = plants;
        this.missions = missions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public List<HousePlant> getPlants() {
        return plants;
    }

    public void setPlants(List<HousePlant> plants) {
        this.plants = plants;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
}
