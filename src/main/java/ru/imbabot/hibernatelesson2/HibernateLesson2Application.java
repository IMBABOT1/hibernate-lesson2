package ru.imbabot.hibernatelesson2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.imbabot.hibernatelesson2.Utils.SessionFactoryUtils;

@SpringBootApplication
public class HibernateLesson2Application {

	public static void main(String[] args) {
		SpringApplication.run(HibernateLesson2Application.class, args);
		SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();

		sessionFactoryUtils.init();
	}

}
