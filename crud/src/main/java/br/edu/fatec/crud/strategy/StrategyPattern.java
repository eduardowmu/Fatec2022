package br.edu.fatec.crud.strategy;

import br.edu.fatec.crud.model.EntityDomain;

public interface StrategyPattern {
	public abstract EntityDomain process(EntityDomain ed);
}
