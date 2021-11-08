package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;

@Repository
public class BaseballTeamRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<BaseballTeam> TEAM_ROW_MAPPER 
	 = (rs, i) -> {
		BaseballTeam team = new BaseballTeam();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	 };
	
	/**
	 * １チームの詳細情報検索
	 * @param id
	 * @return idで選ばれたテームの詳細情報
	 */
	public BaseballTeam load(Integer id) {
		String loadSql = "SELECT * FROM teams WHERE id = :id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		BaseballTeam team = template.queryForObject(loadSql, param, TEAM_ROW_MAPPER);
		
		return team;
	}
	/**
	 * 全チーム検索
	 * @return　全チーム情報
	 */
	public List<BaseballTeam> findAll() {
		String listSql = "SELECT * FROM teams ORDER BY inauguration";
		List<BaseballTeam> teamNameList = template.query(listSql, TEAM_ROW_MAPPER);
		
		return teamNameList;
	}
}
