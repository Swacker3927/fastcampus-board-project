package com.fastcampus.boardproject.dto;

import com.fastcampus.boardproject.domain.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A DTO for the {@link com.fastcampus.boardproject.domain.Article} entity
 */
public record ArticleDto(
        Long id,
        String title,
        UserAccountDto userAccountDto,
        String content,
        Set<HashtagDto> hashtagDtos,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {
    public static ArticleDto of(String title, UserAccountDto userAccountDto, String content, Set<HashtagDto> hashtagDtos) {
        return new ArticleDto(null, title, userAccountDto, content, hashtagDtos, null, null, null, null);
    }

    public static ArticleDto of(Long id, String title, UserAccountDto userAccountDto, String content, Set<HashtagDto> hashtagDtos, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleDto(id, title, userAccountDto, content, hashtagDtos, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                entity.getTitle(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getContent(),
                entity.getHashtags().stream()
                        .map(HashtagDto::from)
                        .collect(Collectors.toUnmodifiableSet())
                ,
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Article toEntity(UserAccount userAccount) {
        return Article.of(
                title,
                userAccount,
                content
        );
    }
}
