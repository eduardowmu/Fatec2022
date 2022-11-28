package br.edu.fatec.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fatec.dao.StudentRepository;
import br.edu.fatec.model.EntityDomain;
import br.edu.fatec.model.Student;

@Service
public class StudentService implements IService{
	private static StudentRepository repository;
	
	@Autowired
	public StudentService(StudentRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public EntityDomain save(EntityDomain ed) {
		return this.repository.save((Student)ed);
	}

	@Override
	public List<EntityDomain> findAll(String entity) {
		List<EntityDomain> students = new ArrayList<>();
		this.repository.findAll().stream().forEach(e -> {
			students.add(e);
		});
		return students;
	}

	@Override
	public EntityDomain update(EntityDomain ed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EntityDomain ed) {
		// TODO Auto-generated method stub
		
	}	
}