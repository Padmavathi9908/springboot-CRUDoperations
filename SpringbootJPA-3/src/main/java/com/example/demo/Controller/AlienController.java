package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alien;
import com.example.demo.repo.AlienRepo;

@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	// @RequestMapping("/addAlien")
	// public String addAlien(Alien alien) {

	// Alien a = repo.save(alien);
	// System.out.println(a);
	// return "home.jsp";
//	}

	@PostMapping(path = "/alien", consumes = { "application/json" })
	public Alien addAlien(@RequestBody Alien alien) {

		Alien a = repo.save(alien);
		// System.out.println(a);
		return alien;
	}

	@GetMapping(path = "/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}

	@PutMapping(path = "/alien", consumes = { "application/json" })
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {

		repo.save(alien);
		// System.out.println(a);
		return alien;
	}

	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alien a = repo.getById(aid);
		repo.delete(a);
		return "deleted";

	}

	@RequestMapping("/alien/{aid}")

	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}

//		ModelAndView mv = new ModelAndView("showAlien.jsp");
//		Alien alien = repo.findById(aid).orElse(new Alien());
//
//		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByAidGreaterThan(5));
//		System.out.println(repo.findByTechSorted("java"));
//
//		System.out.println(alien);
//		mv.addObject(alien);
//		System.out.println(mv);
//		return mv;
}
