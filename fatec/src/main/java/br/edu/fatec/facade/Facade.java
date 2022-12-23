package br.edu.fatec.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.model.Message;
import br.edu.fatec.model.Student;
import br.edu.fatec.services.IService;
import br.edu.fatec.services.MessageService;
import br.edu.fatec.services.StudentService;
import br.edu.fatec.strategy.CreateEmail;
import br.edu.fatec.strategy.CreateEnroll;
import br.edu.fatec.strategy.StrategyPattern;
import br.edu.fatec.strategy.ValidateDate;
import br.edu.fatec.strategy.ValidateName;
import br.edu.fatec.utils.ParametersUtils;
@Service
public class Facade implements IFacade {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private MessageService messageService;
	
	private Map<String, IService> service;
	
	private Map<String, Map<String, List<StrategyPattern>>> rules;
	
	public Facade() {
		this.service = new HashMap<>();
		this.service.put(Student.class.getSimpleName(), studentService);
		this.service.put(Message.class.getSimpleName(), messageService);
		
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
	
	private EntityDomain getEntityFromRules(EntityDomain ed, String event) {
		Map<String, List<StrategyPattern>> operationRules = this.rules.get(ed.getClass().getName());
		if(operationRules != null) {
			List<StrategyPattern> rulesList = operationRules.get(event);
			if(rulesList != null) {
				for(StrategyPattern rule : rulesList) {
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
		EntityDomain entity = getEntityFromRules(ed, ParametersUtils.SAVE);
		return this.service.get(entity.getClass().getSimpleName()).save(entity);
	}

	@Override
	public List<EntityDomain> findAll(String entity) {
		List<EntityDomain> entities = new ArrayList<>();
		entities.addAll(this.service.get(entity).findAll(entity));
		return entities;
	}

	@Override
	public EntityDomain update(EntityDomain ed) {
		return null;
	}

	@Override
	public void delete(EntityDomain ed) {}
}