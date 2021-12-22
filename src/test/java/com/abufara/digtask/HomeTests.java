package com.abufara.digtask;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.abufara.digtask.rest.HomeController;

import junit.framework.Assert;

@SpringBootTest
public class HomeTests {

	@Autowired
	private HomeController controller;

	@Test
	public void contextLoads() throws Exception {

		assertThat(controller).isNotNull();
	}

	@Test
	public void testGetHomePage() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8090/";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}
}
