package com.example.NationalEquestrianFederation.mapper;

import com.example.NationalEquestrianFederation.dto.NewsDto;
import com.example.NationalEquestrianFederation.model.News;
import com.example.NationalEquestrianFederation.model.enums.NewsType;

import java.util.Date;

public class NewsMapper {

    public static News convertToNews(NewsDto dto) {
        News news = new News();
        news.setTitle(dto.getTitle());
        news.setContent(dto.getContent());
        news.setNewsType(NewsType.valueOf(dto.getNewsType()));
        news.setDate(new Date());
        return news;
    }

}
