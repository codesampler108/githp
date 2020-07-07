package in.awsexplorer.teamchat.dbsetup.content;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import in.awsexplorer.teamchat.dbsetup.YamlPropertySourceFactory;

@Configuration
@ComponentScan("in.awsexplorer.teamchat")
@EnableConfigurationProperties
@ConfigurationProperties
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:application.yml", name="db")
public class AppDBConfig {

}
