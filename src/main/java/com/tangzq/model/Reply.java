package com.tangzq.model;

import com.tangzq.model.embed.ReplyAuthorInfo;

import javax.persistence.*;
import java.util.Date;
//import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tangzhiqiang
 */
//@Document(collection = "replys")
@Entity
@Table(name = "reply")
//public class Reply extends BaseModel<String> {
public class Reply {
    @Column(name = "contentMD")
    private String contentMD;
    @Column(name = "contentHTML")
    private String contentHTML;
    @Column(name = "topicid")
    private String topicid;

//   @OneToOne
 //  @JoinColumn(name = "authorInfo",referencedColumnName = "user")
    @Transient
    private ReplyAuthorInfo authorInfo;

    @Id
    @Column(name = "replyid")
    private String replyid;
    @Column(name = "contentishtml")
    private boolean contentishtml;
    @Column(name = "thumbsUPCount")
    private int thumbsUPCount;
    @Column(name = "deleted")
    private boolean deleted;
    @Column(name = "Updatedate")
     private Date Updatedate;
    @Column(name = "Createdate")
     private Date Createdate;

    public String getReplyId() {
        return this.replyid;
    }
    public void setReplyId(String replyid) {
        this.replyid = replyid;
    }

    public String getContentHTML() {
        return this.contentHTML;
    }
    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }

    public String getContentMD() {
        return this.contentMD;
    }
    public void setContentMD(String contentMD) {
        this.contentMD = contentMD;
    }

    public String getTopicid() {
        return this.topicid;
    }
    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    /*------------------------*/
    public boolean isContentIsHTML() {
        return this.contentishtml;
    }
    public void setContentIsHTML(boolean contentishtml) {
        this.contentishtml = contentishtml;
    }

    public void setThumbsUPCount(int thumbsUPCount) {
        this.thumbsUPCount = thumbsUPCount;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /*------------------------*/
    public Date getUpdatedate() {
        return this.Updatedate;
    }
    public void setUpdatedate(Date updatedate){
        Updatedate=updatedate;
    }


    public ReplyAuthorInfo getAuthorInfo(){
       return this.authorInfo;
    }
    public void setAuthorInfo(ReplyAuthorInfo info){
        this.authorInfo=info;
    }

    /*------------------------*/
    public String toString() {
        return "Reply(contentMD=" + this.getContentMD() +
                ", contentHTML=" + this.getContentHTML() +
                ", topicid=" + this.getTopicid() + ", replyid=" +
                this.getReplyId() +  ", contentishtml="
                + this.isContentIsHTML() +
                ", thumbsUPCount=" + this.getThumbsUPCount() +
                ", deleted=" + this.isDeleted() + ")";
    }







    public int getThumbsUPCount() {
        return this.thumbsUPCount;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    public Date getCreatedate() {
        return this.Createdate;
    }
    public void setCreatedate(Date date) {
         this.Createdate=date;
    }


//
//    @Override
//    public boolean isNew() {
//        return getId()==null;
//    }
}
