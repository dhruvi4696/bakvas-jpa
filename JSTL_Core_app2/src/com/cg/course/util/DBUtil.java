package com.cg.course.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.cg.course.exception.CourseException;

/*
 * DBUtil class to access a connection pool 
 */
public class DBUtil {
	static Connection connection;

	public static Connection obtainConnection() throws CourseException {
		try 
		{
			System.out.println("In DBUtil..");
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context
					.lookup("java:/oracleDs");
			connection = source.getConnection();
		} 
		catch (NamingException e) 
		{
			throw new CourseException("Error while creating datascource:: "
					+ e.getMessage());
		} 
		catch (SQLException e) 
		{
			throw new CourseException("Error while obtaining connection:: "
					+ e.getMessage());
		}
		return connection;
	}
}
