package com.itheima.domain.day15.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.day15.dao.ProvinceDao;
import com.itheima.domain.day15.domain.Province;

public class ProvinceService {

	public List<Province> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return new ProvinceDao().findAll();
	}

}
