package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;
/**
 * ホテル検索のためのレポジトリクラス
 * @author matsunagadai
 *
 */
@Repository
public class HotelRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER 
	=(rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	/**
	 * priceによるホテル検索
	 * @param price
	 * @return ホテルのリスト一覧
	 */
	public List<Hotel> search(Integer price) {
		if (price == null) {
			String sql = "SELECT * FROM hotels;";
			List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
			return hotelList;
		} else {
			String sql = "SELECT * FROM hotels WHERE price <= :price;";
			SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
			List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
			return hotelList;
		}
	}
}
