package br.edu.fatec2022.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.repository.StudentDao;
import br.edu.fatec2022.strategy.CreateEmail;
import br.edu.fatec2022.strategy.CreateEnroll;
import br.edu.fatec2022.strategy.Rule;
import br.edu.fatec2022.strategy.ValidateDates;
import br.edu.fatec2022.strategy.ValidateName;
import br.edu.fatec2022.utils.ParametersUtils;

public class Facade implements IFacade {

	private Map<String, JpaRepository> daos;
	private Map<String, Map<String, List<Rule>>> rules;
	@Autowired
	private StudentDao studentDao;
	
	public Facade() {
		this.daos = new HashMap<>();
		this.rules = new HashMap<>();
		
		//creating Maps to call repositories
		this.daos.put(ParametersUtils.STUDENT, studentDao);
		
		//Validations rules for Create Student
		ValidateName vn = new ValidateName();
		ValidateDates vd = new ValidateDates();
		CreateEnroll ce = new CreateEnroll();
		CreateEmail cEmail = new CreateEmail();
		
		//Validations rules must be added in a list
		List<Rule> brCreateStudent = new ArrayList<>();
		brCreateStudent.add(vn);
		brCreateStudent.add(vd);
		brCreateStudent.add(ce);
		brCreateStudent.add(cEmail);
		
		//There are not any rules for ListAll Students, but
		//we can not allow a nullable List
		List<Rule> brListStudent = new ArrayList<>();
		
		//Creating Maps for each events about students
		Map<String, List<Rule>> studentRules = new HashMap<>();
		studentRules.put(ParametersUtils.SAVE, brCreateStudent);
		
	}
	
	@Override
	public EntityDomain save(EntityDomain ed) {
		return null;
	}

	@Override
	public List<EntityDomain> findAll() {
		return null;
	}

	@Override
	public EntityDomain update(EntityDomain ed) {
		return null;
	}

	@Override
	public void delete(EntityDomain ed) {
	
	}
}