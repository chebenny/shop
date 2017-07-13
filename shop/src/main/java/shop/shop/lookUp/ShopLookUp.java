package shop.shop.lookUp;

import java.io.Serializable;
import java.util.List;


import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import shop.shop.model.Shop;

@ManagedBean
@RequestScoped
@Named
public class ShopLookUp implements Serializable{

	/**
	 * 
	 */
    
	private static final long serialVersionUID = 1L;
	private Long id;
	
    @Inject
    private EntityManager em;
	
	@Produces
    @Named("allShopList")
	public List<Shop> findAllShop() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Shop> criteria = cb.createQuery(Shop.class);
		Root<Shop> shopList = criteria.from(Shop.class);
		criteria.select(shopList).orderBy(cb.asc(shopList.get("name")));
		return em.createQuery(criteria).getResultList();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}  
}
