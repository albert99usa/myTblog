package com.tangzq.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    private int id;
    private String name;
    private Timestamp created;
//    private Collection<TagOfPost> tagOfPostsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id == tag.id &&
                Objects.equals(name, tag.name) &&
                Objects.equals(created, tag.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created);
    }

 //   public Collection<TagOfPost> getTagOfPostsById() {
 //       return tagOfPostsById;
 //   }

//    public void setTagOfPostsById(Collection<TagOfPost> tagOfPostsById) {
//        this.tagOfPostsById = tagOfPostsById;
//    }
}
