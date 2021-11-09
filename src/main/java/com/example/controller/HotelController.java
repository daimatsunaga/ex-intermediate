package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.service.HotelService;

/**
 * ホテル検索を行う
 * @author matsunagadai
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	
	@RequestMapping("to-index")
	public String index() {
		return "hotel_index";
	}
	
	@RequestMapping("/search")
	public String search(Integer price, Model model) {
		model.addAttribute("price", price);
		if(price == null || price <= 300000 && price >= 0) {
			List<Hotel> hotelList = hotelService.search(price);
			model.addAttribute("hotelList", hotelList);
			return "hotel_index";
		}
			model.addAttribute("message", "0円~300,000円で検索してください");
			return "hotel_index";

	}
}
