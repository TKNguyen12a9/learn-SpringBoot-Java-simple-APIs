package spring_boot_demo.spring_boot_demo.models;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private final UUID id; 
	@NotBlank  // validate name field
	private final String name;

	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}

	public UUID getId() { return this.id; }
	public String getName() { return this.name; } 
}
