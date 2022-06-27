package com.tangzq.service;

import com.tangzq.model.Topic;
import com.tangzq.vo.IndexVo;
import com.tangzq.vo.SearchVo;
import com.tangzq.vo.TopicVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author tangzhiqiang
 */
public interface TopicService {

    /**
     * 分頁查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Topic> findByPage(int pageNo, int pageSize);

    /**
     * 指定用戶文章
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Topic> findByUserIdAndPage(String userId, int pageNo, int pageSize);

    /**
     * 指定用戶創建的文章
     * @param username
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Topic> findByUsernameAndPage(String username, int pageNo, int pageSize);

    /**
     * 含有指定標籤的文章
     * @param tagName
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Topic> findByTagAndPage(String tagName, int pageNo, int pageSize);

    /**
     * 首頁分頁查找
     * @param vo
     * @return
     */
    Page<Topic> findByPage(IndexVo vo);


    /**
     * 關鍵字分頁查找
     * @param searchVo
     * @return
     */
    Page<Topic> search(SearchVo searchVo);


    /**
     * 新增文章
     * @param vo
     * @return
     */
    Topic addTopic(TopicVo vo);


    /**
     * 查找指定文章
     * @param topicId
     * @return
     */
    Topic findTopicById(String topicId);


    /**
     * 查找指定文章,並轉換成vo類
     * @param topicId
     * @return
     */
    TopicVo findTopicVoById(String topicId);


    /**
     * 更新文章資訊
     * @param vo
     * @param id
     * @return
     */
    Topic updateById(TopicVo vo, String id);


    /**
     * 刪除文章
     * @param topicId
     */
    void deleteById(String topicId);

    /**
     * 更新訪問次數
     * @param topicId
     */
    void increaseVisitCount(String topicId);

    /**
     * 更新評論次數
     * @param topicId
     */
    void increaseReplyCount(String topicId);

    /**
     * 減少評論次數
     * @param topicId
     */
    void decreaseReplyCount(String topicId);

    /**
     * 收藏文章
     * @param topicId
     * @param userId
     * @return
     */
    Topic addCollection(String topicId, String userId);


    /**
     * 取消收藏
     * @param topicId
     * @param userId
     * @return
     */
    Topic removeCollection(String topicId, String userId);

    /**
     * 喜歡文章
     * @param topicId
     * @param userId
     * @return
     */
    Topic like(String topicId, String userId);


    /**
     * 不喜歡收藏
     * @param topicId
     * @param userId
     * @return
     */
    Topic unLike(String topicId, String userId);


    /**
     * 用戶收藏的所有文章
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Topic> findCollectedTopicsByUidAndPage(String userId, int pageNo, int pageSize);

    /**
     * 查找所有文章
     * @return
     */
    List<Topic> findAll(int pageSize);


}

