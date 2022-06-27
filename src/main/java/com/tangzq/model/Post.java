package com.tangzq.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post {
    @Id
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "u_Id")
    private int uId;
    @Column(name = "cid")
    private int cid;
    @Column(name = "date_Created")
    private Timestamp dateCreated;
    @Column(name = "isPublished")
    private byte isPublished;

//    @JoinColumn(name = "title")
//    private com.tangzq.model.User userByUId;
//
//    @JoinColumn(name = "title")
//    private com.tangzq.model.Category catagoriesByCid;
//
//    @JoinColumn(name = "title")
//    private Collection<TagOfPost> tagOfPostsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public byte getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(byte isPublished) {
        this.isPublished = isPublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id &&
                uId == post.uId &&
                cid == post.cid &&
                isPublished == post.isPublished &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(dateCreated, post.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, uId, cid, dateCreated, isPublished);
    }

//    public com.tangzq.model.User getUserByUId() {
//        return userByUId;
//    }
//
//    public void setUserByUId(User userByUId) {
//        this.userByUId = userByUId;
//    }
//
//    public Catagories getCatagoriesByCid() {
//        return catagoriesByCid;
//    }
//
//    public void setCatagoriesByCid(Catagories catagoriesByCid) {
//        this.catagoriesByCid = catagoriesByCid;
//    }
//
//    public Collection<TagOfPost> getTagOfPostsById() {
//        return tagOfPostsById;
//    }
//
//    public void setTagOfPostsById(Collection<TagOfPost> tagOfPostsById) {
//        this.tagOfPostsById = tagOfPostsById;
//    }
}
