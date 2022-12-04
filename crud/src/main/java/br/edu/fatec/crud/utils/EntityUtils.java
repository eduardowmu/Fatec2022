package br.edu.fatec.crud.utils;

import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.model.Message;
import br.edu.fatec.model.Student;

public class EntityUtils {
	public static EntityDomain getEntity(String entity) {
		switch(entity) {
			case ParametersUtils.STUDENT:
				return new Student();
				
			case ParametersUtils.MESSAGE:
				return new Message();
			
			default: return null;
		}
	}
}