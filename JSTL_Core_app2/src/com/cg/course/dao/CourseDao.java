package com.cg.course.dao;
/* Table Creation in database
 * CREATE table Course(
 * courseId NUMBER(6) PRIMARY KEY,
 * courseName VARCHAR2(30),
 * courseDuration NUMBER(5)
 * );
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cg.course.dto.Course;
import com.cg.course.exception.CourseException;
import com.cg.course.util.DBUtil;

public class CourseDao {

	public boolean addCourse(Course course) throws CourseException
	{
		boolean b = false;
		Connection  con = DBUtil.obtainConnection();
		int insertSuccess=0;
		String insQry="insert into Course values(?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(insQry);
			pst.setInt(1, course.getCourseId());
			pst.setString(2,course.getCourseName());
			pst.setDouble(3,course.getCourseDuration());
			insertSuccess=pst.executeUpdate();
			
		if(insertSuccess>0)
		{
			b=true;
		}
		else{
			b=false;
		}
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		return b;
	}


	public ArrayList<Course> retrieveAllCourse() throws CourseException
	{
		ArrayList<Course> cList=new ArrayList<Course>();
		Connection  con = DBUtil.obtainConnection();
	
		String qry="select courseId,courseName,courseDuration from Course" ;
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next())
			{
				Course course=new Course();
				course.setCourseId(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setCourseDuration(rs.getInt(3));
				cList.add(course);
			}	
		
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return cList;
	}


	public Course retrieveCourse(int cid) throws CourseException
	{
		Course course=null;
		System.out.println("In dao "+cid);
		Connection con = DBUtil.obtainConnection();
		String qry="select courseId ,courseName, courseDuration from Course where courseId=?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, cid);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				course=new Course();
				course.setCourseId(rs.getInt("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCourseDuration(rs.getInt(3));
			}	
			else
			{
				throw new CourseException("Exception while retrieving by id!");
				}
		} catch (SQLException | CourseException e) 
		{
			System.out.println(e.getMessage());
		}

		return course;
	}

	public int deleteCourse(int did) throws CourseException 
	{
		System.out.println("In dao "+did);
		Connection con= DBUtil.obtainConnection();
		int n = 0;
		String qry="delete from Course where courseId = "+did;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(qry);
			n = preparedStatement.executeUpdate();
			
			if(n!=0)
				{
					System.out.println("row deleted fror id "+did);
				}
			else
			{
				throw new CourseException("id not found!");
			}
			
		}
		catch (SQLException e)
		{
			System.out.println(e);
		} catch (CourseException e) {
			System.out.println(e);
		}
		return n;
	}
}
