package com.tangzq.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
@Entity()
@Table(name = "categories")
public class Catagories {
    private int id;
    private String catDir;
    private String name;
    private int parentId;
    private Timestamp createat;
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
    @Column(name = "catDir", nullable = false, length = 50)
    public String getCatDir() {
        return catDir;
    }

    public void setCatDir(String catDir) {
        this.catDir = catDir;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parent_id", nullable = false)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "createat", nullable = false)
    public Timestamp getCreateat() {
        return createat;
    }

    public void setCreateat(Timestamp createat) {
        this.createat = createat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catagories that = (Catagories) o;
        return id == that.id &&
                parentId == that.parentId &&
                Objects.equals(catDir, that.catDir) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createat, that.createat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, catDir, name, parentId, createat);
    }

    @OneToMany(mappedBy = "catagoriesByCid")
    public Collection<Post> getPostsById() {
        return postsById;
    }

    public void setPostsById(Collection<Post> postsById) {
        this.postsById = postsById;
    }

    @OneToMany(mappedBy = "catagoriesByCatId")
    public Collection<Topic> getTopicsById() {
        return topicsById;
    }

    public void setTopicsById(Collection<Topic> topicsById) {
        this.topicsById = topicsById;
    }
}
