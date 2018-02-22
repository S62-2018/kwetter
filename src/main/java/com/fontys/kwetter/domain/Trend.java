package com.fontys.kwetter.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

public class Trend implements Serializable {
    @Id
    @Column(name = "trend_id")
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;

    private String title;
}
