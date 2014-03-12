package net.hg.server.db;

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
		return new UserCredentials("hguser", "hguser1!");
	}
	
	@Override
	protected String getDatabaseName() {
		return "hogudb";
	}


	@Override
	public Mongo mongo() throws Exception {
		Mongo mongo = new MongoClient();
		return new MongoClient("ds033449.mongolab.com");
	}

}
