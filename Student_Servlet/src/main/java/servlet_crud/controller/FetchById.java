package servlet_crud.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import servlet_crud.dao.StudentDao;
import servlet_crud.dto.StudentDto;

@WebServlet("/fid")
public class FetchById extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = req.getParameter("pk");
		int cid = Integer.parseInt(id);
		System.out.println(cid);
		StudentDao studentDao = new StudentDao();
		StudentDto studentDto = studentDao.fetchById(cid);
		res.getWriter().print(studentDto);
	}

}
