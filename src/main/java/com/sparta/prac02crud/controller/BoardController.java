package com.sparta.prac02crud.controller;

import com.sparta.prac02crud.dto.BoardRequestDto;
import com.sparta.prac02crud.dto.BoardResponseDto;
import com.sparta.prac02crud.model.Board;
import com.sparta.prac02crud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseEntity creatBoards(@RequestBody BoardRequestDto requestDto) {

        return ResponseEntity.ok().body(boardService.createBoard(requestDto));
    }

//    @GetMapping("/api/boards")
//    public List<Board> getBoards() {
//
//        return boardService.getBoards();
//    }

    @GetMapping("/api/boards")
    public List<BoardResponseDto> getBoard() {
        return boardService.showBoard();
    }

    @DeleteMapping("/api/boards/{boardId}")
    public Board deleteBoard(@PathVariable Long boardId) {
        return boardService.deleteBoard(boardId);
    }


    @PutMapping("/api/boards/{boardId}")
    public Board updateBoard(@PathVariable Long boardId, @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.updateBoard(boardId, boardRequestDto);

    }


}
