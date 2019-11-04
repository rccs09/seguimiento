package com.rccs.seguimiento.controller;

import java.util.Date;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.rccs.seguimiento.utils.Constants;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Component(value = "constantesController")
@ELBeanName(value = "constantesController")
public class ConstantesController {
	
	public Date getFechaDelSistema() {
		Date fecha = new Date();
		return fecha;
    }
	
	public String getMsgCampoRequerido() {
		return Constants.FORM_MSG_CAMP_REQUIRED;
	}
	
	public String getFormSeleccione() {
		return Constants.FORM_SELECCIONE;
	}

}
