package br.edu.fatec2022.vh;

import br.edu.fatec2022.dto.Dto;
import br.edu.fatec2022.dto.StudentDto;
import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;

public class StudentVh implements ViewHelper {
	@Override
	public Student requestEntity(Dto dto) {
		var studentDto = (StudentDto)dto;
		return studentDto.toEntity();
	}

	@Override
	public StudentDto responseEntity(EntityDomain ed) {
		var student = (Student)ed;
		return student.toDto();
	}

}
