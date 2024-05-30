package com.usventuresltd.restclient;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestClientApplicationTests {
	@Autowired
	private ApplicationContext context;

	/**
	 * This test method is used to verify that the application context is loaded. [Primary]
	 *
	 * Also, using the same to "look" at the ApplicationContext in a bit more detail.
	 */

	@Test
	void contextLoads() {
		assertNotNull(context);
		int beanCnt = context.getBeanDefinitionCount();
		System.out.println("\t ### There are " + beanCnt + " beans in the application context");
		// Let us list the beans
		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println("\t ### Bean Name: " + beanName);
		}
		// Let us make sure that there is no RestTemplate bean, only RestTemplateBuilder
		assertFalse(context.containsBean("restTemplate"));
		assertTrue(context.containsBean("restTemplateBuilder"));
	}

	@Test @Disabled // See doc below for the reason
	void getBean() {
		assertNotNull(context);
		assertNotNull(context.getBean("astroService"));
		// Since we know that RestTemplate is not a bean, we should get an exception
		/**
		 * The assertThrows method is used to verify that the specified exception is thrown by the executable.
		 * The first argument is the exception type to be thrown, and the second argument is the executable to be verified.
		 * The third argument is a message to be displayed if the assertion fails.
		 * It passed before we added astroRestTemplate method in AppConfig.java and the RestTemplate bean was not available.
		 * Now, it should fail.
		 */
		assertThrows(NoSuchBeanDefinitionException.class,
				() -> context.getBean(RestTemplate.class)) ;// Lambda with no arguments
		// The above is assert expects an Executable, which is a functional interface. We can use a lambda expression

	}

}
