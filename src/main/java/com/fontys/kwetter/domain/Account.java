package com.fontys.kwetter.domain;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.*;

@Entity()
@UuidGenerator(name = "account_id_gen")
public class Account implements Serializable {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(generator = "account_id_gen")
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
