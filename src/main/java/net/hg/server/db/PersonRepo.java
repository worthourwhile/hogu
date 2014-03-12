package net.hg.server.db;

import net.hg.server.ar.Person;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepo extends MongoRepository<Person, String> {
	public Person findByName(String name);
	
}
