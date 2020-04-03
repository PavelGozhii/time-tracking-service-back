package com.threesome.timeTrackingService.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comment_type", schema = "public", catalog = "time-tracking-service")
public class CommentType {

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "refCommentType")
    private List<TaskComment> refTaskComments = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskComment> getRefTaskComments() {
        return refTaskComments;
    }

    public void setRefTaskComments(List<TaskComment> refTaskComments) {
        this.refTaskComments = refTaskComments;
    }

    @Override
    public String toString() {
        return "CommentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", refTaskCommentEntities=" + refTaskComments +
                '}';
    }


}
