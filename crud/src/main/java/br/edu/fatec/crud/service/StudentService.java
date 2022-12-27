package br.edu.fatec.crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Student;
import br.edu.fatec.crud.repository.StudentRepository;
import br.edu.fatec.crud.strategy.CreateEmail;
import br.edu.fatec.crud.strategy.CreateEnroll;
import br.edu.fatec.crud.strategy.ValidateDate;
import br.edu.fatec.crud.strategy.ValidateName;
import br.edu.fatec.crud.utils.ParametersUtils;
import br.edu.fatec.crud.strategy.StrategyPattern;

public class StudentService extends EntityService {
	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private MessageService messageService;
	
	public StudentService() {
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
		this.rules = new HashMap<>();
		this.rules.put(Student.class.getSimpleName(), studentRules);
	}
	
	@Override
	public EntityDomain save(EntityDomain ed) {
		EntityDomain entity = this.getEntityFromRules(ed, ParametersUtils.SAVE);
		return entity instanceof Student ? this.repository.save((Student) entity) : this.messageService.save(entity);
	}

	@Override
	public EntityDomain update(EntityDomain ed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityDomain> listAll() {
		List<EntityDomain> students = new ArrayList<>();
		students.addAll(this.repository.findAll());
		return students;
	}

	@Override
	public void delete(EntityDomain ed) {
		// TODO Auto-generated method stub

	}
}