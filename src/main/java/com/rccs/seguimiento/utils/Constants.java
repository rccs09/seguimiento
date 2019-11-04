package com.rccs.seguimiento.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
	
	public static final Map<Integer, String> TCK_TYPE;
	public static final Map<Integer, String> TCK_STATUS;
	public static final Map<Integer, String> TCK_FLOW;
	
	public static final Map<Integer, String> DTCK_STATUS;
	
	static{
		TCK_TYPE = new HashMap<>();
		TCK_TYPE.put(1, "Defecto");
		TCK_TYPE.put(2, "Vulnerabilidad");
		TCK_TYPE.put(3, "Requerimiento");
		TCK_TYPE.put(4, "Estimado");
		
		TCK_STATUS = new HashMap<>();
		TCK_STATUS.put(1, "En progreso");
		TCK_STATUS.put(2, "Causa/Solución");
		TCK_STATUS.put(3, "Finalizado");
		
		TCK_FLOW = new HashMap<>();
		TCK_FLOW.put(1, "Nuevo");
		TCK_FLOW.put(2, "En progreso");
		TCK_FLOW.put(3, "Asignado SD");
		TCK_FLOW.put(4, "Resuelto");
		TCK_FLOW.put(5, "Cerrado");
		TCK_FLOW.put(6, "Won fix");
		
		DTCK_STATUS = new HashMap<>();
		DTCK_STATUS.put(1, "En analisis");
		DTCK_STATUS.put(2, "En desarrollo");
		DTCK_STATUS.put(3, "Entregado a QA");
		DTCK_STATUS.put(4, "Finalizado");
	}
	
	public static final String FORM_MSG_CAMP_REQUIRED = "Campo requerido";
	
	public static final String FORM_FORMATO_FECHA = "dd/MM/yyyy";
	
	public static final String FORM_FORMATO_FECHA_HORA = "dd/MM/yyyy HH:mm";
	
	public static final String FORM_SELECCIONE = "SELECCIONE...";
}
