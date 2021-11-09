package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.service.ClothService;

@Controller
@RequestMapping("/cloth")
public class ClothController {
	
	@Autowired
	private ClothService clothService;

	@RequestMapping("/to-index")
	public String index() {
		return "cloth_index";
	}
	
	@RequestMapping("/search")
	public String search(Integer gender, String color, Model model) {
		System.out.println(color);
		System.out.println(gender);
		List<Cloth> clothList = clothService.search(gender, color);
		model.addAttribute("clothList", clothList);
		return "cloth_index";
	}
}
