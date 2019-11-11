package com.rccs.seguimiento.service;

import java.util.List;

import com.rccs.seguimiento.model.ComponentSol;

public interface ComponentService {
	List<ComponentSol> componetBySolution(int solId);
}
