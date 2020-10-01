package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employe;
import com.example.demo.repository.EmployeRepository;

@RestController
@RequestMapping("employe")
public class EmployeController {
	
	@Autowired
	private EmployeRepository employeRepository;
	
	@GetMapping(value = "/employes")
	public List<Employe> listEmployes(){
		return employeRepository.findAll();
	}
	@GetMapping(value = "/employes/{id}")
	public Employe getEmployeById(@PathVariable int id) {
		return employeRepository.findById(id).orElse(null);
		
	}
	
	@PostMapping(value = "/employes")
	public void ajouterEmploye(@RequestBody Employe e) {
		employeRepository.save(e);
	}
	
	@DeleteMapping(value = "/employes/{id}")
	public void supprimerEmploye( @PathVariable int id) {
		 employeRepository.deleteById(id);
	}
     
	@PutMapping(value = "/employes/{id}")
		public void modifierEmploye(@PathVariable int id,@RequestBody Employe e) {
		Employe em=employeRepository.findById(id).orElse(null);
		em=e;
		employeRepository.save(em);
	}
	
	@PostMapping(value = "employes/{nom}")
	public Employe trouverEmploye(@PathVariable String nom) {
		return employeRepository.findByNom(nom);
	}
}
