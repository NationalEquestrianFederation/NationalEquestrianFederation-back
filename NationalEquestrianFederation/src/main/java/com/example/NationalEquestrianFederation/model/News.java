package com.example.NationalEquestrianFederation.model;

import com.example.NationalEquestrianFederation.model.enums.NewsType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @Id
    @Column(name = "news_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "news_type")
    private NewsType newsType;

    @ManyToOne(optional = false, targetEntity = Organization.class, cascade = CascadeType.MERGE)
    private Organization organization;

    @Column(name = "date")
    private Date date;

}
