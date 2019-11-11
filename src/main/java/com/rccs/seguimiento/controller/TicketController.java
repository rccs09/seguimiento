package com.rccs.seguimiento.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.rccs.seguimiento.dto.TicketDetailDto;
import com.rccs.seguimiento.dto.TicketDto;
import com.rccs.seguimiento.model.ComponentSol;
import com.rccs.seguimiento.model.Responsible;
import com.rccs.seguimiento.model.Solution;
import com.rccs.seguimiento.model.Ticket;
import com.rccs.seguimiento.model.TicketDetail;
import com.rccs.seguimiento.service.ComponentService;
import com.rccs.seguimiento.service.ResponsibleService;
import com.rccs.seguimiento.service.SolutionService;
import com.rccs.seguimiento.service.TicketDetailService;
import com.rccs.seguimiento.service.TicketService;

@Scope(value = "session")
@Component(value = "ticketController")
@ELBeanName(value = "ticketController")
@Join(path = "/page/admin/tickets/list", to = "/page/admin/tickets/list-form.jsf")
public class TicketController {
	private static final Logger logger = LoggerFactory.getLogger(TicketController.class);
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	SolutionService solutionService;
	
	@Autowired
	TicketDetailService ticketDetailService;
	
	@Autowired
	ComponentService componentService;
	
	@Autowired
	ResponsibleService responsibleService;
	
	private TicketDto ticketFound;
	private List<TicketDto> listFndTicket;
	private TicketDto ticketEdit;
	private Integer tckFlagNew;
	private TicketDto ticketDelete;
	private List<Solution> listSolution;
	
	
	private List<TicketDetailDto> listTicketDetail;
	private TicketDetailDto detailDtoEdit;
	private TicketDetailDto detailDtoDelete;
	private Integer detailFlagNew;
	private List<ComponentSol> listComponent;
	private List<Responsible> listResponsible;
	
	//********************************************************
	// pantalla de lista de tickets de incidentes
	//********************************************************
	public String initListTicket() {
		listFndTicket = null;
		ticketFound = null;
		getListFndTicket();
		return "ticketList";
	}
	
	public String findByCode(){
		listFndTicket = null;
		getListFndTicket();
		return null;
	}
	
	public String findReset(){
		listFndTicket = null;
		ticketFound = null;
		getListFndTicket();
		return null;
	}
	
	public String goNewTicket() {
		tckFlagNew = 0;
		Ticket t = new Ticket();
		ticketEdit = new TicketDto();
		ticketEdit.setTicket(t);
		return "goNewTicket";
	}
	
	public String goEditTicket(TicketDto tdto) {
		tckFlagNew = 1;
		ticketEdit = tdto;
//		ticketEdit.setTckDateIniDt(new Date(tdto.getTicket().getTckDateIni().getTime()));
//		ticketEdit.setTckDateEndDt(new Date(tdto.getTicket().getTckDateEnd().getTime()));
//		ticketEdit.setTckDateEndPlanDt(new Date(tdto.getTicket().getTckDateEndPlan().getTime()));
		return "goNewTicket";
	}
	
	public String goViewTicket(TicketDto tdto) {
		ticketEdit = tdto;
//		ticketEdit.setTckDateIniDt(new Date(tdto.getTicket().getTckDateIni().getTime()));
//		ticketEdit.setTckDateEndDt(new Date(tdto.getTicket().getTckDateEnd().getTime()));
//		ticketEdit.setTckDateEndPlanDt(new Date(tdto.getTicket().getTckDateEndPlan().getTime()));
		return "goViewTicket";
	}
	
	public String cancelViewTicket() {
		listFndTicket = null;
		ticketFound = null;
		getListFndTicket();
		return "returnListTicket";
	}
	
	public String viewTicketDetail(TicketDto tdto) {
		listTicketDetail = null;
		ticketEdit = tdto;
		//carga de la lista de componentes por solucion
		if(ticketEdit != null && ticketEdit.getTicket() != null ) {
			listComponent = componentService.componetBySolution(ticketEdit.getTicket().getSolId());
		}else {
			 FacesContext fc = FacesContext.getCurrentInstance();
		        fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al buscar los componentes por solucion",""));
			return null;
		}
		getListTicketDetail();
		return "viewDetail";
	}
	
	public String confDeleteTicket(TicketDto tdto) {
		ticketDelete = tdto;
		return "refreshList";
	}
	
	public String cancelDelTicket() {
		ticketDelete = null;
		return "refreshList";
	}
	
