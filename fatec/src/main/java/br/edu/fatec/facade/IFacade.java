package br.edu.fatec.facade;

import java.util.List;

import br.edu.fatec.model.EntityDomain;

public interface IFacade {
	EntityDomain save(EntityDomain ed);
	List<EntityDomain> findAll(String entity);
	EntityDomain update(EntityDomain ed);
	void delete(EntityDomain ed);
}