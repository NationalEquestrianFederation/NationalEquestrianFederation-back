package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.INewsService;
import com.example.NationalEquestrianFederation.model.News;
import com.example.NationalEquestrianFederation.model.enums.NewsType;
import com.example.NationalEquestrianFederation.repository.INewsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService implements INewsService {

    private final INewsRepository newsRepository;

    @Override
    public List<News> findNewsByType(NewsType newsType) {
        return newsRepository.findNewsByType(newsType);
    }

    @Override
    public News addNews(News newNews) {
        return newsRepository.save(newNews);
    }
}
