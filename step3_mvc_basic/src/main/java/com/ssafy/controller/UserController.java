package com.ssafy.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService useService) {
		super();
		this.userService = useService;
	}


	@PostMapping("/login.do")
	private String login(@RequestParam Map<String, String> user, HttpSession sesstion, Model model) throws SQLException {
		String name = userService.login(user);
		
		if(name != null) {
			sesstion.setAttribute("userName", name);
			sesstion.setAttribute("userId", user.get("userId"));
			
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg", "아이디 또는 비밀번호 올바르지 X");
			return "login";
		}
	}
	
//	@PostMapping("/login.do")
//	private String login(@RequestParam("userId") String userId, @RequestParam("password") String password, HttpSession sesstion, Model model) throws SQLException {
//		String name = userService.login(userId, password);
//		
//		if(name != null) {
//			sesstion.setAttribute("userName", name);
//			sesstion.setAttribute("userId", userId);
//			
//			return "redirect:/";
//		}else {
//			model.addAttribute("errorMsg", "아이디 또는 비밀번호 올바르지 X");
//			return "login";
//		}
//	}
	
	@GetMapping("/logout.do")
	private String login(HttpSession sesstion) throws SQLException {
		sesstion.invalidate();
		return "redirect:/";
	}
}
