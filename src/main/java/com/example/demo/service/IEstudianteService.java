package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Estudiante;

public interface IEstudianteService {
	
	public void guardar(Estudiante estudiante);
	public List<Estudiante> listAllEstudiantes();
	
}
