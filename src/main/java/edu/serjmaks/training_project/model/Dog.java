package edu.serjmaks.training_project.model;

import jakarta.persistence.*;

@Entity
@Table(name="dog")
public class Dog {

    @Id
    @Column
    @SequenceGenerator(name = "dog_id_seq", sequenceName = "dog_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_id_seq")
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    public Dog() {

    }

    public Dog(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
