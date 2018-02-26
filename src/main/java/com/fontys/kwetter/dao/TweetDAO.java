package com.fontys.kwetter.dao;

import com.fontys.kwetter.domain.Tweet;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Stateless
public class TweetDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Tweet> get(String authorHandle) {
        TypedQuery<Tweet> query = this.entityManager.createNamedQuery("Tweet.findByUsername", Tweet.class);
        query.setParameter("handle", authorHandle);

        return query.getResultList();
    }

    public List<Tweet> getAll() {
        TypedQuery<Tweet> query = this.entityManager.createNamedQuery("Tweet.findAll", Tweet.class);

        return query.getResultList();
    }

    @Transactional
    public void remove(UUID id) {
        TypedQuery<Tweet> query = this.entityManager.createNamedQuery("Tweet.removeById", Tweet.class).setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional
    public void save(Tweet tweet) {
        this.entityManager.persist(tweet);
    }

    @Transactional
    public void update(Tweet tweet) {
        this.entityManager.merge(tweet);
    }
}
