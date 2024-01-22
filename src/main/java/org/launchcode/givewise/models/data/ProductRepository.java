package org.launchcode.givewise.models.data;


import org.launchcode.givewise.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
