package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 衣類情報検索のサービスクラス
 * @author matsunagadai
 *
 */
@Service
public class ClothService {

	@Autowired
	private ClothRepository clothRepository;
	/**
	 * 性別と色による衣類検索
	 * @param gender
	 * @param color
	 * @return 検索された衣類情報
	 */
	public List<Cloth> search(String gender, String color) {
		List<Cloth> clothList = clothRepository.search(gender, color);
		return clothList;
	}
}
