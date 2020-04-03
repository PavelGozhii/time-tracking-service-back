package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "purсhased_subscription", schema = "public", catalog = "time-tracking-service")
public class PurchasedSubscription {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "time_to_end", nullable = false)
    private Date timeToEnd;
    @Basic
    @Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    private Integer typeId;
    @Basic
    @Column(name = "organization_id", nullable = false, insertable = false, updatable = false)
    private Integer organizationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private Subscription refSubscription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization refOrganization;

}
