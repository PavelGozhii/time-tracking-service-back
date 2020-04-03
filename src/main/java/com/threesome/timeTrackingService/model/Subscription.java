package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscription", schema = "public", catalog = "time-tracking-service")
public class Subscription {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false)
    private String name;
    @Basic
    @Column(name = "duration", nullable = false)
    private Integer duration;
    @Basic
    @Column(name = " usage", nullable = false)
    private Integer usage;
    @Basic
    @Column(name = "price", nullable = false)
    private Float price;

    @OneToMany(mappedBy = "refSubscription")
    private List<PurchasedSubscription> refPurchasedSubscriptions;
}
