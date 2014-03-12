package net.hg.server.service;

import net.hg.server.ar.Person;
import net.hg.server.db.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {
    @Autowired
    private PersonRepo personRepo;

    public Person findByName(String name) {
        return personRepo.findByName(name);
    }

    public void register(List<Person> people) {
        personRepo.save(people);
    }
}
