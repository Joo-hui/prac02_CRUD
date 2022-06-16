package com.sparta.prac02crud.service;

import com.sparta.prac02crud.dto.BoardRequestDto;
import com.sparta.prac02crud.dto.BoardResponseDto;
import com.sparta.prac02crud.model.Board;
import com.sparta.prac02crud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.convert.PeriodUnit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public ResponseEntity createBoard(BoardRequestDto boardRequestDto){
        Board board = new Board(boardRequestDto);
        boardRepository.save(board);
        return new ResponseEntity("저장 잘 됨", HttpStatus.OK);
    }

//    @Transactional
//    public List<Board> getBoards() {
//
//        return boardRepository.findAllByOrderByModifiedAtDesc();
//    }

    public List<BoardResponseDto> showBoard(){
        List<Board> boards = boardRepository.findAllByOrderByModifiedAtDesc();
        List<BoardResponseDto> boardResponseDtos = new ArrayList<>();

        for(Board board : boards){
            BoardResponseDto boardResponseDto = new BoardResponseDto(
             board.getBoardId(),
             board.getUsername(),
             board.getTitle(),
             board.getContent(),
             board.getModifiedAt()
            );
            boardResponseDtos.add(boardResponseDto);
        }
        return boardResponseDtos;
    }

    @Transactional
    public Board deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new IllegalArgumentException("게시물이 존재하지 않습니다."));
       boardRepository.delete(board);
        return board;
    }

    @Transactional
    public Board updateBoard(Long boardId, BoardRequestDto boardRequestDto){
        Board board = boardRepository.findById(boardId).orElseThrow(()-> new IllegalArgumentException("삭제할 게시물 없음"));
        board.update(boardRequestDto);
        boardRepository.save(board);
        return board;
    }

}
