package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテル検索のサービスクラス
 * @author matsunagadai
 *
 */
@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public List<Hotel> search(Integer price) {
		return hotelRepository.search(price);
	}
}
