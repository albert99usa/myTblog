package com.tangzq.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User_me {
    private int id;
    private String username;
    private String password;
    private boolean isactive;
    private Timestamp dateCreated;
    private String email;
    private String avatarUrl;
    private boolean avatarUrlByUploaded;
    private String website;
    private String location;
    private String slogan;
    private String selfDesc;
    private Collection<Post> postsById;
    private Collection<Topic> topicsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Password", nullable = false, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "isactive", nullable = false)
    public boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 250)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "avatarURL", nullable = true, length = 250)
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Basic
    @Column(name = "avatarURLByUploaded", nullable = true)
    public boolean getAvatarUrlByUploaded() {
        return avatarUrlByUploaded;
    }

    public void setAvatarUrlByUploaded(boolean avatarUrlByUploaded) {
        this.avatarUrlByUploaded = avatarUrlByUploaded;
    }

    @Basic
    @Column(name = "website", nullable = true, length = 250)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 250)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "slogan", nullable = true, length = 250)
    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    @Basic
    @Column(name = "selfDesc", nullable = true, length = 250)
    public String getSelfDesc() {
        return selfDesc;
    }

    public void setSelfDesc(String selfDesc) {
        this.selfDesc = selfDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User_me user = (User_me) o;
        return id == user.id &&
                isactive == user.isactive &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(dateCreated, user.dateCreated) &&
                Objects.equals(email, user.email) &&
                Objects.equals(avatarUrl, user.avatarUrl) &&
                Objects.equals(avatarUrlByUploaded, user.avatarUrlByUploaded) &&
                Objects.equals(website, user.website) &&
                Objects.equals(location, user.location) &&
                Objects.equals(slogan, user.slogan) &&
                Objects.equals(selfDesc, user.selfDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, isactive, dateCreated, email, avatarUrl, avatarUrlByUploaded, website, location, slogan, selfDesc);
    }
/*
    @OneToMany(mappedBy = "userByUId")
    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }*/

   @OneToMany(mappedBy = "userByAuthorid")

    public Collection<Topic> getTopicsById() {
        return topicsById;
    }

    public void setTopicsById(Collection<Topic> topicsById) {
        this.topicsById = topicsById;
    }

    public void setisactive(boolean b) {
        isactive=b;
    }

    //   public Collection<Post> getPostsById() {
  //      return postsById;
 ///   }

//    public void setPostsById(Collection<Post> postsById) {
//        this.postsById = postsById;
//    }
}
