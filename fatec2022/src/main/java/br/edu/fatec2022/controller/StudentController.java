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
import br.edu.fatec2022.entity.Student;

@RestController
@RequestMapping("/student")
public class StudentController {
	private Map<String, Command> commands;
	
	//atributos estaticos
	private static final String SAVE = "save";
	private static final String LIST = "list";
	private static final String UPDATE = "update";
	private static final String DELETE = "delete";
	
	@Autowired
	public StudentController() {
		this.commands = new HashMap<>();
		this.commands.put(SAVE, new Save());
		this.commands.put(LIST, new ListAll());
		this.commands.put(UPDATE, new Update());
		this.commands.put(DELETE, new Delete());
	}
	
	@PostMapping("/save")
	public ResponseEntity<Student> create(@RequestBody Student student) {
		return ResponseEntity.ok((Student)this.commands.get(SAVE).execute(student));
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Student>> listAll() {
		return ResponseEntity.ok((List<Student>)this.commands.get(LIST).execute(null));
	}
}