	public String deleteTicket() {
		if(ticketDelete != null && ticketDelete.getTicket() != null) {
			System.out.println(ticketDelete.toString());
			ticketService.delete(ticketDelete.getTicket());
		}
		ticketDelete = null;
		ticketFound = null;
		listFndTicket = null;
		getListFndTicket();
		return "refreshList";
	}
	
	public String cancelEditTicket() {
		ticketEdit = null;
		getListFndTicket();
		return "cancelNewTicket";
	}
	
	public String saveTicket() {
		ticketEdit.getTicket().setTckDateEndPlan(new Timestamp(ticketEdit.getTckDateEndPlanDt().getTime()));
		ticketEdit.getTicket().setTckDateIni(new Timestamp(ticketEdit.getTckDateIniDt().getTime()));
		ticketEdit.getTicket().setTckDateEnd(new Timestamp(ticketEdit.getTckDateEndDt().getTime()));
		ticketService.save(ticketEdit.getTicket());
		//reestablecer lista
		ticketFound = null;
		listFndTicket = null;
		getListFndTicket();
		return "cancelNuevoTicket";
	}
	
	public String updateTicket() {
		ticketEdit.getTicket().setTckDateEndPlan(new Timestamp(ticketEdit.getTckDateEndPlanDt().getTime()));
		ticketEdit.getTicket().setTckDateIni(new Timestamp(ticketEdit.getTckDateIniDt().getTime()));
		ticketEdit.getTicket().setTckDateEnd(new Timestamp(ticketEdit.getTckDateEndDt().getTime()));
		ticketService.update(ticketEdit.getTicket());
		//reestablecer lista
		ticketFound = null;
		listFndTicket = null;
		getListFndTicket();
		return "cancelNuevoTicket";
	}
	
	//********************************************************
	// pantalla de detalles de tickets de incidentes
	//********************************************************
	public String returnList() {
		logger.info("Ejecucion : 111111111111111111111");
		ticketEdit = null;
		getListFndTicket();
		return "returnList";
	}
	
	public String goEditDetail(TicketDetailDto tdto) {
		logger.info("Ejecucion : 2222222222222222");
		detailFlagNew = 1;
		detailDtoEdit = tdto;
	
		getListResponsible();
		return "goNewDetail";
	}
	
	public String goViewDetail(TicketDetailDto tdto) {
		logger.info("Ejecucion : 333333333333333");
		detailDtoEdit = tdto;
		return "goViewDetail";
	}
	
	public String cancelViewDetail() {
		logger.info("Ejecucion : 5555");
		detailDtoEdit = null;
		return "cancelViewDetail";
	}
	
	public String cancelEditDetail() {
		logger.info("Ejecucion : 66666");
		detailDtoEdit = null;
		return "cancelNewDetail";
	}

	public String goNewDetail() {
		logger.info("Ejecucion : 777777777 1");
		detailFlagNew = 0;
		detailDtoEdit = new TicketDetailDto();
		TicketDetail td = new TicketDetail();
		td.setDtkStatus(0);
		detailDtoEdit.setTicketDetail(td);
		detailDtoEdit.setTicketDto(ticketEdit);
		logger.info("Ejecucion : 777777777 2");
		tckFlagNew = 0;
		logger.info("Ejecucion : 777777777 3");
		return "goNewDetail";
	}
	
	
	public String saveDetail() {
		logger.info("Ejecucion : 888888888888 1");
		detailDtoEdit.getTicketDetail().setDtkDateEndPlan(new Timestamp(detailDtoEdit.getDtkDateEndPlanDt().getTime()));
		logger.info("Ejecucion : 888888888888 2");
		detailDtoEdit.getTicketDetail().setDtkDateIni(new Timestamp(detailDtoEdit.getDtkDateIniDt().getTime()));
		logger.info("Ejecucion : 888888888888 3");
		detailDtoEdit.getTicketDetail().setDtkDateEnd(new Timestamp(detailDtoEdit.getDtkDateEndDt().getTime()));
		logger.info("Ejecucion : 888888888888 4");
		System.out.println(ticketEdit.toString());
		
		logger.info("Ejecucion : 888888888888 44444");
		System.out.println(detailDtoEdit.getTicketDto().toString());
		
		
		ticketDetailService.save(detailDtoEdit);
		logger.info("Ejecucion : 888888888888 5");
		//reestablecer lista
		detailDtoEdit = null;
		logger.info("Ejecucion : 888888888888 6");
		listTicketDetail = null;
		logger.info("Ejecucion : 888888888888 7");
		getListTicketDetail();
		logger.info("Ejecucion : 888888888888 8");
		return "cancelNewDetail";
	}
	
