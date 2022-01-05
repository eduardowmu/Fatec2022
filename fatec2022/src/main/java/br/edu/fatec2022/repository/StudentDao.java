package br.edu.fatec2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatec2022.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {}