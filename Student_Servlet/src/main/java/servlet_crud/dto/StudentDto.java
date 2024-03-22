package servlet_crud.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class StudentDto {
	@Id
	@GeneratedValue
	private int id;
	private String sname;
	private String semail;
	private LocalDate sdob;
	private long sphone;
	private String gender;
	private String country;
	public void setNumber(long cnumber) {
		// TODO Auto-generated method stub
		
	}
	
}