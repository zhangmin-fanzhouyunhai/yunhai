package com.itheima.domain.day15.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.day15.domain.Province;
import com.yunhai.util.DataSourceUtils;

public class ProvinceDao {

	public List<Province> findAll() throws SQLException {
		// TODO Auto-generated method stub 
		QueryRunner queryRunner= new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from province";
		
		return queryRunner.query(sql, new BeanListHandler<>(Province.class));
	}

}
