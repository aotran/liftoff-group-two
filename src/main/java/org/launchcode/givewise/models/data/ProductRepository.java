package org.launchcode.givewise.models.data;


import org.launchcode.givewise.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

        @Query("SELECT p From Product p")
        List<Product> getAllProducts();
}
