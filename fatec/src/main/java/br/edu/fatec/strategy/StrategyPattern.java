package br.edu.fatec.strategy;

import br.edu.fatec.model.EntityDomain;

public interface StrategyPattern {
	public abstract EntityDomain process(EntityDomain ed);
}
