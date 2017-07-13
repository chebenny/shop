package shop.shop.service;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import shop.shop.model.Shop;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CreateService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;
    
    @Resource 
    private UserTransaction tx;
    
    public void saveShop(Shop shop) throws IllegalStateException, SecurityException, SystemException {
    	try{
    		tx.begin();
    		
    			shop.setName(shop.getName());
    			shop.setDescription(shop.getDescription());
    			
    			em.persist(shop);
    		
    		tx.commit();
    	}catch(Exception e) {
    		tx.rollback();
    	}
    }
}
