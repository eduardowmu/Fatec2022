package br.edu.fatec.crud.service;

import java.util.List;

import br.edu.fatec.crud.model.EntityDomain;

public interface Facade {
	EntityDomain save(EntityDomain ed);
	EntityDomain update(EntityDomain ed);
	List<EntityDomain> listAll();
	void delete(EntityDomain ed);
	EntityDomain getEntityFromRules(EntityDomain ed, String event);
}
