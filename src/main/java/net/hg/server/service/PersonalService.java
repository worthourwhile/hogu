package net.hg.server.service;

import net.hg.server.ar.Person;
import net.hg.server.db.PersonRepo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonalService {
    @Resource
    private PersonRepo personRepo;

    public Person findByName(String name) {
        return personRepo.findByName(name);
    }

    public void register(List<Person> people) {
        personRepo.save(people);
    }
}
