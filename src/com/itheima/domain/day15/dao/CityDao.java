package com.itheima.domain.day15.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.day15.domain.City;
import com.yunhai.util.DataSourceUtils;

public class CityDao {

	public List<City> findCitiesByProvinceID(String provinceID) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from city where 1=1 and provinceID = ?";
		
		
		return queryRunner.query(sql,new BeanListHandler<>(City.class),provinceID);
	}

}
