package com.rccs.seguimiento.dao;

import java.util.List;

import com.rccs.seguimiento.model.ComponentSol;

public interface ComponentDao {
	List<ComponentSol> componetBySolution(int solId);
}
