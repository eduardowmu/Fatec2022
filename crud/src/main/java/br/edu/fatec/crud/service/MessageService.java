package br.edu.fatec.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Message;
import br.edu.fatec.crud.repository.MessageRepository;

public class MessageService extends EntityService {
	@Autowired
	private MessageRepository repository;
	
	@Override
	public Message save(EntityDomain ed) {
		return this.repository.save((Message)ed);
	}

	@Override
	public Message update(EntityDomain ed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntityDomain> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityDomain ed) {
		// TODO Auto-generated method stub
		
	}
}