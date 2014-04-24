package net.hg.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableInMemoryConnectionRepository;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.facebook.config.annotation.EnableFacebook;

/**
 * Created by Joonhyeok Im on 14. 3. 29.
 * @see https://spring.io/guides/gs/accessing-facebook/
 */
@EnableFacebook(appId = "526117574174925", appSecret = "5200f07d3959c548dca26d0edece705a")
@EnableInMemoryConnectionRepository
public class FacebookConfiguration {

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }

    @Bean
    public UserIdSource userIdSource() {
        return new UserIdSource() {
            @Override
            public String getUserId() {
                return "testuser";
            }
        };
    }
}
