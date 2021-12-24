package spring_boot_demo.spring_boot_demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import spring_boot_demo.spring_boot_demo.models.Person;

public interface PersonDao {

	int insertPerson(UUID id, Person person);

	List<Person> selectAllPeople();

	int deletePersonById(UUID id);

	int updatePersonById(UUID id, Person person);

	Optional<Person> selectPersonById(UUID id);

	default int addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}
}
