package com.itheima.domain.day15.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.day15.dao.CityDao;
import com.itheima.domain.day15.domain.City;

public class CityService {

	public List<City> findCitiesByProvinceID(String provinceID) throws SQLException {
		// TODO Auto-generated method stub
		return new CityDao().findCitiesByProvinceID(provinceID);
	}

}
