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
        cmtService.cmtDelete(cmtIdx);
        return "redirect:/board/list";
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
        return "redirect:/board/list";
    }

}
