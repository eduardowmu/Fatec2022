package br.edu.fatec.crud.service;

import java.util.List;
import java.util.Map;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Message;
import br.edu.fatec.crud.strategy.StrategyPattern;

public abstract class EntityService {
	protected Map<String, Map<String, List<StrategyPattern>>> rules;
	
	public abstract EntityDomain save(EntityDomain ed);

	public abstract EntityDomain update(EntityDomain ed);

	public abstract List<EntityDomain> listAll();

	public abstract void delete(EntityDomain ed);

	protected EntityDomain getEntityFromRules(EntityDomain ed, String event) {
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

}
