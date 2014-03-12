package net.hg.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import net.hg.server.ar.Person;

import net.hg.server.service.PersonalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class PersonController {
	
	private AtomicLong idGen = new AtomicLong();

    @Resource
    private PersonalService personalService;
	
	 @RequestMapping("/testPeoplePush")
	 public @ResponseBody List<Person> testJson() {
		 
		 List<Person> people = new ArrayList<Person>();
		 
		 people.add(new Person(idGen.incrementAndGet(), "MyungKyo", 32));
         people.add(new Person(idGen.incrementAndGet(), "June", 31));
		 people.add(new Person(idGen.incrementAndGet(), "JoonHyeok", 29));
		 people.add(new Person(idGen.incrementAndGet(), "YoungHoo", 30));

         personalService.register(people);

	  	return people;
	 }

    @RequestMapping("/person/find/{name}")
    public @ResponseBody Person findByName(@PathVariable String name) {
        Person person = personalService.findByName(name);
        return person;
    }

}
