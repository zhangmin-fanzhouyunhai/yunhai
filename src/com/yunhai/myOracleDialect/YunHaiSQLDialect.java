package com.yunhai.myOracleDialect;

import org.hibernate.dialect.Oracle9iDialect;

public class YunHaiSQLDialect extends Oracle9iDialect{

	public YunHaiSQLDialect() {
		super();
		// TODO Auto-generated constructor stub 
        registerHibernateType(1, "string");  
        registerHibernateType(-9, "string");  
        registerHibernateType(-16, "string");  
        registerHibernateType(3, "double"); 
		
	}
	
}
