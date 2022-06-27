package com.tangzq.model;

import com.sun.javafx.beans.IDProperty;
import com.tangzq.model.Catagories;
import com.tangzq.model.User_me;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Entity
public class Topic {
    private int id;
    private String title;
    private String desc;
    private String thumbUrl;
    private String tags;
    private String contentMd;
    private String contentHtml;
//    private Integer authorid;
    private boolean top;
    private boolean good;
    private boolean lock;
    private Integer replyCount;
    private Integer visitCount;
    private Integer collectCount;
    private Integer lastReplyId;
    private Timestamp lastReplyAt;
    private boolean contentIsHtml;
    private boolean deleted;
    private Integer catId;
    private Set<User_me> collectedUsers;
    private Set<User_me> likedUsers;
    private Date createdate;
    private User_me userByAuthorid;
    private com.tangzq.model.Catagories catagoriesByCatId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "desc", nullable = true, length = 50)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "thumbURL", nullable = true, length = 80)
    public String getThumbURL() {
        return thumbUrl;
    }

    public void setThumbURL(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    //  @Basic
 @Column(name = "tags", nullable = true, length = 100)
  /*
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Tag.class)
    @JoinTable(name = "tag", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "id")})
    */
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    @Basic
    @Column(name = "contentMD", nullable = true, length = 500)
    public String getcontentMd() {
        return contentMd;
    }

    public void setcontentMd(String contentMD) {
        this.contentMd = contentMd;
    }

    @Basic
    @Column(name = "contentHTML", nullable = true, length = 500)
    public String getContentHTML() {
        return contentHtml;
    }

    public void setContentHTML(String contentHtml) {
        this.contentHtml = contentHtml;
    }

 //   @OneToOne(targetEntity = User_me.class)
 //   @JoinTable(name = "user", joinColumns = {@JoinColumn(name = "id")})
//  @Column(name = "authorid", nullable = true)
  /*
   @Column(name = "authorid", nullable = true)
    public Set<Integer> getAuthorid() {
        return new Set<Integer>().add(userByAuthorid.getId());
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }
*/
    @Basic
    @Column(name = "top", nullable = true)
    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    @Basic
    @Column(name = "good", nullable = true)
    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    @Basic
    @Column(name = "lock", nullable = true)
    public boolean getLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Basic
    @Column(name = "replyCount", nullable = true)
    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    @Basic
    @Column(name = "visitCount", nullable = true)
    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    @Basic
    @Column(name = "collectCount", nullable = true)
    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    @Basic
    @Column(name = "lastReplyId", nullable = true)
    public Integer getLastReplyId() {
        return lastReplyId;
    }

    public void setLastReplyId(Integer lastReplyId) {
        this.lastReplyId = lastReplyId;
    }

    @Basic
    @Column(name = "lastReplyAt", nullable = true)
    public Timestamp getLastReplyAt() {
        return lastReplyAt;
    }

    public void setLastReplyAt(Timestamp lastReplyAt) {
        this.lastReplyAt = lastReplyAt;
    }

    @Basic
    @Column(name = "contentIsHTML", nullable = true)
    public boolean isContentIsHTML() {
        return contentIsHtml;
    }

    public void setContentIsHTML(boolean contentIsHtml) {
        this.contentIsHtml = contentIsHtml;
    }

    @Basic
    @Column(name = "deleted", nullable = true)
    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "catId", nullable = true)
    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

   // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = User_me.class)
  //  @JoinTable(name = "user", joinColumns = {@JoinColumn(name = "id")}, inverseJoinColumns = {@JoinColumn(name = "id")})
  //  @JoinTable(name = "user", joinColumns = {@JoinColumn(name = "id",referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "id")})
    // @Column(name = "collectedUsers", nullable = true, length = 500)
    /*
    public Set<User_me> getCollectedUsers() {
        return collectedUsers;
    }

    public void setCollectedUsers(Set<User_me> collectedUsers) {
        this.collectedUsers = collectedUsers;
    }
    */

/*

  @Basic
  @Column(name = "likedUsers", nullable = true, length = 500)
  public Set<User_me> getLikedUsers() {
    return likedUsers;
  }

  public void setLikedUsers(Set<User_me> likedUsers) {
    this.likedUsers = likedUsers;
  }*/

    @Basic
    @Column(name = "createdate", nullable = true)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return id == topic.id &&
                Objects.equals(title, topic.title) &&
                Objects.equals(desc, topic.desc) &&
                Objects.equals(thumbUrl, topic.thumbUrl) &&
             //   Objects.equals(tags, topic.tags) &&
                Objects.equals(contentMd, topic.contentMd) &&
                Objects.equals(contentHtml, topic.contentHtml) &&
                //Objects.equals(authorid, topic.authorid) &&
                Objects.equals(top, topic.top) &&
                Objects.equals(good, topic.good) &&
                Objects.equals(lock, topic.lock) &&
                Objects.equals(replyCount, topic.replyCount) &&
                Objects.equals(visitCount, topic.visitCount) &&
                Objects.equals(collectCount, topic.collectCount) &&
                Objects.equals(lastReplyId, topic.lastReplyId) &&
                Objects.equals(lastReplyAt, topic.lastReplyAt) &&
                Objects.equals(contentIsHtml, topic.contentIsHtml) &&
                Objects.equals(deleted, topic.deleted) &&
                Objects.equals(catId, topic.catId) &&
                Objects.equals(collectedUsers, topic.collectedUsers) &&
                Objects.equals(likedUsers, topic.likedUsers) &&
                Objects.equals(createdate, topic.createdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, desc, thumbUrl,/* tags,*/ contentMd, contentHtml,/* authorid,*/ top, good, lock, replyCount, visitCount, collectCount, lastReplyId, lastReplyAt, contentIsHtml, deleted, catId, collectedUsers, likedUsers, createdate);
    }

    @ManyToOne
    @JoinColumn(name = "authorid", referencedColumnName = "id")
    public User_me getUserByAuthorid() {
        return userByAuthorid;
    }

    public void setUserByAuthorid(User_me userByAuthorid) {
        this.userByAuthorid = userByAuthorid;
    }

//  @ManyToOne
//  @JoinColumn(name = "catId", referencedColumnName = "id")
//  public Catagories getCatagoriesByCatId() {
//    return catagoriesByCatId;
//  }

    public void setCatagoriesByCatId(Catagories catagoriesByCatId) {
        this.catagoriesByCatId = catagoriesByCatId;
    }
/*

    public String getAuthorName() {
        return userByAuthorid.getUsername();
    }

    public void setAuthorName(String authorName) {
        userByAuthorid.setUsername(authorName);
    }
*/

    public void setCatName(String name) {
        catagoriesByCatId.setName(name);
    }

    public void setCatDir(String catDir) {
        catagoriesByCatId.setCatDir(catDir);
    }


    public void setUpdated(java.util.Date date) {
        ;
        ;
    }



    public void setUpdateAt(Date date) {
        ;
        ;
    }
}
