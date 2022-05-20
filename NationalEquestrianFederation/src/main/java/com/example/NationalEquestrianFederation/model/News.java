package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.NewsType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "news")
@Data
public class News {

    @Id
    @Column(name = "news_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Column(name = "title")
    @Getter @Setter private String title;

    @Column(name = "content")
    @Getter @Setter private String content;

    @Column(name = "news_type")
    @Getter @Setter private NewsType newsType;

    @Column(name = "posted_by")
    @Getter @Setter private Integer postedBy;

}
