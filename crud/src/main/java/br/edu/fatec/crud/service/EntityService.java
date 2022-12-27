package br.edu.fatec.crud.service;

import java.util.List;
import java.util.Map;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Message;
import br.edu.fatec.crud.strategy.StrategyPattern;

public abstract class EntityService implements Facade {
	protected Map<String, Map<String, List<StrategyPattern>>> rules;
	
	@Override
	public EntityDomain save(EntityDomain ed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDomain update(EntityDomain ed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityDomain> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityDomain ed) {}

	@Override
	public EntityDomain getEntityFromRules(EntityDomain ed, String event) {
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
