package com.tangzq.service;

import com.tangzq.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author tangzhiqiang
 */
public interface CategoryService {

    /**
     * 新增分類
     * @param cat
     * @return
     */
    Category addCategory(Category cat);


    /**
     * 使用分類ID找到分類資訊
     * @param id
     * @return
     */
    Category findById(String id);

    /**
     * 分頁查找
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Category> findByPage(int pageNo, int pageSize);

    /**
     * 找到所有分類資訊
     * @return
     */
    List<Category> findAll();

    /**
     * 判斷分類是否已經存在
     * @param catDir
     * @return
     */
    boolean isCategoryExisted(String catDir);


    /**
     * 更新分類資訊
     * @param cat
     * @param id
     * @return
     */
    Category updateById(Category cat, String id);


    /**
     * 刪除指定分類
     * @param id
     * //TODO 刪除分類同時也要刪除該分類下文章
     */
    void deleteCategory(String id);
}

