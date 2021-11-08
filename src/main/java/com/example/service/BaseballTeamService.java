package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;
/**
 * チーム検索のサービスクラス
 * @author matsunagadai
 *
 */
@Service
public class BaseballTeamService {
	
	@Autowired
	private BaseballTeamRepository teamRepository;
	
	public BaseballTeam load(Integer id) {
		BaseballTeam team = teamRepository.load(id);
		return team;
	}
	
	public List<BaseballTeam> findAll() {
		List<BaseballTeam> teamNameList = teamRepository.findAll();
		return teamNameList;
	}
}
