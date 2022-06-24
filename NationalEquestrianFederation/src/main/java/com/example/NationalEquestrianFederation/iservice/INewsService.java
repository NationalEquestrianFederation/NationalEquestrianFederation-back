package com.example.NationalEquestrianFederation.iservice;

import com.example.NationalEquestrianFederation.model.News;
import com.example.NationalEquestrianFederation.model.enums.NewsType;

import java.util.List;

public interface INewsService {

    List<News> findNewsByType(NewsType newsType);

    News addNews(News news, Integer user);

}
