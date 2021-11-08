package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;

@Controller
@RequestMapping("/team")
public class BaseballTeamController {
	
	@Autowired
	private BaseballTeamService teamService;
	
	@RequestMapping("/list")
	public String index(Model model) {
		List<BaseballTeam> teamList = teamService.findAll();
		model.addAttribute("teamList",teamList);
		return "index";
	}
	
	@RequestMapping("/detail")
	public String detail(Integer id, Model model) {
		BaseballTeam team = teamService.load(id);
		model.addAttribute("team", team);
		return"detail";
	}
}
