package com.andy.attire.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "USER")
public class UserEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    private Date createDate;
    @Transient
   private List<String> roles;
}
