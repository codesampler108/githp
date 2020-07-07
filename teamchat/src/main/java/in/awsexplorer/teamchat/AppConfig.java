package in.awsexplorer.teamchat;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/*
The annotation used here are:

@Configuration marks the class as a source of bean definitions
@ConfigurationProperties binds and validates the external configurations to a configuration class
@EnableConfigurationProperties this annotation is used to enable @ConfigurationProperties annotated beans in the Spring application

*/
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class AppConfig {
	
}