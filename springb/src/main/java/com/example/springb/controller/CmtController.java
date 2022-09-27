package com.example.springb.controller;

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

}
