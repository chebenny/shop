package shop.shop.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import shop.shop.model.Shop;
import shop.shop.service.UpdateService;

@Model
public class UpdateController {

	@Inject
	private Logger log;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private UpdateService updateService;
	
	public void update(Shop shop){
		try {
			updateService.editService(shop);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
