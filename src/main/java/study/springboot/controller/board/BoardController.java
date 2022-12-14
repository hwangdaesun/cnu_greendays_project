package study.springboot.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.springboot.controller.member.SessionConstants;
import study.springboot.domain.board.Board;
import study.springboot.domain.member.Member;
import study.springboot.service.board.BoardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    //전체 게시물
    public String getBoardList(Model model, @SessionAttribute(SessionConstants.LOGIN_MEMBER)Object loginMember){
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boards",boardList);
        model.addAttribute("member", loginMember);
        return "boards/main";
    }

    @GetMapping("/boardPage")
    public String getBoardForm(Model model,@SessionAttribute(SessionConstants.LOGIN_MEMBER)Object loginMember){
        model.addAttribute("member",loginMember);
        return "boards/boardPage";
    }

    @PostMapping("/newBoard")
    public <loginMember> String writeBoard(@ModelAttribute BoardForm boardForm, @SessionAttribute(SessionConstants.LOGIN_MEMBER)Object loginMember){
        boardService.insertBoard(boardForm,(Member)loginMember);
        return "redirect:";
    }

    @GetMapping("/{no}")
    public String getDetailBoard(@PathVariable("no") Integer boardId,Model model){
        Board board = boardService.getBoard(boardId).get();
        model.addAttribute("board",board);
        return "boards/detail";
    }

    @GetMapping("/board")
    public String findByBoardContainingTitle(@RequestParam(value="keyword")String keyword,Model model,@SessionAttribute(SessionConstants.LOGIN_MEMBER)Object loginMember){
        model.addAttribute("member",loginMember);
        List<Board> boardContainingTitle = boardService.getBoardContainingTitle(keyword);
        model.addAttribute("boards",boardContainingTitle);
        return "boards/main";
    }

    @GetMapping("/boardPage/{no}")
    public String getUpdateBoardForm(@PathVariable("no") Integer boardId,Model model,@SessionAttribute(SessionConstants.LOGIN_MEMBER)Object loginMember){
        Board board = boardService.getBoard(boardId).get();
        model.addAttribute("member",loginMember);
        model.addAttribute("board",board);
        return "boards/update";
    }

    @PutMapping("/{no}")
    public String updateBoard(@PathVariable("no") Integer boardId,@ModelAttribute BoardForm boardForm){
        boardService.updateBoard(boardForm,boardId);
        return "redirect:" +boardId;
    }

    @DeleteMapping("/{no}")
    public String deleteBoard(@PathVariable("no") Integer boardId){
        boardService.deleteBoard(boardId);
        return "redirect:";
    }

}
