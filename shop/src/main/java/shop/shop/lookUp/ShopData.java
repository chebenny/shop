package shop.shop.lookUp;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import shop.shop.data.ShopRepository;
import shop.shop.model.Shop;

@ManagedBean(name="ShopData")
@RequestScoped
@Named
public class ShopData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ShopRepository shopRepository;
	
	@Inject
	private Logger log;
	
/*	public Shop findShopById(Long id) {
		return shopRepository.findByShopId(id);
	}*/
	
	public List<Shop> findAllShopById() {
		return shopRepository.findAllOrderedByShop();
	}
}
