package edu.serjmaks.training_project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "dog")
@Accessors(chain = true)
@NoArgsConstructor
public class Dog {

    @Id
    @Column
    @SequenceGenerator(name = "dog_seq", sequenceName = "dog_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_seq")
    private Integer id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "human_id", nullable = true)
    private Human human;
}
