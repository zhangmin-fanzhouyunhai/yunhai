package com.itheima.domain.day15.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.domain.day15.dao.KeyWordDao;

public class KeyWordService {

	/**
	 * ͨ���ؼ��ʲ�ѯ
	 * 
	 * @param kw
	 * @return
	 * @throws SQLException
	 */
	public List<Object> findKw4Ajax(String kw) throws SQLException {
		return new KeyWordDao().findKw4Ajax(kw);
	}
}
