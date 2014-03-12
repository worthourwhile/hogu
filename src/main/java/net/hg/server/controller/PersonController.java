package net.hg.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import net.hg.server.ar.Person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {
	
	private AtomicLong idGen = new AtomicLong();
	
	 @RequestMapping("/personTest")
	 public @ResponseBody List<Person> testJson() {
		 
		 List<Person> persons = new ArrayList<Person>();
		 
		 persons.add(new Person(idGen.incrementAndGet(),"MyungKyo",32));
		 persons.add(new Person(idGen.incrementAndGet(),"JoonHyuk",29));
		 persons.add(new Person(idGen.incrementAndGet(),"YoungHoo",30));
		 
	  	return persons;
	 }
	 
	    

}
