package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketQaTest {
	@Test
	public void testAllSet() {
		TicketQa t = new TicketQa();
		t.setTqaId(1);
		t.setTqaCode("dev-84");
		t.setTqaUrl("https://prueba");
		t.setTqaCycle(1);
		t.setTqaVersion("1.1.1.RC1");
		t.setTqaStatus(0);
		t.setTqaComment("comentario");
		t.setDtkId(1);
		assertNotNull(t.toString());
	}
	
	@Test
	public void testAllGet() {
		TicketQa t = new TicketQa(1,"dev-84","https://prueba",1,"1.1.1.RC1",0,"comentario",1);
		assertNotNull(t.getTqaId());
		assertNotNull(t.getTqaCode());
		assertNotNull(t.getTqaUrl());
		assertNotNull(t.getTqaCycle());
		assertNotNull(t.getTqaVersion());
		assertNotNull(t.getTqaStatus());
		assertNotNull(t.getTqaComment());
		assertNotNull(t.getDtkId());
		
	}
}
