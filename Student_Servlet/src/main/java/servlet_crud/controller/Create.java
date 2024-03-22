package servlet_crud.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import servlet_crud.dao.StudentDao;
import servlet_crud.dto.StudentDto;

@WebServlet("/store")
public class Create implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("sid");
		String name = req.getParameter("sname");
		String email = req.getParameter("semail");
		LocalDate dob = LocalDate.parse(req.getParameter("sdob"));
		String number = req.getParameter("sphone");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");

		// System.out.println(id+" "+name);
		// res.getWriter().print(id+" "+name);

		StudentDto studentDto = new StudentDto();
		// create the object of dto & set the values to object
	
		long cnumber = Long.parseLong(number);
		
		studentDto.setSname(name);
		studentDto.setSemail(email);
		studentDto.setSdob(dob);
		studentDto.setSphone(cnumber);
		studentDto.setGender(gender);
		studentDto.setCountry(country);

		System.out.println(studentDto);

		StudentDao studentDao = new StudentDao();// create the object of dao & pass the object
		String msg = studentDao.insertData(studentDto);
		res.getWriter().print(msg);

	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}