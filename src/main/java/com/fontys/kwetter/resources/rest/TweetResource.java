package com.fontys.kwetter.resources.rest;

import com.fontys.kwetter.domain.Tweet;
import com.fontys.kwetter.services.TweetService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import java.util.List;

@Path("tweets")
@Stateless
public class TweetResource {
    @Inject
    private TweetService tweetService;

    @GET
    public List<Tweet> allTweets() {
        return this.tweetService.allTweets();
    }
}
