package com.tangzq.repository;

import com.tangzq.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 分類文檔操作類
 * @author tangzhiqiang
 */
@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,String> {

    /**
     * 目錄名字必須唯一
     * @param catDir 分類英文目錄名稱
     * @return
     */
    Category findByid(Long id);
    // List<Category> findByCatDir(String catDir);
    List<Category> findByName(String Name);

    List<Category> findBycatdir(String catdir);

    Optional<Category> findById(long parseLong);
}

