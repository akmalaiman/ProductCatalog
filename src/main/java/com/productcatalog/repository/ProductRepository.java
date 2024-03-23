package com.productcatalog.repository;

import com.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

        Product findByName(String name);

        @Modifying
        @Transactional
        @Query(value="UPDATE product p SET p.code = ?2, p.name = ?3, p.category = ?4, p.brand = ?5, p.type = ?6, p.description = ?7 WHERE p.id = ?1 ", nativeQuery = true)
        int updateById(int id, String code, String name, String category, String brand, String type, String description);

        Product findByCode(String code);

        @Transactional
        void deleteByCode(String code);

        @Modifying
        @Transactional
        @Query(value="UPDATE product p SET p.code = ?2, p.name = ?3, p.category = ?4, p.brand = ?5, p.type = ?6, p.description = ?7 WHERE p.code = ?1 ", nativeQuery = true)
        int updateByCode(String code, String newCode, String name, String category, String brand, String type, String description);

}
