package com.swp391.repository;

import jakarta.transaction.Transactional;

public interface ProductsRepositoryCustom {
	@Transactional
    void deleteProductAndRelatedData(String productId);

}
