package com.example.homework5658.entity;

import com.example.homework5658.enums.StatusTask;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = Task.TABLE_NAME)
public class Task {
    public static final String TABLE_NAME = "TASKS";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(generator = SEQ_NAME)
    private Long id;

    @Column(name = "HEADER")
    private String header;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE_TASK")
    private Date dateTask;

    @Column
    @Enumerated(EnumType.STRING)
    private StatusTask statusTask;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
