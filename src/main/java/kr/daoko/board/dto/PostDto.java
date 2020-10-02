package kr.daoko.board.dto;

import kr.daoko.board.domain.entity.Post;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class PostDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Post toEntity() {
        Post build = Post.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();

        return build;
    }

    @Builder
    public PostDto(Long id, String author, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
