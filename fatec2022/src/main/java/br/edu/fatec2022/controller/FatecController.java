package br.edu.fatec2022.controller;

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
import br.edu.fatec2022.command.Command;
import br.edu.fatec2022.command.Delete;
import br.edu.fatec2022.command.ListAll;
import br.edu.fatec2022.command.Save;
import br.edu.fatec2022.command.Update;
import br.edu.fatec2022.entity.EntityDomain;
import br.edu.fatec2022.utils.EntityUtils;
import br.edu.fatec2022.utils.ParametersUtils;
import br.edu.fatec2022.vh.EntityVh;
import br.edu.fatec2022.vh.StudentVh;
import br.edu.fatec2022.vo.EntityVo;

@RestController
@RequestMapping(ParametersUtils.ENTITY_PATH)
public class FatecController {
	private Map<String, Command> commands;
	private Map<String, EntityVh> viewHelpers;
	
	@Autowired
	public FatecController() {
		this.commands = new HashMap<>();
		this.commands.put(ParametersUtils.SAVE, new Save());
		this.commands.put(ParametersUtils.LIST, new ListAll());
		this.commands.put(ParametersUtils.UPDATE, new Update());
		this.commands.put(ParametersUtils.DELETE, new Delete());
		
		this.viewHelpers = new HashMap<>();
		this.viewHelpers.put(ParametersUtils.STUDENT, new StudentVh());
	}
	
	@PostMapping(ParametersUtils.SAVE_PATH)
	public ResponseEntity<EntityVo> create(@PathVariable(ParametersUtils.ENTITY) String entity, 
			@RequestBody EntityVo request) {
		var vh = this.viewHelpers.get(entity);
		var ed = vh.getEntityRequest(request);
		var response = this.commands.get(ParametersUtils.SAVE).execute(ed);
		return ResponseEntity.ok().body(vh.getEntityResponse(response));
	}
	
	@GetMapping(ParametersUtils.LIST_PATH)
	public ResponseEntity<List<EntityVo>> listAll(@PathVariable(ParametersUtils.ENTITY) String entity) {
		var vh = this.viewHelpers.get(entity);
		var ed = EntityUtils.getEntity(entity);
		var response = this.commands.get(ParametersUtils.LIST).execute(ed);
		return ResponseEntity.ok().body(this.getListEntityVo((List<EntityDomain>)response, vh));
	}
	
	private List<EntityVo> getListEntityVo(List<EntityDomain> entities, EntityVh vh) {
		List<EntityVo> entityVoList = new ArrayList<>();
		entities.stream().forEach(e -> {
			entityVoList.add(vh.getEntityResponse(e));
		});
		return entityVoList;
	}
}