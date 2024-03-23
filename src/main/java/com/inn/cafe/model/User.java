package com.inn.cafe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


    @Column(name = "contactNumber")
    private String contactNumber;


    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;


    @Column(name = "status")
    private String status;


    @Column(name = "role")
    private String role;



}
