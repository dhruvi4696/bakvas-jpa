package com.cg.course.controller;

import java.io.IOException;
import java.util.ArrayList;






import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.course.dto.Course;
import com.cg.course.exception.CourseException;
import com.cg.course.service.CourseService;


/**
 * Servlet implementation class courseServlet
 */
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operation=request.getParameter("op");
		int op=Integer.parseInt(operation);
		CourseService eService=new CourseService();
		
		switch(op)
		{
		
		case 1:
			    String id=request.getParameter("id");
			    String crsNm=request.getParameter("name");
			    String duration=request.getParameter("dur");
			    int crsId=Integer.parseInt(id);
			    int crsDur=Integer.parseInt(duration);
				System.out.println("In Add Operation");
				
				Course course=new Course();
				course.setCourseId(crsId);
				course.setCourseName(crsNm);
				course.setCourseDuration(crsDur);
				
				
			try {
				boolean addSuc=eService.addcourse(course);
				if(addSuc)
				{	
					response.sendRedirect("addSuccess.jsp");
					System.out.println("data added!");
				}
				else
				{
					response.sendRedirect("addFailure.jsp");
					throw new CourseException("exception occured while adding data!");
				}
			} catch (CourseException e) 
			{
				System.out.println(e.getMessage());
			}
			break;
		
		case 2: 
			    System.out.println("In Retrieve Operation");
				
			try {
				ArrayList<Course> cList=eService.retrieveAllcourse();
				if(cList!=null)
				{
				System.out.println(cList);
				getServletContext().setAttribute("cList",cList);
				response.sendRedirect("retrieve.jsp");
				}
				else
				{
					throw new CourseException("exception occured while retriving data!");
				}
			}
			catch (CourseException e)
			{
				System.out.println(e.getMessage());
			}
				break;
		case 3:
			System.out.println("In search operation");
			int cid=Integer.parseInt(request.getParameter("cid"));
			try {
				Course course1 = eService.retrieveCourse(cid);
				request.setAttribute("course", course1);
				RequestDispatcher rd = request.getRequestDispatcher("retrieveCourse.jsp");
				rd.forward(request, response);
			} 
			catch (CourseException e1) 
			{	
				System.out.println("exception occuered while searching!");
			}
			break;
			
		case 4:
			System.out.println("In delete operation");
			int did=Integer.parseInt(request.getParameter("did"));
			
			try {
				int n = eService.deleteCourse(did);
				if(n!=0)
					response.sendRedirect("deleteSuccess.jsp");
				else
				{
					response.sendRedirect("deleteFailure.jsp");
					throw new CourseException("exception occured while deleting data!");
				}
			} catch (CourseException e) 
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
