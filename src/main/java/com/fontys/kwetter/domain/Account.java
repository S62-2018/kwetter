package com.fontys.kwetter.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

public class Account implements Serializable {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private UUID id;

    @Column(unique = true)
    private String handle;

    @Column
    private String photoURL;

    @Column
    private String biography;

    @Column
    private String location;

    @Column
    private String websiteURL;

    @ManyToMany()
    private List<Account> followers;
    
    @ManyToMany()
    private List<Account> following;
}
