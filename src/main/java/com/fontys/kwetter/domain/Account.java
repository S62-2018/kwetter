package com.fontys.kwetter.domain;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity()
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "Account.remove", query = "DELETE FROM Account a WHERE a.handle = :handle")
})
public class Account implements Serializable {
    @Id
    @Column(unique = true, nullable = false)
    @NotEmpty
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
    @JoinTable(
            name = "followers",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private Set<Account> followers;

    @ManyToMany()
    @JoinTable(
            name = "followers",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    private Set<Account> following;

    @ManyToMany(mappedBy = "mentions")
    private Set<Tweet> mentionedTweets;

    @OneToMany(mappedBy = "author")
    private List<Tweet> tweets;

    public Account() {

    }

    public Account(String handle) {
        this.handle = handle;
        this.photoURL = "";
        this.biography = "";
        this.location = "";
        this.websiteURL = "";
        this.followers = new HashSet<Account>();
        this.following = new HashSet<Account>();
        this.mentionedTweets = new HashSet<Tweet>();
        this.tweets = new ArrayList<Tweet>();
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public Set<Account> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Account> followers) {
        this.followers = followers;
    }

    public Set<Account> getFollowing() {
        return following;
    }

    public void setFollowing(Set<Account> following) {
        this.following = following;
    }

    public Set<Tweet> getMentionedTweets() {
        return mentionedTweets;
    }

    public void setMentionedTweets(Set<Tweet> mentionedTweets) {
        this.mentionedTweets = mentionedTweets;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
