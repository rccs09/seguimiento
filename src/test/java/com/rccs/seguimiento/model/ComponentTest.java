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
		ComponentSol c = new ComponentSol();
		c.setCmpId(1);
		c.setCmpName("MUA");
		c.setSolId(1);
		assertNotNull(c.toString());
	}
	
	@Test
	public void testAllGet() {
		ComponentSol c = new ComponentSol(1, "MUA", 1);
		assertNotNull(c.getCmpId());
		assertNotNull(c.getCmpName());
		assertNotNull(c.getSolId());
	}
}
