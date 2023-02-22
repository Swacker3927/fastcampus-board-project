package com.fastcampus.boardproject.domain.dto;

import com.fastcampus.boardproject.domain.Article;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.fastcampus.boardproject.domain.Article} entity
 */
public record ArticleDto(
        Long id,
        String title,
        UserAccountDto userAccountDto,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ArticleDto of(Long id, String title, UserAccountDto userAccountDto, String content, String hashtag, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleDto(id, title, userAccountDto, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                entity.getTitle(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Article toEntity() {
        return Article.of(
                title,
                userAccountDto.toEntity(),
                content,
                hashtag
        );
    }
}
