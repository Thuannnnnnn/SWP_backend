package com.swp391.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.swp391.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, String>{

}
