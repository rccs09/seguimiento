package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderTest {
	
	@Test
	public void testAllSet() {
		Provider p = new Provider();
		p.setPrvId(1);
		p.setPrvName("proveedor");
		assertNotNull(p.toString());
	}
	
	@Test
	public void testAllGet() {
		Provider p = new Provider(1,"Proveedor");
		assertNotNull(p.getPrvId());
		assertNotNull(p.getPrvName());
	}
	
}
