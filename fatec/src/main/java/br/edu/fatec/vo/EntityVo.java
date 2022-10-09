package br.edu.fatec.vo;

import java.io.Serializable;
import java.time.LocalDate;

import br.edu.fatec.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
public class EntityVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//General attribute
	private Long id;
	
	//General Person attribute
	private String firstName;
	private String mediumName;
	private String lastName;
	private String birthDate;
	private String startDate;
	private String endDate;
	private String courseId;
	private String enrollNumber;
	private String email;
	
	//Student
	private Integer position;
	
	//
	
	//Msg
	private String msg;
}