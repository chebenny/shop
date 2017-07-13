package shop.shop.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import shop.shop.model.Shop;
import shop.shop.service.CreateService;

@Model
public class CreateController {

	@Inject
	private Logger log;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private CreateService createService;
	
	@Named
	@Produces
	private Shop newShop;
	
	@PostConstruct
	public void init(){
		newShop = new Shop();
	}
	
	public void createShop() throws Exception{
		
		try {
			createService.saveShop(newShop);
			
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Added!", "Save successful");
            facesContext.addMessage(null, m);
            
	        FacesContext.getCurrentInstance().getExternalContext().redirect("/shop/read/home.jsf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
