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
public class TicketDetailTest {
	@Test
	public void testAllSet() {
		TicketDetail t = new TicketDetail();
		t.setDtkId(1);
		t.setDtkStatus(0);
		t.setDtkStimated(new BigDecimal(1));
		t.setDtkDateIni(new Timestamp((new Date()).getTime()));
		t.setDtkDateEnd(new Timestamp((new Date()).getTime()));
		t.setDtkDateEndPlan(new Timestamp((new Date()).getTime()));
		t.setRpsId(1);
		t.setTckId(1);
		t.setCmpId(1);
		assertNotNull(t.toString());
	}
	
	@Test
	public void testAllGet() {
		TicketDetail t = new TicketDetail(1,0, new BigDecimal(1),new Timestamp((new Date()).getTime()),
				new Timestamp((new Date()).getTime()),new Timestamp((new Date()).getTime()),1,1,1);
		assertNotNull(t.getDtkId());
		assertNotNull(t.getDtkStatus());
		assertNotNull(t.getDtkStimated());
		assertNotNull(t.getDtkDateIni());
		assertNotNull(t.getDtkDateEnd());
		assertNotNull(t.getDtkDateEndPlan());
		assertNotNull(t.getRpsId());
		assertNotNull(t.getTckId());
		assertNotNull(t.getCmpId());
	}
}
