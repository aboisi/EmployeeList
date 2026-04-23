package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserEditForm;

@Controller
@RequestMapping("/user")
public class UserEditController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** 編集画面を表示 */
	@GetMapping("/edit")
	public String getEditPage(@RequestParam("userId") String userId, Model model) {
		
		MUser user = userService.findByUserId(userId);
		model.addAttribute("user", user);
		
		return "user/edit";
	}
	
	/** ユーザー更新処理 */
	@PostMapping("/update")
	public String postUpdate(@ModelAttribute UserEditForm form, Model model) {
		
		// Form → Entityに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//更新処理
		userService.updateUserOne(
				user.getUserId(),
				user.getName(),
				user.getPassword(),
				user.getBirthday(),
				user.getGender()
				);
		
		// 一覧画面へリダイレクト
		return "redirect:/user/list";
	}
	
	/** ユーザー削除処理 */
	@PostMapping("/delete")
	public String deleteUser(UserEditForm form, Model model) {
		
		//ユーザーを削除
		userService.deleteUserOne(form.getUserId());
		
		//ユーザー一覧画面にリダイレクト
		return "redirect:/user/list";
	}
}