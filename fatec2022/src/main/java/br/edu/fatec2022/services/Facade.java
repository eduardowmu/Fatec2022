package br.edu.fatec2022.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.strategy.Rule;

public class Facade implements IFacade {

	private Map<String, JpaRepository> daos;
	private Map<String, Map<String, List<Rule>>> rules;
	
	public Facade() {
		this.daos = new HashMap<>();
		this.rules = new HashMap<>();
		
		//rules for Student
		
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