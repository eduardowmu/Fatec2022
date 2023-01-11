package br.edu.fatec.crud.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.model.Message;
import br.edu.fatec.crud.repository.MessageRepository;
@Service
public class MessageService extends Facade {
	@Autowired
	private MessageRepository repository;
	
	public EntityDomain save(EntityDomain ed) {
		return this.repository.save((Message)ed);
	}
	
	public List<EntityDomain> listAll() {
		List<Message> messages = this.repository.findAll();
		List<EntityDomain> entities = new ArrayList<>();
		if(messages != null && !messages.isEmpty()) {
			messages.stream().forEach(msg -> {
				entities.add(msg);
			});
		}
		return entities;
	}

	public EntityDomain update(EntityDomain ed) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
}