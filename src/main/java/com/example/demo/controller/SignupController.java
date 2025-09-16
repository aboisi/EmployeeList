package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SignupController{
	
//	UserApplicationService未実装
//	@Autowierd
//	private UserApplicationService userApplicationService;
//	
//	/** ユーザー登録画面を表示 */
//	@GetMapping("/signup")
//	public String getSignup(Model model) {
//		//性別を取得
//		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
//		model.addAttribute("genderMap", genderMap);
//		
//		//ユーザー登録画面に遷移
//		return "user/signup";
//	}
	
	/** ユーザー登録処理 */
	@PostMapping("/signup")
	public String postSignup() {
		//ログイン画面にリダイレクト
		return "redirect:/login";
	}
}