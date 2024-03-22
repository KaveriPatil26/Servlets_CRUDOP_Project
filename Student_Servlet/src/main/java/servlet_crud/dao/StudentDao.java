package servlet_crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import servlet_crud.dto.StudentDto;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("servletstudent");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public String insertData(StudentDto studentDto) {
		entityTransaction.begin();
		entityManager.persist(studentDto);
		entityTransaction.commit();
		return "data inserted successfully";
		
		//http://localhost:8080/Student_Servlet/store
		//data inserted successfully
	}

	public StudentDto fetchById(int id) {
		StudentDto studentDto = entityManager.find(StudentDto.class, id);
		return studentDto;
	}

	public List<StudentDto> fetchAll()
	{
		Query q = entityManager.createQuery("select x  from StudentDto x");
		List<StudentDto> list = q.getResultList();
		return list;

	}

	public String deleteById(int id) {
		StudentDto studentDto = entityManager.find(StudentDto.class, id);
		if (studentDto != null) {
			entityTransaction.begin();
			entityManager.remove(studentDto);
			entityTransaction.commit();
			return "data deleted";
		} else {
			return "data not found";
		}
	}

	public String deleteAll() {
		// TODO Auto-generated method stub

		Query q = entityManager.createQuery("select x  from StudentDto x");
		List<StudentDto> list = q.getResultList();

		if (list.isEmpty()) {
			return "data not found";
		} else {
			for (StudentDto a : list) {
				entityTransaction.begin();
				entityManager.remove(a);
				entityTransaction.commit();
			}
			return "data deleted";
		}
	}

}
