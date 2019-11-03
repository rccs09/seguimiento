package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {

	@Test
	public void testAllSet() {
		Client c = new Client();
		c.setCliId(1);
		c.setCliName("Cliente");
		assertNotNull(c.toString());
	}
	
	@Test
	public void testAllGet() {
		Client c = new Client(1, "Cliente");
		assertNotNull(c.getCliId());
		assertNotNull(c.getCliName());
	}
}
