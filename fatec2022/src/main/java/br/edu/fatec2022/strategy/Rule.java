package br.edu.fatec2022.strategy;

import br.edu.fatec2022.entity.EntityDomain;

public interface Rule {
	public abstract Object process(EntityDomain ed);
}
