package study.springboot.service.board;

import study.springboot.controller.board.BoardForm;
import study.springboot.domain.board.Board;
import study.springboot.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    Board check(Integer boardId);
    List<Board> getBoardList();
    Optional<Board> getBoard(Integer boardId);

    List<Board> getBoardContainingTitle(String keyword);

    List<Board> getNormalBoards();

    List<Board> getUnNormalBoards();
    void updateBoard(BoardForm boardForm,Integer boardId);
    void deleteBoard(Integer boardId);

    void deleteAllBoard();

    void insertBoard(BoardForm boardForm, Member loginMember);
}
