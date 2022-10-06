package br.edu.fatec2022.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Builder
@Setter
@Getter
public class EntityVo {
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
