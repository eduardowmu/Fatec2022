package br.edu.fatec.crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Student;
import br.edu.fatec.crud.repository.StudentRepository;
import br.edu.fatec.crud.strategy.CreateEmail;
import br.edu.fatec.crud.strategy.CreateEnroll;
import br.edu.fatec.crud.strategy.StrategyPattern;
import br.edu.fatec.crud.strategy.ValidateDate;
import br.edu.fatec.crud.strategy.ValidateName;
import br.edu.fatec.crud.utils.ParametersUtils;
@Service
public class StudentService extends Facade{
	@Autowired
	private StudentRepository repository;
	
	public StudentService() {
		this.rules = new HashMap<>();
		
		//Validations rules for Create Student
		ValidateName vn = new ValidateName();
		ValidateDate vd = new ValidateDate();
		CreateEnroll ce = new CreateEnroll();
		CreateEmail cEmail = new CreateEmail();
		
		//Validations rules must be added in a list
		List<StrategyPattern> brCreateStudent = new ArrayList<>();
		brCreateStudent.add(vn);
		brCreateStudent.add(vd);
		brCreateStudent.add(ce);
		brCreateStudent.add(cEmail);
		
		//List of rules for listening students
		
		
		List<StrategyPattern> brListStudent = new ArrayList<>();
		
		//Creating Maps for each events about students
		Map<String, List<StrategyPattern>> studentRules = new HashMap<>();
		studentRules.put(ParametersUtils.SAVE, brCreateStudent);
		studentRules.put(ParametersUtils.LIST, brListStudent);
		
		//Finally we complete a Map with rules of all Entities and events
		this.rules.put(Student.class.getName(), studentRules);
	}
	
	public EntityDomain save(EntityDomain ed) {
		var entity = this.getEntityFromRules(ed, ParametersUtils.SAVE);
		return this.repository.save((Student) entity);
	}
	
	public List<EntityDomain> listAll() {
		List<Student> students = this.repository.findAll();
		List<EntityDomain> entities = new ArrayList<>();
		if(students != null && !students.isEmpty()) {
			students.stream().forEach(std -> {
				entities.add(std);
			});
		}
		return entities;
	}
}