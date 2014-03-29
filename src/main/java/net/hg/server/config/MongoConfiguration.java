package net.hg.server.config;

import net.hg.server.ar.Person;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;


@Configuration
@EnableTransactionManagement(proxyTargetClass = true)

@EnableMongoRepositories(basePackageClasses = {Person.class}, repositoryImplementationPostfix = "impl")
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected UserCredentials getUserCredentials() {
		return new UserCredentials("nerd", "nerd1!");
	}
	
	@Override
	protected String getDatabaseName() {
		return "hogu-prototype";
	}


	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("ds033669.mongolab.com", 33669);
	}

}
