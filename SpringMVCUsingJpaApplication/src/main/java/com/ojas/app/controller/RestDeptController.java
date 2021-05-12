package com.ojas.app.controller;

import java.util.Optional;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ojas.app.dao.DeptRepo;
import com.ojas.app.model.Department;

@RestController
@RequestMapping("/rest/dept")
public class RestDeptController {
	@Autowired
	DeptRepo deptRepo;

	@GetMapping() // for HTTp Get request
	public Iterable<Department> getAllDept() {
		return deptRepo.findAll();
	}

	@GetMapping("/{id}") // for http get request with id
	public Department getOneDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptRepo.findById(id);

		if (dept.isPresent())
			return dept.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department Id Not Found");
	}

	@PostMapping() // for http post request
	public Department addDept(Department dept) {
		try {
			deptRepo.save(dept);
			return dept;
		} catch (Exception ex) {
			System.out.println(ex);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
		}
	}

	@DeleteMapping("/{id}") // for http delete request
	public void deleteDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptRepo.findById(id);

		if (dept.isPresent())
			try {
				deptRepo.delete(dept.get());
			} catch (Exception ex) {
				System.out.println(ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department Id Not Found");
		}
	}

	@PutMapping("/{id}") // for http put request
	public void UpdateDept(@PathVariable("id") int id, Department newDept) {
		Optional<Department> dept = deptRepo.findById(id);
		if (dept.isPresent()) {
			try {
				Department dbDept = dept.get();
				dbDept.setName(newDept.getName());
				deptRepo.save(dbDept);
			} catch (Exception ex) {
				System.out.println(ex);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Department Id Not Found");
		}
	}
}
