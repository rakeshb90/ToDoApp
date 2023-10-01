package com.toDoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class ToDoWebController {
	
	@GetMapping("/")
	public ModelAndView greeting() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("index.html", mv);
		return mv;
	}

}
