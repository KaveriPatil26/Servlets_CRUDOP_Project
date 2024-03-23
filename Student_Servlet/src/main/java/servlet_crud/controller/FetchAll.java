package servlet_crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet_crud.dao.StudentDao;
import servlet_crud.dto.StudentDto;

@WebServlet("/fall")
public class FetchAll extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		StudentDao studentDao=new StudentDao();
		List<StudentDto> list=studentDao.fetchAll();
		//resp.getWriter().print(list);---not in table format
		
		req.setAttribute("object", list);
		
		RequestDispatcher dis=req.getRequestDispatcher("fetchall.jsp");
		dis.forward(req, resp); // in the request no data is present 
		
		
		
		
	}
}

//http://localhost:8080/Student_Servlet/fall
