package br.edu.fatec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.dao.MessageRepository;
import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.model.Message;

@Service
public class MessageService implements IService {
	@Autowired
	private MessageRepository repository;
	
	@Override
	public EntityDomain save(EntityDomain ed) {
		return this.repository.save((Message)ed);
	}

	@Override
	public List<EntityDomain> findAll(String entity) {
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
