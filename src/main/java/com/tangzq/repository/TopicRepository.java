package com.tangzq.repository;

import com.tangzq.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * 文章操作類
 * @author tangzhiqiang
 */
@Repository

//public interface TopicRepository extends PagingAndSortingRepository<Topic,String> {
public interface TopicRepository  extends CrudRepository<Topic, String> {

    /**
     * 查找指定用戶的文章
     * @param authorId
     * @return
     */
    //  Page<Topic> findByauthorid(String authorId,Pageable pageable);

    Page<Topic> findAll(Pageable pageable);


    //  Page<Topic> findByAuthorName(String username, Pageable pageable);

    Page<Topic> findByTagsContains(String tagName, Pageable pageable);

    Page<Topic> findByCatDir(String tab, Pageable pageable);

    Page<Topic> findByTitleLikeOrDescLike(String keywords, String keywords1, Pageable pageable);

    Page<Topic> findByCollectedUsersContains(String userId, Pageable pageable);

    /**
     * 查找指定用戶的文章
     * @param authorName
     * @param pageable
     * @return
     */
    //   Page<Topic> findByAuthorName(String authorName, Pageable pageable);

    /**
     * 查找含有指定標籤的文章
     * @param tagName
     * @param pageable
     * @return
     */
    //   Page<Topic> findByTagsContains(String tagName, Pageable pageable);

    /**
     * 按欄目分類查找
     * @param catDir
     * @param pageable
     * @return
     */
    //  Page<Topic> findByCatDir(String catDir, Pageable pageable);

    /**
     * 標題模糊查詢
     * @param title
     * @param pageable
     * @return
     */
    //  Page<Topic> findByTitleLike(String title, Pageable pageable);


    /**
     * 在標題標題或者摘要模糊查詢
     * @param title
     * @param desc
     * @param pageable
     * @return
     */
    //   Page<Topic> findByTitleLikeOrDescLike(String title, String desc, Pageable pageable);


    /**
     * 指定用戶收藏的所有文章
     * @param userId
     * @param pageable
     * @return
     */
    //   Page<Topic> findByCollectedUsersContains(String userId, Pageable pageable);

    /**
     * 在標題標題或者摘要模糊查詢
     * @param words 關鍵字
     * @param page
     * @return
     */
    //   @Query(value = "{ $or: [ { 'title' : {$regex:?0,$options:'i'} }, { 'desc' : {$regex:?0,$options:'i'} } ] }")
//    Page<Topic> likeQuery(String words, Pageable page);

}

