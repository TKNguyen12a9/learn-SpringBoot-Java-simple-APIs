package spring_boot_demo.spring_boot_demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import spring_boot_demo.spring_boot_demo.dao.PersonDao;
import spring_boot_demo.spring_boot_demo.models.Person;

@Service
public class PersonService {	
	
	// dependency injection
	private final PersonDao personDao;

	// Qualifier("fakeDao") from FakePersonDataAccessService
	// this convention makes switching to another database easily
	@Autowired
	public PersonService(@Qualifier("postgres") PersonDao personDao) {
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return this.personDao.addPerson(person);
	}

	public List<Person> selectAllPeople() {
		return this.personDao.selectAllPeople();
	}

	public Optional<Person> getPersonById(UUID id) {
		return personDao.selectPersonById(id);
	}

	public int updatePersonById(UUID id, Person newPerson) {
		return personDao.updatePersonById(id, newPerson);
	}

	public int deletePersonById(UUID id) {
		return personDao.deletePersonById(id);
	}
}
