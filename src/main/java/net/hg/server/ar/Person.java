package net.hg.server.ar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter @Setter
@AllArgsConstructor
@ToString
public class Person {
	@Id
	private long id;
	private String name;
	private int age;
}
