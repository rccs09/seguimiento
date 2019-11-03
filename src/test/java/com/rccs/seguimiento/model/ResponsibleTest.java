package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponsibleTest {
	@Test
	public void testAllSet() {
		Responsible r = new Responsible();
		r.setRpsId(1);
		r.setRpsName("Nombre");
		r.setRpsLastName("Apellido");
		r.setPrvId(1);
		assertNotNull(r.toString());
	}
	
	@Test
	public void testAllGet() {
		Responsible r = new Responsible(1, "Nombre", "Apellido", 1);
		assertNotNull(r.getRpsId());
		assertNotNull(r.getRpsName());
		assertNotNull(r.getRpsLastName());
		assertNotNull(r.getPrvId());
	}
}