	public String updateDetail() {
		ticketEdit.getTicket().setTckDateEndPlan(new Timestamp(ticketEdit.getTckDateEndPlanDt().getTime()));
		ticketEdit.getTicket().setTckDateIni(new Timestamp(ticketEdit.getTckDateIniDt().getTime()));
		ticketEdit.getTicket().setTckDateEnd(new Timestamp(ticketEdit.getTckDateEndDt().getTime()));
		ticketDetailService.update(detailDtoEdit);
		//reestablecer lista
		detailDtoEdit = null;
		listTicketDetail = null;
		getListTicketDetail();
		return "cancelNewDetail";
	}

	public String confDeleteDetail(TicketDetailDto dtdto) {
		detailDtoDelete = dtdto;
		return "refreshList";
	}
	
	public String cancelDelDetail() {
		detailDtoDelete = null;
		return "refreshList";
	}
	
	public String deleteDetail() {
		if(detailDtoDelete != null && detailDtoDelete.getTicketDetail() != null) {
			System.out.println(detailDtoDelete.toString());
			ticketDetailService.delete(detailDtoDelete);
		}
		detailDtoDelete = null;
		listTicketDetail = null;
		getListTicketDetail();
		return "refreshList";
	}
	
	
//	
//	
//	
//	// Metodos para detalles
//	public String irNuevoDetalle() {
////		ticketEdit = null;
////		getListFndTicket();
//		return "irNuevoDetalle";
//	}
	
	
	
	
	//metodos accesores
	public List<Solution> getListSolution() {
		if(listSolution == null || listSolution.size()==0) {
			listSolution = solutionService.allSolution();
		}
		return listSolution;
	}

	public void setListSolution(List<Solution> listSolution) {
		this.listSolution = listSolution;
	}
	
	public TicketDto getTicketFound() {
		return ticketFound;
	}
	
	public void setTicketFound(TicketDto ticketFound) {
		this.ticketFound = ticketFound;
	}
	
	public List<TicketDto> getListFndTicket() {
		if(ticketFound == null){
			ticketFound = new TicketDto();
			ticketFound.setTicket(new Ticket());
			ticketFound.getTicket().setTckCode("");
		}else if (ticketFound.getTicket()==null) {
			ticketFound.setTicket(new Ticket());
			ticketFound.getTicket().setTckCode("");
		}
		if(listFndTicket == null){
			listFndTicket = ticketService.findByCode(ticketFound.getTicket().getTckCode());
		}
		return listFndTicket;
	}
	
	public void setListFndTicket(List<TicketDto> listFndTicket) {
		this.listFndTicket = listFndTicket;
	}
	
	public List<TicketDetailDto> getListTicketDetail() {
		if(listTicketDetail == null) {
			listTicketDetail = ticketDetailService.findByDetDtoTicket(ticketEdit);
		}
		return listTicketDetail;
	}

	public void setListTicketDetail(List<TicketDetailDto> listTicketDetail) {
		this.listTicketDetail = listTicketDetail;
	}

	public TicketDto getTicketEdit() {
		return ticketEdit;
	}
	
	public void setTicketEdit(TicketDto ticketEdit) {
		this.ticketEdit = ticketEdit;
	}

	public Integer getTckFlagNew() {
		return tckFlagNew;
	}

	public void setTckFlagNew(Integer tckFlagNew) {
		this.tckFlagNew = tckFlagNew;
	}

	public TicketDto getTicketDelete() {
		return ticketDelete;
	}

	public void setTicketDelete(TicketDto ticketDelete) {
		this.ticketDelete = ticketDelete;
	}

	public TicketDetailDto getDetailDtoEdit() {
		return detailDtoEdit;
	}

	public void setDetailDtoEdit(TicketDetailDto detailDtoEdit) {
		this.detailDtoEdit = detailDtoEdit;
	}

	public Integer getDetailFlagNew() {
		return detailFlagNew;
	}

	public void setDetailFlagNew(Integer detailFlagNew) {
		this.detailFlagNew = detailFlagNew;
	}

	public List<ComponentSol> getListComponent() {
		return listComponent;
	}

	public void setListComponent(List<ComponentSol> listComponent) {
		this.listComponent = listComponent;
	}

	public List<Responsible> getListResponsible() {
		if(listResponsible == null) {
			listResponsible = responsibleService.allResponsible();
		}
		return listResponsible;
	}

	public void setListResponsible(List<Responsible> listResponsible) {
		this.listResponsible = listResponsible;
	}

	public TicketDetailDto getDetailDtoDelete() {
		return detailDtoDelete;
	}

	public void setDetailDtoDelete(TicketDetailDto detailDtoDelete) {
		this.detailDtoDelete = detailDtoDelete;
	}
	
	
}
