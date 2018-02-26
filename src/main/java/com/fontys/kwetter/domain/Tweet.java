package com.fontys.kwetter.domain;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity()
@UuidGenerator(name = "tweet_id_gen")
@NamedQuery(name = "Tweet.allTweets", query = "SELECT t FROM Tweet t")
public class Tweet implements Serializable {
    @Id
    @GeneratedValue(generator = "tweet_id_gen")
    @Column
    private UUID id;

    @ManyToOne
    private Account author;

    @Column
    @Size(max = 140)
    private String content;

    @ManyToMany()
    @JoinTable(joinColumns = @JoinColumn(name = "tweet_id"), inverseJoinColumns = @JoinColumn(name = "account_id"))
    private List<Account> mentions;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "tweet_id"))
    private List<Account> likes;

    @ManyToMany()
    @JoinTable(joinColumns = @JoinColumn(name = "trend_id"), inverseJoinColumns = @JoinColumn(name = "tweet_id"))
    private List<Trend> trends;
}
