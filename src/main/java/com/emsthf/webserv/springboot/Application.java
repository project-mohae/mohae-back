package com.emsthf.webserv.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트의 자동 설정, Bean 읽기와 생성
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // run으로 내장 WAS를 실행
    }
}
