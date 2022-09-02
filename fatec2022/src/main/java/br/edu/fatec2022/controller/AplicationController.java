package br.edu.fatec2022.controller;

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
import br.edu.fatec2022.dto.Dto;
import br.edu.fatec2022.utils.ParametersUtils;
import br.edu.fatec2022.vh.StudentVh;
import br.edu.fatec2022.vh.ViewHelper;

@RestController
@RequestMapping("/fatec")
public class AplicationController {
	private Map<String, Command> commands;
	@Autowired
	private ViewHelper vh;
	
	public AplicationController() {
		this.commands = new HashMap<>();
		this.commands.put(ParametersUtils.SAVE, new Save());
		this.commands.put(ParametersUtils.LIST, new ListAll());
		this.commands.put(ParametersUtils.UPDATE, new Update());
		this.commands.put(ParametersUtils.DELETE, new Delete());
	}
	
	@PostMapping("/{entity}/save")
	public ResponseEntity<Dto> create(@PathVariable("entity") String entity, 
									  @RequestBody Dto body) {
		var vh = this.getViewType(entity);
		var request = vh.requestEntity(body);
		var response = this.commands.get(ParametersUtils.SAVE).execute(request);
		return null;
	}
	
	@GetMapping("/{entity}/list")
	public ResponseEntity<List<Dto>> listAll(@PathVariable("entity") String entity) {
		return null;
	}
	
	private ViewHelper getViewType(String entity) {
		switch(entity) {
			case ParametersUtils.STUDENT:
				return new StudentVh();
			
			default: 
				return null;
		}
	}
}