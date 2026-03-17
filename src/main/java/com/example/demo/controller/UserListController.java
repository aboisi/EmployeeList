package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserListForm;

@Controller
@RequestMapping("/user")
public class UserListController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** 社員一覧画面を表示 */
	@GetMapping("/list")
	public String getUserList(@ModelAttribute UserListForm form, Model model) {

		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//ユーザー検索
		List<MUser> userList = userService.getUserList(user);
		
		//Modelに登録
		model.addAttribute("userList" , userList);
		
		//社員一覧画面を表示
		return "user/list";
	}
	
	/** 編集画面を表示 */
	@GetMapping("/edit")
	public String getEditPage(@RequestParam("userId") String userId, Model model) {
		
		MUser user = userService.findByUserId(userId);
		model.addAttribute("user", user);
		
		return "user/edit";
	}
}