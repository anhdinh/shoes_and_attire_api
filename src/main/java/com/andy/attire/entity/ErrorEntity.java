package com.andy.attire.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "error_data")
@Data
@NoArgsConstructor
public class ErrorEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="reference",  updatable = false, nullable = false)
    private UUID reference;

    @Column(columnDefinition = "TEXT",length = 2000)
    private String url;
    @Column(columnDefinition = "TEXT")
    private String body;
    @Column(columnDefinition = "TEXT")
    private String exceptionMessage;
    @Column(columnDefinition = "TEXT")
    private String track;

}
