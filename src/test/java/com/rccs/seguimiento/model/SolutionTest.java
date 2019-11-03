package com.rccs.seguimiento.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SolutionTest {
	@Test
	public void testAllSet() {
		Solution s = new Solution();
		s.setSolId(1);
		s.setSolName("Solucion");
		s.setCliId(1);
		assertNotNull(s.toString());
	}
	
	@Test
	public void testAllGet() {
		Solution s = new Solution(1, "Solucion", 1);
		assertNotNull(s.getSolId());
		assertNotNull(s.getSolName());
		assertNotNull(s.getCliId());
	}
}
