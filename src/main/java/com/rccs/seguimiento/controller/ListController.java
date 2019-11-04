package com.rccs.seguimiento.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.rccs.seguimiento.utils.Constants;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Component(value = "listController")
@ELBeanName(value = "listController")
public class ListController {
	
	public List<SelectItem> getListaComboTckType()	{
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		for (Map.Entry<Integer, String> entry : Constants.TCK_TYPE.entrySet()) {
			retorno.add(new SelectItem(entry.getKey(),entry.getValue()));
		}
		return retorno;
	}
	
	public List<SelectItem> getListaComboTckStatus()	{
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		for (Map.Entry<Integer, String> entry : Constants.TCK_STATUS.entrySet()) {
			retorno.add(new SelectItem(entry.getKey(),entry.getValue()));
		}
		return retorno;
	}
	
	public List<SelectItem> getListaComboTckFlow()	{
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		for (Map.Entry<Integer, String> entry : Constants.TCK_FLOW.entrySet()) {
			retorno.add(new SelectItem(entry.getKey(),entry.getValue()));
		}
		return retorno;
	}

}
