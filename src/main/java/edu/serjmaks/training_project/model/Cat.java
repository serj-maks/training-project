package edu.serjmaks.training_project.model;

import jakarta.persistence.*;

@Entity
@Table(name="cat")
public class Cat {

    @Id
    @Column
    //TODO: если не заведется - измени примитив на объект
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @OneToOne
    @JoinColumn(name = "human_id")
    private Human human;

    public Cat() {

    }

    public Cat(int id, String name, int age) {
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

    public Human getHuman() {
        return human;
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

    public void setHuman(Human human) {
        this.human = human;
    }
}
