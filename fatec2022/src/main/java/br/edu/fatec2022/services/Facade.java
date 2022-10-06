package br.edu.fatec2022.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.entity.Message;
import br.edu.fatec2022.entity.Student;
import br.edu.fatec2022.repository.MessageDao;
import br.edu.fatec2022.repository.StudentDao;
import br.edu.fatec2022.strategy.CreateEmail;
import br.edu.fatec2022.strategy.CreateEnroll;
import br.edu.fatec2022.strategy.Rule;
import br.edu.fatec2022.strategy.ValidateDates;
import br.edu.fatec2022.strategy.ValidateName;
import br.edu.fatec2022.utils.EntityUtils;
import br.edu.fatec2022.utils.ParametersUtils;

public class Facade implements IFacade {

	private Map<String, Map<String, List<Rule>>> rules;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private MessageDao messageDao;
	
	public Facade() {
		this.rules = new HashMap<>();
		
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
		
		//List of rules for listening students
		
		
		List<Rule> brListStudent = new ArrayList<>();
		
		//Creating Maps for each events about students
		Map<String, List<Rule>> studentRules = new HashMap<>();
		studentRules.put(ParametersUtils.SAVE, brCreateStudent);
		studentRules.put(ParametersUtils.LIST, brListStudent);
		
		//Finally we complete a Map with rules of all Entities and events
		this.rules.put(Student.class.getName(), studentRules);
	}
	
	private EntityDomain getEntityFromRules(EntityDomain ed, String event) {
		Map<String, List<Rule>> operationRules = this.rules.get(ed.getClass().getName());
		if(operationRules != null) {
			List<Rule> rulesList = operationRules.get(event);
			if(rulesList != null) {
				for(Rule rule : rulesList) {
					if(rule.process(ed) instanceof Message) {
						return (Message)ed;
					}
				}
			}
		}
		return ed;
	}
	
	@Override
	public EntityDomain save(EntityDomain ed) {
		var entity = this.getEntityFromRules(ed, ParametersUtils.SAVE);
		String entityName = entity.getClass().getName().toLowerCase().replace(ParametersUtils.ENTITY_PACKAGE, ParametersUtils.EMPTY);
		switch(entityName) {
			case ParametersUtils.STUDENT:
				return this.studentDao.save((Student)entity);
			case ParametersUtils.MESSAGE:
				return this.messageDao.save((Message)entity);
		}
		return ed;//(EntityDomain)this.daos.get(entityName).save(response);
	}

	@Override
	public List<EntityDomain> findAll(String entity) {
		var response = this.getEntityFromRules(EntityUtils.getEntity(entity), ParametersUtils.LIST);
		List<EntityDomain> list = new ArrayList<>();
		if(response instanceof Message) {
			list.add(response);
		} else {
			list.addAll(this.studentDao.findAll());
		}
		return list;
	}

	@Override
	public EntityDomain update(EntityDomain ed) {
		return null;
	}

	@Override
	public void delete(EntityDomain ed) {
	
	}
}