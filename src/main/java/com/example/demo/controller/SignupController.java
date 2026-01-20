package com.example.demo.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.SignupForm;

@Controller
@RequestMapping("/user")
public class SignupController{
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** ユーザー登録画面を表示 */
	@GetMapping("/signup")
	public String getSignup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		//性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		//ユーザー登録画面に遷移
		return "user/signup";
	}
	
	/** ユーザー登録処理 */
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute @Validated SignupForm form,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			Model model) {
		
		//入力チェック
		if(bindingResult.hasErrors()) {
			//性別再取得
			model.addAttribute("genderMap", userApplicationService.getGenderMap());
			//NG:ユーザー登録画面に戻る
			return "user/signup";
		}
		
		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//ユーザー登録処理(DB保存+社員生成)
		userService.signup(user);
		
		//URLに出さずにデータを渡す
		redirectAttributes.addFlashAttribute("user", user);
		
		//登録完了画面へ
		return "redirect:/user/signupComp";
	}
	
	/** 登録完了画面 */
	@GetMapping("/signupComp")
	public String getSignupComp() {

		return "user/signupComp";
	}
}
