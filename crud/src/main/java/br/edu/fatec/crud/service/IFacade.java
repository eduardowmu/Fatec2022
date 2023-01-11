package br.edu.fatec.crud.service;

import java.util.List;

import br.edu.fatec.crud.model.EntityDomain;

public interface IFacade {
	public abstract EntityDomain save(EntityDomain ed);
	public abstract List<EntityDomain> listAll();
	public abstract EntityDomain update(EntityDomain ed);
	public abstract void delete(Long id);
}