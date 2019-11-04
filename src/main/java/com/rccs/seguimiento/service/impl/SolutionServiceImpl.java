package com.rccs.seguimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rccs.seguimiento.dao.SolutionDao;
import com.rccs.seguimiento.model.Solution;
import com.rccs.seguimiento.service.SolutionService;

@Service
public class SolutionServiceImpl implements SolutionService{
	@Autowired
	SolutionDao solutionDao;
	
	@Override
	public List<Solution> allSolution() {
		return solutionDao.allSolution();
	}
}
