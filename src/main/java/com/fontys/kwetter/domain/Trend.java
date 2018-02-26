package com.fontys.kwetter.domain;

import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.UUID;

@Entity()
@UuidGenerator(name = "trend_id_gen")
@NamedQueries({
        @NamedQuery(name = "Trend.findByTitle", query = "SELECT t FROM Trend t WHERE t.title = :title"),
        @NamedQuery(name = "Trend.findAll", query = "SELECT t FROM Trend t")
})
public class Trend implements Serializable {
    @Id
    @Column
    @GeneratedValue(generator = "trend_id_gen")
    private UUID id;

    @Column
    private String title;

    public Trend() {

    }

    public Trend(String title) {
        this.title = title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
