package com.swp391.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class ProductsRepositoryCustomImpl implements ProductsRepositoryCustom{

	 @PersistenceContext
	    private EntityManager entityManager;

	    @Override
	    @Transactional
	    public void deleteProductAndRelatedData(String productId) {
	        entityManager.createNativeQuery("DELETE FROM product_in_order WHERE product_id = :productId")
	                .setParameter("productId", productId)
	                .executeUpdate();

	        entityManager.createNativeQuery("DELETE FROM replycomments WHERE feedback_id IN (SELECT feedback_id FROM feedbacks WHERE product_id = :productId)")
	                .setParameter("productId", productId)
	                .executeUpdate();

	        entityManager.createNativeQuery("DELETE FROM feedbacks WHERE product_id = :productId")
	                .setParameter("productId", productId)
	                .executeUpdate();

	        entityManager.createNativeQuery("DELETE FROM products WHERE product_id = :productId")
	                .setParameter("productId", productId)
	                .executeUpdate();
	    }

}
