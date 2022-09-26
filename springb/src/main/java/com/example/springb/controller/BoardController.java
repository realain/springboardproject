package com.example.springb.controller;

import com.example.springb.domain.BoardVo;
import com.example.springb.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String boardList(Model model){
        model.addAttribute("bIdx", boardService.boardNum());
        model.addAttribute("bList", boardService.boardList());
        return "board/list";
    }
    @GetMapping("/detail")
    public String boardDetail(@RequestParam("bIdx")int bIdx , Model model)throws Exception{
        model.addAttribute("bIdx",boardService.findById(bIdx));
        model.addAttribute("uName",boardService.findUserName(bIdx));
        return "board/detail";
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String boardDelete(@RequestParam("bIdx")int bIdx, RedirectAttributes resultMsg)throws Exception{
        boardService.boardDelete(bIdx);
        resultMsg.addFlashAttribute("result","delete success");
        return "redirect:/board/list";
    }
    @GetMapping("/modifyForm")
    public String boardModifyForm(@RequestParam("bIdx")int bIdx, Model model)throws Exception{
        model.addAttribute("board",boardService.findById(bIdx));
        model.addAttribute("uName",boardService.findUserName(bIdx));
        return "/board/modifyForm";
    }
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String boardModify(BoardVo boardVo) throws Exception{

        boardService.boardModify(boardVo);

        return "redirect:/board/list";
    }
}
