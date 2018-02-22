package com.fontys.kwetter.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

public class Tweet implements Serializable {
    @Id
    @Column(name = "tweet_id")
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;

    @ManyToOne()
    private Account author;

    @Column
    private String content;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "mentionedTweets")
    @JoinTable(name = "account_tweet_mentions", joinColumns = @JoinColumn(name = "fk_account_id", referencedColumnName = "account_id"), inverseJoinColumns = @JoinColumn(name = "fk_tweet_id", referencedColumnName = "tweet_id"))
    private List<Account> mentions;

    @ManyToMany
    @JoinTable(name = "account_tweet_likes", joinColumns = @JoinColumn(name = "fk_account_id", referencedColumnName = "account_id"), inverseJoinColumns = @JoinColumn(name = "fk_tweet_id", referencedColumnName = "tweet_id"))
    private List<Account> likes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_tweet_trends", joinColumns = @JoinColumn(name = "fk_trend_id", referencedColumnName = "trend_id"), inverseJoinColumns = @JoinColumn(name = "fk_tweet_id", referencedColumnName = "tweet_id"))
    private List<Trend> trends;
}
