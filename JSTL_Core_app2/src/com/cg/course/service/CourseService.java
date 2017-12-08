package com.cg.course.service;

import java.util.ArrayList;

import com.cg.course.dao.CourseDao;
import com.cg.course.dto.Course;
import com.cg.course.exception.CourseException;

public class CourseService {
	
	private CourseDao eDao;
	
	public CourseService()
	{
		eDao=new CourseDao();
	}
	
	public boolean addcourse(Course course) throws CourseException
	{
		return eDao.addCourse(course);
	}
	
	public ArrayList<Course> retrieveAllcourse() throws CourseException
	{
		return eDao.retrieveAllCourse() ;
	}
	
	public Course retrieveCourse(int eid) throws CourseException
	{
		return eDao.retrieveCourse(eid);
	}

	public int deleteCourse(int did) throws CourseException {
		return eDao.deleteCourse(did);
	}
	
	
}
