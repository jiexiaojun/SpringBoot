package com.allen.web;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.allen.entity.UserForJPA;
import com.allen.service.UserService;

@Controller
public class UserController {

	@Resource
	UserService userService;


	@RequestMapping("/")
	// http://localhost:8080
	public String index() {
		return "redirect:/list";
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<UserForJPA> users = userService.getUserList();
		model.addAttribute("users", users);
		return "user/list";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "user/userAdd";
	}

	@RequestMapping("/add")
	public String add(UserForJPA user) {
		userService.save(user);
		return "redirect:/list";
	}

	@RequestMapping("/toEdit")
	public String toEdit(Model model, Long id) {
		UserForJPA user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user/userEdit";
	}

	@RequestMapping("/edit")
	public String edit(UserForJPA user) {
		userService.edit(user);
		return "redirect:/list";
	}


	@RequestMapping("/delete")
	public String delete(Long id) {
		userService.delete(id);
		return "redirect:/list";
	}
}
