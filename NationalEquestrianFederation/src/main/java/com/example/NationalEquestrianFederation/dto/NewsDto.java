package com.example.NationalEquestrianFederation.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsDto {

    @Getter @Setter private String title;

    @Getter @Setter private String content;

    @Getter @Setter private String newsType;

    @Getter @Setter private Integer postedBy;

}
