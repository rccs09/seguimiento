package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketProdTest {
	@Test
	public void testAllSet() {
		TicketProd t = new TicketProd();
		t.setTpdId(1);
		t.setTpdCode("PRODFCR-84");
		t.setTpdUrl("https://prueba");
		t.setTpdVersion("1.1.1.RC1");
		t.setTpdStatus(0);
		t.setTpdComment("comentario");
		t.setDtkId(1);
		assertNotNull(t.toString());
	}
	
	@Test
	public void testAllGet() {
		TicketProd t = new TicketProd(1,"PRODFCR-84","https://prueba","1.1.1.RC1",0,"comentario",1);
		assertNotNull(t.getTpdId());
		assertNotNull(t.getTpdCode());
		assertNotNull(t.getTpdUrl());
		assertNotNull(t.getTpdVersion());
		assertNotNull(t.getTpdStatus());
		assertNotNull(t.getTpdComment());
		assertNotNull(t.getDtkId());
	}
}
