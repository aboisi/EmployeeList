package com.example.demo.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.application.service.UserApplicationService;
import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.form.UserEditForm;

@Controller
@RequestMapping("/user")
public class UserEditController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/** 編集画面を表示 */
	@GetMapping("/edit")
	public String getEditPage(@RequestParam("userId") String userId, Model model) {
		
		MUser user = userService.findByUserId(userId);
		model.addAttribute("user", user);
		
		//性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		
		return "user/edit";
	}
	
	/** ユーザー更新処理 */
	@PostMapping(value="/edit", params="update")
	public String postUpdate(
			@ModelAttribute UserEditForm form,
			RedirectAttributes redirectAttributes) {
		
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
		
		//URLに出さずにユーザーIDを渡す
		redirectAttributes.addFlashAttribute("userId", user.getUserId());
		
		// 更新完了画面へ
		return "redirect:/user/updateComp";
	}
	
	/** 更新完了画面 */
	@GetMapping("/updateComp")
	public String getSignupComp(
			@ModelAttribute("userId") String userId,
			Model model) {
		
		//更新・直アクセス対策
		if (userId == null || userId.isEmpty()) {
			
		    System.out.println("取得失敗");
		    
			return "redirect:/user/list";
		}
		
	    // DBから取得
	    MUser user = userService.findByUserId(userId);
	    model.addAttribute("user", user);
	    
	    System.out.println("取得成功");

		return "user/updateComp";
	}
	
	/** ユーザー削除処理 */
	@PostMapping(value="/edit", params="delete")
	public String deleteUser(UserEditForm form, Model model) {
		
		//ユーザーを削除
		userService.deleteUserOne(form.getUserId());
		
		//ユーザー一覧画面にリダイレクト
		return "redirect:/user/list";
	}
}