package com.tangzq.service;

import com.tangzq.model.Reply;
import com.tangzq.vo.ReplyVo;

import java.util.List;

/**
 * @author tangzhiqiang
 */
public interface ReplyService {


    /**
     * 取得指定評論內容
     * @param replyID
     * @return
     */
    Reply getReply(String replyID);


    /**
     * 新增評論
     * @param vo
     * @return
     */
    Reply addReply(ReplyVo vo);


    /**
     * 更新評論內容
     * @param replyId
     * @param contentMD
     * @param contentHTML
     * @return
     */
    Reply updateReplyContent(String replyId, String contentMD, String contentHTML);


    /**
     * 查找指定文章的評論
     * @param topicId
     * @return
     */
    List<Reply> findReplyByTopicId(String topicId);


    /**
     * 刪除評論
     * @param replyId
     * @param topicId
     */
    void deleteReply(String replyId, String topicId);
}

