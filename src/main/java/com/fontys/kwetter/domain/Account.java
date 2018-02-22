package com.fontys.kwetter.domain;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.*;

@Entity()
public class Account implements Serializable {
    @Id
    @Column(name = "account_id")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(unique = true)
    private String handle;

    @Column
    private String photoURL;

    @Column
    private String biography;

    @Column
    private String location;

    @Column
    private String websiteURL;

    @ManyToMany()
    private List<Account> followers;

    @ManyToMany()
    private List<Account> following;

    @ManyToMany(mappedBy = "mentions")
    private List<Tweet> mentionedTweets;

    @OneToMany(mappedBy = "author")
    private List<Tweet> tweets;
}
