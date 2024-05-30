package com.usventuresltd.restclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

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

}
