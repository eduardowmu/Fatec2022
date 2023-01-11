package br.edu.fatec.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.service.Facade;
import br.edu.fatec.crud.service.MessageService;
import br.edu.fatec.crud.service.StudentService;
import br.edu.fatec.crud.utils.ParametersUtils;
import br.edu.fatec.crud.vh.EntityVh;
import br.edu.fatec.crud.vh.StudentVh;
import br.edu.fatec.crud.vo.EntityVo;

@CrossOrigin("*")
@RestController
@RequestMapping(value=ParametersUtils.ENTITY_PATH)
public class CrudController {
	private final StudentService studentService;
	private final MessageService messageService;
	
	private Map<String, EntityVh> viewHelper;
	private Map<String, Facade> service;
	
	@Autowired
	public CrudController(StudentService studentService, MessageService messageService) {
		this.viewHelper = new HashMap<>();
		this.viewHelper.put(ParametersUtils.STUDENT, new StudentVh());
		
		this.studentService = studentService;
		this.messageService = messageService;
		this.service = new HashMap<>();
		this.service.put(ParametersUtils.STUDENT, this.studentService);
		this.service.put(ParametersUtils.MESSAGE, this.messageService);
	}
	
	@PostMapping(ParametersUtils.SAVE_PATH)
	public ResponseEntity<EntityVo> createEntity(@PathVariable(ParametersUtils.ENTITY) String entity, 
			@RequestBody EntityVo requestVo) {
		var vh = this.viewHelper.get(entity);
		var request = vh.getEntityRequest(requestVo);
		var serv = this.service.get(entity);//this.getService(entity);
		var response = serv.save(request);
		var responseVo = vh.getEntityResponse(response);
		return ResponseEntity.ok(responseVo);
	}
	
	@GetMapping
	public ResponseEntity<List<EntityVo>> listAll(@PathVariable(ParametersUtils.ENTITY) String entity) {
		var vh = this.viewHelper.get(entity);
		var service = this.service.get(entity);//this.getService(entity);
		List<EntityVo> entitiesVo = new ArrayList<>();
		List<EntityDomain> requestList = service.listAll();
		requestList.stream().forEach(e -> {
			entitiesVo.add(vh.getEntityResponse(e));
		});
		return ResponseEntity.ok(entitiesVo);
	}
}