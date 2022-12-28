package br.edu.fatec.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec.crud.model.EntityDomain;
import br.edu.fatec.crud.service.EntityService;
import br.edu.fatec.crud.service.MessageService;
import br.edu.fatec.crud.service.StudentService;
import br.edu.fatec.crud.utils.EntityUtils;
import br.edu.fatec.crud.utils.ParametersUtils;
import br.edu.fatec.crud.vh.EntityVh;
import br.edu.fatec.crud.vh.StudentVh;
import br.edu.fatec.crud.vo.EntityVo;

@RestController
@RequestMapping(value=ParametersUtils.ENTITY_PATH)
public class CrudController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private MessageService messageService;
	
	private Map<String, EntityVh> viewHelper;
	
	public CrudController() {
		this.viewHelper = new HashMap<>();
		this.viewHelper.put(ParametersUtils.STUDENT, new StudentVh());
	}
	
	@PostMapping(ParametersUtils.SAVE_PATH)
	public ResponseEntity<EntityVo> createEntity(@PathVariable(ParametersUtils.ENTITY) String entity, 
			@RequestBody EntityVo requestVo) {
		var vh = this.viewHelper.get(entity);
		var requestEntity = vh.getEntityRequest(requestVo);
		var responseEntity = this.getService(entity).save(requestEntity);
		var responseVo = vh.getEntityResponse(responseEntity);
		return //ResponseEntity.ok(responseVo);
				null;
	}
	
	@GetMapping(ParametersUtils.LIST_PATH)
	public ResponseEntity<List<EntityVo>> listAll(@PathVariable(ParametersUtils.ENTITY) String entity) {
		var service = this.getService(entity);
		var vh = this.viewHelper.get(entity);
		List<EntityVo> entitiesVo = new ArrayList<>();
		List<EntityDomain> entities = service.listAll();
		entities.stream().forEach(e -> {
			entitiesVo.add(vh.getEntityResponse(e));
		});
		return //ResponseEntity.ok(entitiesVo);
				null;
	}
	
	private EntityService getService(String entity) {
		switch(entity) {
			case ParametersUtils.STUDENT:
				return this.studentService;
			default:
				return this.messageService;
		}
	}
}