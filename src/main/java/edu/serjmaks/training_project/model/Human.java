package edu.serjmaks.training_project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "human")
@Accessors(chain = true)
@NoArgsConstructor
public class Human {

    @Id
    @Column
    @GeneratedValue(generator = "human_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "human_seq", sequenceName = "human_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private String name;

    @Column
    private int age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "human_task",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Task> tasks = new ArrayList<>();
}
