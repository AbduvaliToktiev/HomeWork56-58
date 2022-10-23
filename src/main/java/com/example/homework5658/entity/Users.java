package com.example.homework5658.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = Users.TABLE_NAME)
public class Users {
    public static final String TABLE_NAME = "USERS";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(generator = SEQ_NAME)
    private Long id;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "ROLE")
    private List<Role> roles;
}
