package spring_boot_demo.spring_boot_demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import spring_boot_demo.spring_boot_demo.models.Person;


// Data access with Postgres DB
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

	@Override
	public int insertPerson(UUID id, Person person) {
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		return List.of(new Person(UUID.randomUUID(), "From Postgres DB"));
	}

	@Override
	public int deletePersonById(UUID id) {
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return 0;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return Optional.empty();
	}
	
}
