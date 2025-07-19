package edu.serjmaks.training_project.test.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_human")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Human {

    @Id
    @Column
    @SequenceGenerator(name = "human_generator", sequenceName = "human_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "human_generator", strategy = GenerationType.SEQUENCE)
    Long id;

    @Column
    String name;

    @Column
    int age;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "human_task",
            joinColumns = @JoinColumn(name = "human_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    List<Task> tasks = new ArrayList<>();
}
