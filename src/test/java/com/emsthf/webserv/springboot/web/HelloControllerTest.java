package com.emsthf.webserv.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@WebMvcTest(controllers = HelloController.class) // 컨트롤러를 사용할 수 있는 테스트 어노테이션
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈 주입
    private MockMvc mvc; // 웹 api를 테스트 할 때 사용. 스프링 mvc 테스트의 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // 해당 주소로 get 요청
                .andExpect(status().isOk()) // 응답 상태가 200인지
                .andExpect(content().string(hello)); // 응답 내용이 "hello"인가
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount))) // 테스트 요청 파라미터 설정. 값은 String만 가능하므로 다른 타입은 문자열로 바꿔줘야 함
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //json 응답값을 필드별로 검증. $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
