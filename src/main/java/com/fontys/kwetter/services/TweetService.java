package com.fontys.kwetter.services;

import com.fontys.kwetter.dao.TweetDAO;
import com.fontys.kwetter.domain.Tweet;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class TweetService {
    @Inject
    private TweetDAO tweetDAO;

    public List<Tweet> allTweets() {
        return this.tweetDAO.getTweets();
    }
}
