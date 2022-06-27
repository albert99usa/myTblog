package com.tangzq.model;

import java.sql.Timestamp;
import java.util.Objects;

public class TagOfPost {
    private int id;
    private int pid;
    private int tid;
    private Timestamp dateCreated;
    private Post postByPid;
    private Tag tagByTid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagOfPost tagOfPost = (TagOfPost) o;
        return id == tagOfPost.id &&
                pid == tagOfPost.pid &&
                tid == tagOfPost.tid &&
                Objects.equals(dateCreated, tagOfPost.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, tid, dateCreated);
    }

    public Post getPostByPid() {
        return postByPid;
    }

    public void setPostByPid(Post postByPid) {
        this.postByPid = postByPid;
    }

    public Tag getTagByTid() {
        return tagByTid;
    }

    public void setTagByTid(Tag tagByTid) {
        this.tagByTid = tagByTid;
    }
}
