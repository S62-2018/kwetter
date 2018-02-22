package com.fontys.kwetter.dao;

import com.fontys.kwetter.domain.Tweet;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class TweetDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Tweet> getTweets() {
        return this.entityManager.createNamedQuery("Tweet.allTweets").getResultList();
    }
}
