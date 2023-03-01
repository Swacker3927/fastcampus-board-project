package com.fastcampus.boardproject.domain.dto.request;

import com.fastcampus.boardproject.domain.dto.*;

public record ArticleRequest(String title, String content, String hashtag) {
    public static ArticleRequest of(String title, String content, String hashtag) {
        return new ArticleRequest(title, content, hashtag);
    }

    public ArticleDto toDto(UserAccountDto userAccountDto) {
        return ArticleDto.of(title, userAccountDto, content, hashtag);
    }
}