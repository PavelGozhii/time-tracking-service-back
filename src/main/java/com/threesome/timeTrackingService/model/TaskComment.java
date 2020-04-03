package com.threesome.timeTrackingService.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "task_comment", schema = "public", catalog = "time-tracking-service")
public class TaskComment {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "writer_id", nullable = false, insertable = false, updatable = false)
    private Integer writerId;
    @Basic
    @Column(name = "text", nullable = false)
    private String text;
    @Basic
    @Column(name = "date", nullable = false)
    private Timestamp date;
    @Basic
    @Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    private Integer typeId;
    @Basic
    @Column(name = "task_id", nullable = false, insertable = false, updatable = false)
    private Integer taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", referencedColumnName = "id")
    private User refUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private CommentType refCommentType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task refTask;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWriterId() {
        return writerId;
    }

    public void setWriterId(Integer writerId) {
        this.writerId = writerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public User getRefUser() {
        return refUser;
    }

    public void setRefUser(User refUser) {
        this.refUser = refUser;
    }

    public CommentType getRefCommentType() {
        return refCommentType;
    }

    public void setRefCommentType(CommentType refCommentType) {
        this.refCommentType = refCommentType;
    }

    public Task getRefTask() {
        return refTask;
    }

    public void setRefTask(Task refTask) {
        this.refTask = refTask;
    }
}
