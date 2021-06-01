package com.packt.webstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.packt.webstore.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}