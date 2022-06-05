package com.emsthf.webserv.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 엔티티 클래스에서는 절대 Setter 메소드를 만들지 않는다 => 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확히 구분이 어려워지기 때문. 차후 기능변경 시 정말 복잡해짐
// Setter가 없는 상황에서 어떻게 값을 채워 DB에 삽입하나? => 기본적인 구조는 생성자를 통해 최종값을 채운 후 DB에 삽입. 이번엔 생성자 대신 Builder 패턴을 사용할 것
@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false) // 컬럼 어노테이션을 붙이지 않아도 컬럼으로 생성되지만 기본값 이외에 추가로 변경이 필요한 옵션이 있을 경우 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
