package com.example.springb.controller;

import com.example.springb.domain.CmtVo;
import com.example.springb.service.CmtService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cmt")
public class CmtController {

    private CmtService cmtService;

    public CmtController(CmtService cmtService) {
        this.cmtService = cmtService;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String cmtDelete(@RequestParam("cIdx")int cmtIdx)throws Exception{
        CmtVo cmtVo = cmtService.findById(cmtIdx);
        int bIdx = cmtVo.getBoardIdx();
        cmtService.cmtDelete(cmtIdx);
        return "redirect:/board/detail?bIdx="+bIdx;
    }
    @GetMapping("/modifyForm")
    public String cmtModifyForm(@RequestParam("cIdx")int cmtIdx, Model model)throws Exception{
        model.addAttribute("cmt",cmtService.findById(cmtIdx));
        model.addAttribute("uName",cmtService.findUserName(cmtIdx));
        return "cmt/modifyForm";
    }
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String cmtModify(CmtVo cmtVo)throws Exception{
        cmtService.cmtModify(cmtVo);
        int bIdx = cmtVo.getBoardIdx();
        return "redirect:/board/detail?bIdx="+bIdx;
    }
    @GetMapping("/cInsertForm")
    public String cInsertForm(@RequestParam("cIdx")int cmtIdx, Model model)throws Exception{
        model.addAttribute("cmt",cmtService.findById(cmtIdx));
        model.addAttribute("uName",cmtService.findUserName(cmtIdx));
        return "cmt/cInsertForm";
    }
    @RequestMapping(value = "/cInsert", method = RequestMethod.POST)
    public String cInsert(CmtVo cmtVo)throws Exception{
        cmtService.cInsert(cmtVo);
        int bIdx = cmtVo.getBoardIdx();
        return "redirect:/board/detail?bIdx="+bIdx;
    }
    @RequestMapping(value = "/cmtInsert", method = RequestMethod.POST)
    public String cmtInsert(CmtVo cmtVo)throws Exception{
        cmtService.cmtInsert(cmtVo);
        int bIdx = cmtVo.getBoardIdx();
        return "redirect:/board/detail?bIdx="+bIdx;
    }
}
