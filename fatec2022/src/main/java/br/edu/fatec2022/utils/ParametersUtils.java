package br.edu.fatec2022.utils;

public class ParametersUtils {
	public static final String EMAIL = "@fatec.sp.gov.br";
	//atributos estaticos de eventos
	public static final String SAVE = "save";
	public static final String LIST = "list";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	
	//atributos estaticos de entidades
	public static final String STUDENT = "student";
	public static final String MESSAGE = "message";
	public static final String ENTITY = "entity";
	
	//atributos estaticos de paths de eventos
	public static final String ENTITY_PATH = "/{entity}";
	public static final String SAVE_PATH = "/save";
	public static final String LIST_PATH = "/list";
	
	//atributos estaticos de em geral
	public static final String EMPTY = "";
	public static final String DOUBLE_POINT = ": ";
	public static final String DOT = ".";
	
	//atributos estaticos de pacotes
	public static final String BASIC_PACKAGE = "br.edu.fatec2022.";
	public static final String ENTITY_PACKAGE = BASIC_PACKAGE.concat("entity.");
	
	//numeros
	public static final String ZERO = "0";
	
	//REGEX
	public static final String REGEX_ESPECIAL_CHARACTER = "[^a-zA-Z]";
}
