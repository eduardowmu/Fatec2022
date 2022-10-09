package br.edu.fatec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}