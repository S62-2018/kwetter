package com.fontys.kwetter.domain;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

@Entity()
@UuidGenerator(name = "tweet_id_gen")
@NamedQueries({
        @NamedQuery(name = "Tweet.findAll", query = "SELECT t FROM Tweet t"),
        @NamedQuery(name = "Tweet.findByUsername", query = "SELECT t FROM Tweet t WHERE t.author.handle = :handle"),
        @NamedQuery(name = "Tweet.removeById", query = "DELETE FROM Tweet t WHERE t.id = :id")
})
public class Tweet implements Serializable {
    @Id
    @GeneratedValue(generator = "tweet_id_gen")
    @Column
    private UUID id;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Account author;

    @Column
    @NotEmpty
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

    public Tweet() {

    }

    public Tweet(Account author, String content, List<Account> mentions, List<Account> likes, List<Trend> trends) {
        this.author = author;
        this.content = content;
        this.mentions = mentions;
        this.likes = likes;
        this.trends = trends;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Account> getMentions() {
        return mentions;
    }

    public void setMentions(List<Account> mentions) {
        this.mentions = mentions;
    }

    public List<Account> getLikes() {
        return likes;
    }

    public void setLikes(List<Account> likes) {
        this.likes = likes;
    }

    public List<Trend> getTrends() {
        return trends;
    }

    public void setTrends(List<Trend> trends) {
        this.trends = trends;
    }
}
