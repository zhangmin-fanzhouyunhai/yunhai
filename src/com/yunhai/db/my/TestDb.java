package com.yunhai.db.my;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDb {
	public static void main(String[] args) throws SQLException {
		//创建连接池
		MyDatabaseSource md=new MyDatabaseSource();
		//
		Connection conn=md.getConnection();
		
		
		//
		System.out.println(conn);
		//归还连接
		//md.addBack(conn);
		conn.close();
		
	}
	public void dVersionAdd(Connection conn) {
		String dataVersion = "O_2019_2";
        String targetTable="ORI_WORK_TICKET";
 		String dataType="O";
 		Short yearValue=2019;
 		Short subVersion=1;
 		String versionStatus="1";
 		String parentVersion="";
		String sql="insert into d_version(DATA_TYPE,VERSION_VALUE,YEAR_VALUE,"
				+ "SUB_VERSION,VERSION_STATUS,TARGET_TABLE,PARENT_VERSION,GENERATE_DATE,VERSION_ID)" 
				+ " values(?,?,?,?,?,?,?,?,?)";
		sql="insert into d_version(DATA_TYPE,VERSION_VALUE,YEAR_VALUE,"
				+ "SUB_VERSION,VERSION_STATUS,TARGET_TABLE,PARENT_VERSION,GENERATE_DATE)" 
				+ " values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st=conn.prepareStatement(sql);
			// 设置参数
			st.setString(1, dataType);
			st.setString(2, dataVersion);
			st.setShort(3, yearValue);
			st.setShort(4, subVersion);
			st.setString(5, versionStatus);
			st.setString(6, targetTable);
			st.setString(7, parentVersion);
			st.setDate(8, new Date(2021, 01, 16));
			//st.setString(9, "123212785"+new java.util.Date().toString());
			// 执行sql
			int i = st.executeUpdate();
			// 处理结果
			if (i==1) {
				System.out.println("success");
			}else {
				System.out.println("fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
