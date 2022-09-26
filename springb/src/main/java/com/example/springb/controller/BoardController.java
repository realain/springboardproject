package com.example.springb.controller;

import com.example.springb.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String boardDetail(@RequestParam("bIdx")int bIdx , Model model){
        model.addAttribute("bIdx",boardService.findById(bIdx));
        model.addAttribute("uName",boardService.findUserName(bIdx));
        return "board/detail";
    }
    @GetMapping("/delete")
    public String boardDelete(@RequestParam("bIdx")int bIdx, RedirectAttributes resultMsg){
        boardService.boardDelete(bIdx);
        resultMsg.addFlashAttribute("result","delete success");
        return "redirect:/board/list";
    }
}
