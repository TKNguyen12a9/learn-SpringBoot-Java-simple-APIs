package spring_boot_demo.spring_boot_demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import spring_boot_demo.spring_boot_demo.models.Person;

@Repository("fakeDao") // this allows having multiple implementations
public class FakePersonDataAccessService implements PersonDao {

	private static List<Person> DB = new ArrayList<>();

	@Override
	public int insertPerson(UUID id, Person person) {
		return DB.add(new Person(id, person.getName())) ? 1: 0; 
	}

	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}

	@Override
	public int deletePersonById(UUID id) {
		Optional<Person> person = selectPersonById(id);
		if (person.isEmpty()) return 0;
		DB.remove(person.get());
		return 1;
	}

	@Override
	public int updatePersonById(UUID id, Person personToUpdate) {
		return selectPersonById(id)
				.map(person -> {
					int indexOfPersonToUpdate = DB.indexOf(person);
					if (indexOfPersonToUpdate <= 0) return 0;
					// update person
					DB.set(indexOfPersonToUpdate, new Person(id, personToUpdate.getName()));
					return 1;
				}).orElse(0);
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO: read more about stream()
		return DB.stream() 
				.filter(person -> person.getId().equals(id))
				.findFirst();
	}
}
