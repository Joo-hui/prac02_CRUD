package com.sparta.prac02crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BoardResponseDto {

    private Long boardId;
    private String username;
    private String title;
    private String content;
    private LocalDateTime modifiedAt;
}
