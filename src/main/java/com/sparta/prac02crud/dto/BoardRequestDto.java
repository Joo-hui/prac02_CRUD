package com.sparta.prac02crud.dto;

import lombok.Getter;

@Getter //이걸 밖으로 빼서 쓸 수 있게 하는 어노테이션
public class BoardRequestDto {

    private String username;
    private String title;
    private String content;

}
