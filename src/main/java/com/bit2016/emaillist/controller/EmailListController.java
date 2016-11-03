package com.bit2016.emaillist.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.bit2016.emaillist.dao.*;
import com.bit2016.emaillist.vo.*;


@Controller
public class EmailListController {
	@Autowired
	private EmailListDao emailListDao;
	
	@RequestMapping("/form")
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute EmailListVo vo) {
		emailListDao.insert(vo);
		
		return "redirect:/";
	}

	@RequestMapping("")
	public String list(Model model) {
		List<EmailListVo> list = emailListDao.getList();
		model.addAttribute("list", list);
		
		return "/WEB-INF/views/list.jsp";
	}
}
