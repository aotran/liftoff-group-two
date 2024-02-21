package org.launchcode.givewise.service;

import org.launchcode.givewise.models.Product;
import org.launchcode.givewise.models.data.ProductRepository;
import org.launchcode.givewise.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public Product addProduct(ProductRequest request){
        Product product = new Product();
        product.setProductName(request.getProductName());
        product.setProductDescription(request.getProductDescription());
        product.setImage(request.getImage());
        product.setPrice(request.getPrice());
        product.setCompanyWebsite(request.getCompanyWebsite());
        return productRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProductsByCharacter(String searchTerm) {
        List<Product> allProducts = productRepo.findAll();

        // Filtering products whose names start with the specified character
        return allProducts.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(searchTerm.toLowerCase()))
                .collect(Collectors.toList());
    }
}

