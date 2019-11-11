package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.ResponsibleDao;
import com.rccs.seguimiento.model.Responsible;
import com.rccs.seguimiento.service.ResponsibleService;

@Service
public class ResponsibleServiceImpl implements ResponsibleService{
	@Autowired
	ResponsibleDao responsibleDao;
	
	@Override
	public List<Responsible> allResponsible() {
		return responsibleDao.allResponsible();
	}
}
