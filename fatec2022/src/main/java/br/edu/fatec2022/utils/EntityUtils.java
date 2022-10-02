package br.edu.fatec2022.utils;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Student;

public class EntityUtils {
	public static EntityDomain getEntity(String entity) {
		switch(entity) {
			case ParametersUtils.STUDENT:
				return Student.builder().build();
			
			default: return null;
		}
	}
}
