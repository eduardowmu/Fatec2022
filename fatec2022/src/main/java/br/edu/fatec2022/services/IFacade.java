package br.edu.fatec2022.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.fatec2022.entity.EntityDomain;

@Service
public interface IFacade {
	EntityDomain save(EntityDomain ed);
	List<EntityDomain> findAll();
	EntityDomain update(EntityDomain ed);
	void delete(EntityDomain ed);
}
