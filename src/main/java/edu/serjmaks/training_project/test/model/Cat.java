package edu.serjmaks.training_project.test.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "t_cat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cat {

    @Id
    @Column
    Long id;

    @Column
    String name;

    @Column
    int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id")
    Human human;
}
