package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserEditController {
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private ModelMapper modelMapper;
	
	/** 編集画面を表示 */
	@GetMapping("/edit")
	public String getEditPage(@RequestParam("userId") String userId, Model model) {
		
		MUser user = userService.findByUserId(userId);
		model.addAttribute("user", user);
		
		return "user/edit";
	}
	
}