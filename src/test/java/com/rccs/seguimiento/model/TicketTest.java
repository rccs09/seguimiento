package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketTest {
	
	@Test
	public void testAllSet() {
		Ticket t = new Ticket();
		t.setTckId(1);
		t.setTckCode("DEV-84");
		t.setTckUrl("http://prueba");
		t.setTckType(0);
		t.setTckStatus(0);
		t.setTckFlow(0);
		t.setTckStimated(new BigDecimal(2));;
		t.setTckDateIni(new Timestamp((new Date()).getTime()));
		t.setTckDateEnd(new Timestamp((new Date()).getTime()));
		t.setTckDateEndPlan(new Timestamp((new Date()).getTime()));
		t.setSolId(1);
		assertNotNull(t.toString());
	}
	
	@Test
	public void testAllGet() {
		Ticket t = new Ticket(1, "DEV-84", "http://prueba",0,0,0, new BigDecimal(2),
				new Timestamp((new Date()).getTime()), new Timestamp((new Date()).getTime()), 
				new Timestamp((new Date()).getTime()), 1);
		assertNotNull(t.getTckId());
		assertNotNull(t.getTckCode());
		assertNotNull(t.getTckUrl());
		assertNotNull(t.getTckType());
		assertNotNull(t.getTckStatus());
		assertNotNull(t.getTckFlow());
		assertNotNull(t.getTckStimated());
		assertNotNull(t.getTckDateIni());
		assertNotNull(t.getTckDateEnd());
		assertNotNull(t.getTckDateEndPlan());
		assertNotNull(t.getSolId());
		
	}
	
	
}
