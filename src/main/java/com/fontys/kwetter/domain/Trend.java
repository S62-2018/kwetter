package com.fontys.kwetter.domain;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.UUID;

@Entity()
@UuidGenerator(name = "trend_id_gen")
public class Trend implements Serializable {
    @Id
    @Column
    @GeneratedValue(generator = "trend_id_gen")
    private UUID id;

    @Column
    private String title;
}
