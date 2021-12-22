package com.abufara.digtask;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.abufara.digtask.rest.BillController;

import junit.framework.Assert;

@SpringBootTest
public class BillTests {

	@Autowired
	private BillController controller;

	@Test
	public void contextLoads() throws Exception {

		assertThat(controller).isNotNull();
	}

	@Test
	public void testGetBills() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8090/bills";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGetBillsAfterDiscount() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8090/billsAfterDiscount";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGetBillById() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8090/bill/1";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testGetBillByIdAfterDiscount() throws Exception {

		RestTemplate restTemplate = new RestTemplate();

		final String baseUrl = "http://localhost:8090/billAfterDiscount/1";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
	}
}
