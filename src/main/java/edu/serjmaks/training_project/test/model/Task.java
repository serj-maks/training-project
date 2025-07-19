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
@Table(name = "t_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {

    @Id
    @Column
    Long id;

    @Column
    String title;

    @ManyToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
    List<Human> humans = new ArrayList<>();
}
