package com.fontys.kwetter.domain;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity()
@UuidGenerator(name = "account_id_gen")
public class Account implements Serializable {
    @Id
    @Column
    @GeneratedValue(generator = "account_id_gen")
    private UUID id;

    @Column(unique = true)
    @Size(max = 140)
    private String handle;

    @Column
    private String photoURL;

    @Column
    @Size(max = 140)
    private String biography;

    @Column
    @Size(max = 140)
    private String location;

    @Column
    @Size(max = 140)
    private String websiteURL;

    @ManyToMany()
    @JoinTable(name = "followers", joinColumns = @JoinColumn(name = "following_id"), inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<Account> followers;

    @ManyToMany()
    @JoinTable(name = "followers", joinColumns = @JoinColumn(name = "follower_id"), inverseJoinColumns = @JoinColumn(name = "following_id"))
    private List<Account> following;

    @ManyToMany(mappedBy = "mentions")
    private List<Tweet> mentionedTweets;

    @OneToMany(mappedBy = "author")
    private List<Tweet> tweets;
}
