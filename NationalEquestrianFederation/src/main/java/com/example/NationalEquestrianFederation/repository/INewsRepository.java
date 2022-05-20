package com.example.NationalEquestrianFederation.repository;

import com.example.NationalEquestrianFederation.model.News;
import com.example.NationalEquestrianFederation.model.enums.NewsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INewsRepository extends JpaRepository<News, Integer> {

    @Query("SELECT n FROM News n WHERE n.newsType = ?1 ORDER BY n.date")
    List<News> findNewsByType(NewsType newsType);

}
