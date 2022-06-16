package com.sparta.prac02crud.model;

import com.sparta.prac02crud.dto.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Board extends Timestamped{

    @Id
    @GeneratedValue
    private Long boardId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    public Board(BoardRequestDto boardRequestDto) {
        this.username = boardRequestDto.getUsername();
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
    }

    public void update(BoardRequestDto boardRequestDto){
        this.content = boardRequestDto.getContent();
        this.title = boardRequestDto.getTitle();
    }

}
