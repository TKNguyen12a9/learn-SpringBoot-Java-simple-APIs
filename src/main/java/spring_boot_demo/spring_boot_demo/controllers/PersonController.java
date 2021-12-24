package spring_boot_demo.spring_boot_demo.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring_boot_demo.spring_boot_demo.models.Person;
import spring_boot_demo.spring_boot_demo.services.PersonService;

@RequestMapping("api/person")
@RestController
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public void addPerson(@Valid @NonNull @RequestBody Person person) {
		this.personService.addPerson(person);
	}

	@GetMapping(path = "/all")
	public List<Person> getAllPeople() {
		return this.personService.selectAllPeople();
	}

	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id).orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public void deletePersonById(@PathVariable("id") UUID id) {
		personService.deletePersonById(id);
	}

	@PutMapping(path = "{id}")
	public void updatePersonById(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Person person) {
		personService.updatePersonById(id, person);
	}
}	
