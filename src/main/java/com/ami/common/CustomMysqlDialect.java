package com.ami.common;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.StandardSQLFunction;

public class CustomMysqlDialect extends MySQLDialect{
	public CustomMysqlDialect() {
		super();
		registerFunction("aes_encrypt", new StandardSQLFunction("aes_encrypt", Hibernate.STRING));
		registerFunction("aes_decrypt", new StandardSQLFunction("aes_decrypt", Hibernate.STRING));
	}
}
