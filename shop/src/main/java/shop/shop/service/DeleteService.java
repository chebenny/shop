package shop.shop.service;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import shop.shop.data.ShopRepository;
import shop.shop.model.Shop;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DeleteService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    @Inject
    private ShopRepository shopRepository;
    
    @Resource 
    private UserTransaction tx;
    
    public void remove(Long id) throws IllegalStateException, SecurityException, SystemException {
    	try{
    		tx.begin();
    		
    		Shop shop = shopRepository.findByShopId(id);
    		
    		em.remove(shop);
    		
    		tx.commit();
    	}catch(Exception e) {
    		tx.rollback();
    	}
    }
}
