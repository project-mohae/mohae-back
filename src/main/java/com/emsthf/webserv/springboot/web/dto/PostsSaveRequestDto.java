package com.emsthf.webserv.springboot.web.dto;

import com.emsthf.webserv.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Entity 클래스와 거의 유사한 형태임에도 불구하고 Dto 클래스로 추가한 이유
// => 절대로 Entity 클래스를 Request/Response 클래스로 사용하면 안되기 때문. Entity 클래스는 데이터베이스와 맞다은 핵심 클래스. Entity 클래스가 변경되면 여러 클래스에 영향을 끼치기 때문
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
