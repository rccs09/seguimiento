package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.ComponentDao;
import com.rccs.seguimiento.model.ComponentSol;
import com.rccs.seguimiento.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService{
	@Autowired
	ComponentDao componentDao;
	
	@Override
	public List<ComponentSol> componetBySolution(int solId) {
		return componentDao.componetBySolution(solId);
	}
}
