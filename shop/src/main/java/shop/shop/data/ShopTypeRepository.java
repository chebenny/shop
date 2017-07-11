package shop.shop.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import shop.shop.model.ShopType;

@ApplicationScoped
public class ShopTypeRepository {

	@Inject
	private EntityManager em;
	
	public ShopType findByShopTypeId(int shopTypeId) {
		return em.find(ShopType.class, shopTypeId);
	}
	
	public List<ShopType> findAllShopTypeOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<ShopType> criteria = cb.createQuery(ShopType.class);
		Root<ShopType> shopType = criteria.from(ShopType.class);
		criteria.select(shopType).orderBy(cb.asc(shopType.get("name")));
		return em.createQuery(criteria).getResultList();		
	}
}
