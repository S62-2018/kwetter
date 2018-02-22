package com.fontys.kwetter.domain;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity()
@UuidGenerator(name = "tweet_id_gen")
@NamedQuery(name = "Tweet.allTweets", query = "SELECT t FROM Tweet t")
public class Tweet implements Serializable {
    @Id
    @GeneratedValue(generator = "tweet_id_gen")
    @Column(name = "tweet_id")
    private UUID id;

    @ManyToOne()
    private Account author;

    @Column
    private String content;

    @ManyToMany()
    @JoinTable(name = "account_tweet_mentions", joinColumns = @JoinColumn(name = "fk_tweet_id"), inverseJoinColumns = @JoinColumn(name = "fk_account_id"))
    private List<Account> mentions;

    @ManyToMany
    @JoinTable(name = "account_tweet_likes", joinColumns = @JoinColumn(name = "fk_account_id"), inverseJoinColumns = @JoinColumn(name = "fk_tweet_id"))
    private List<Account> likes;

    @ManyToMany()
    @JoinTable(joinColumns = @JoinColumn(name = "fk_trend_id"), inverseJoinColumns = @JoinColumn(name = "fk_tweet_id"))
    private List<Trend> trends;
}
