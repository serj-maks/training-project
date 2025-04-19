package edu.serjmaks.training_project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "cat")
@Accessors(chain = true)
@NoArgsConstructor
public class Cat {

    @Id
    @Column
    @GeneratedValue(generator = "cat_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cat_seq", sequenceName = "cat_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "human_id", nullable = true)
    private Human human;
}
