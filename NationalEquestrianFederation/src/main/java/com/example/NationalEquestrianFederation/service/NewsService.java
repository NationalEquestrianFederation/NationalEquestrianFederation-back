package com.example.NationalEquestrianFederation.service;

import com.example.NationalEquestrianFederation.iservice.INewsService;
import com.example.NationalEquestrianFederation.model.News;
import com.example.NationalEquestrianFederation.model.Organization;
import com.example.NationalEquestrianFederation.model.enums.NewsType;
import com.example.NationalEquestrianFederation.repository.INewsRepository;
import com.example.NationalEquestrianFederation.repository.IOrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class NewsService implements INewsService {

    private final INewsRepository newsRepository;

    private final IOrganizationRepository organizationRepository;

    @Override
    public List<News> findNewsByType(NewsType newsType) {
        return newsRepository.findNewsByType(newsType);
    }

    @Override
    public News addNews(News news, Integer user) {
        Organization organization = organizationRepository.getOrganizationByUser(user);
        news.setOrganization(organization);
        return newsRepository.save(news);
    }
}
