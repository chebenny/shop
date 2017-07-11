package shop.shop.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import shop.shop.service.DeleteService;

@Model
public class DeleteController {

	@Inject
	private Logger log;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private DeleteService deleteService;
	
	public void delete(Long id) throws Exception {
		try {
			deleteService.remove(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
