package shop.shop.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import shop.shop.model.Shop;

@ApplicationScoped
public class ShopRepository {

	@Inject
	private EntityManager em;
	
	//find object by id
	public Shop findByShopId(Long shopId){
		return em.find(Shop.class, shopId);
	}
	
	public Shop findByShopName(String shopName) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Shop> criteria = cb.createQuery(Shop.class);
		Root<Shop> shop = criteria.from(Shop.class);
		criteria.select(shop).where(cb.equal(shop.get("name"), shopName));
		return em.createQuery(criteria).getSingleResult();		
	}
	
	//return list
	public List<Shop> findAllOrderedByShop(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Shop>criteria = cb.createQuery(Shop.class);
		Root<Shop>shop = criteria.from(Shop.class);
		criteria.select(shop).orderBy(cb.asc(shop.get("name")));
		return em.createQuery(criteria).getResultList();		
	}
	
}
