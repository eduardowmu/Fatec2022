package br.edu.fatec2022.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatec2022.command.Command;
import br.edu.fatec2022.command.Delete;
import br.edu.fatec2022.command.ListAll;
import br.edu.fatec2022.command.Save;
import br.edu.fatec2022.command.Update;
import br.edu.fatec2022.vh.ViewHelper;

@RestController
@RequestMapping("/{entity}")
public class ApplicationController {
	private final Map<String ,Command> commands;
	private final Map<String, ViewHelper> vhs;
	private final String entity;
	
	@Autowired
	public ApplicationController(@PathVariable("entity") String entity) {
		this.commands = new HashMap<String, Command>();
		this.commands.put("save", new Save());
		this.commands.put("list", new ListAll());
		this.commands.put("update", new Update());
		this.commands.put("delete", new Delete());
		
		this.vhs = new HashMap<String, ViewHelper>();
		
		this.entity = entity;
	}
	
	
}
