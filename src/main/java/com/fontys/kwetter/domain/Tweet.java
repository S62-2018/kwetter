package com.fontys.kwetter.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Tweet implements Serializable {
    @Id
    @Column(name = "tweet_id")
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;

    @Column
    private Account author;

    @Column
    private String content;

    private List<Account> mentions;

    private List<Account> likes;

    private List<Trend> trends;
}
