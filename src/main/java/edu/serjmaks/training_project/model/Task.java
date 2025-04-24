package edu.serjmaks.training_project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "task")
@Accessors(chain = true)
@NoArgsConstructor
public class Task {

    @Id
    @Column
    @GeneratedValue(generator = "task_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name ="task_seq", sequenceName = "task_id_seq", allocationSize = 1)
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    //TODO: проверить, нужно ли и здесь указывать FetchType.LAZY, как в human
    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    private List<Human> humans = new ArrayList<>();
}
