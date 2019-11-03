package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ComponentTest {
	@Test
	public void testAllSet() {
		Component c = new Component();
		c.setCmpId(1);
		c.setCmpName("MUA");
		c.setSolId(1);
		assertNotNull(c.toString());
	}
	
	@Test
	public void testAllGet() {
		Component c = new Component(1, "MUA", 1);
		assertNotNull(c.getCmpId());
		assertNotNull(c.getCmpName());
		assertNotNull(c.getSolId());
	}
}
