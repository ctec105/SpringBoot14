package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEstudianteDAO;
import com.example.demo.entity.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	IEstudianteDAO estudianteDAO;
	
	@Override
	public void guardar(Estudiante estudiante) {
		estudianteDAO.save(estudiante);
	}

	@Override
	public List<Estudiante> listAllEstudiantes() {
		return estudianteDAO.findAll();
	}

}
