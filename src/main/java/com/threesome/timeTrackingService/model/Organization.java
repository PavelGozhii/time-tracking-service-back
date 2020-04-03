package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization", schema = "public", catalog = "time-tracking-service")
public class Organization {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true)
    private String name;
    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "refOrganization")
    private List<PurchasedSubscription> refPurchasedSubscriptions;
    @OneToMany(mappedBy = "refOrganization")
    private List<Team> refTeams;
    @OneToMany(mappedBy = "refOrganization")
    private List<User> refUsers;
}
