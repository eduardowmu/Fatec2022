package br.edu.fatec.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Student;
import br.edu.fatec.crud.repository.StudentRepository;
import br.edu.fatec.crud.strategy.CreateEmail;
import br.edu.fatec.crud.strategy.CreateEnroll;
import br.edu.fatec.crud.strategy.ValidateDate;
import br.edu.fatec.crud.strategy.ValidateName;

public class StudentService implements Facade {
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
		
		
	}
	
	@Override
	public Student save(EntityDomain ed) {
		return null;
	}

	@Override
	public Student update(EntityDomain ed) {
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

	@Override
	public EntityDomain getEntityFromRules(EntityDomain ed, String event) {
		return null;
	}

}
