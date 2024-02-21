package org.launchcode.givewise.service;

import org.launchcode.givewise.models.Favorites;
import org.launchcode.givewise.models.Product;
import org.launchcode.givewise.models.User;
import org.launchcode.givewise.models.data.FavoritesRepository;
import org.launchcode.givewise.models.data.ProductRepository;
import org.launchcode.givewise.models.data.UserRepository;
import org.launchcode.givewise.request.FavoriteRequest;
import org.launchcode.givewise.request.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepo;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Favorites addFavorite(FavoriteRequest request) {
        Favorites favorites = new Favorites();
        User user = userRepository.findById(request.getUserid()).get();
        Product product = productRepository.findById(request.getProductid()).get();
        favorites.setUser(user);
        favorites.setProduct(product);
        return favoritesRepo.save(favorites);
    }

    public List<Favorites> findFavoritesWithProductDetails(Integer userId){

        List<Favorites> favorites = favoritesRepo.findByUserId(userId);

        for (Favorites favorite: favorites
             ) { Integer productId = favorite.getProduct().getId();
            Product product = productRepository.findById(productId).orElse(null);

            if (product != null) {
                favorite.setProduct(product);
            }
        }
        //System.out.println("Favorites with Product Details: " + favorites);

        return favorites;

        }

        public List<Product> userFavProduct(Integer userId) {

            List<Favorites> favorites = favoritesRepo.findByUserId(userId);

            List<Product> favProductList = new ArrayList<>();
            for (Favorites favorite: favorites
            ) { Integer productId = favorite.getProduct().getId();
                Product product = productRepository.findById(productId).orElse(null);

                if (product != null) {
                    favProductList.add(product);
                }
            }

            return favProductList;

        } // first we find the user's favorites, which is the product ids
    // second we find the product details in the product repository
    // third, we add it to a list, and return that list of products



    public boolean deleteFavorite(Integer userId, Integer productId) {
        // Find the favorite based on userId and productId
        Favorites favorite = favoritesRepo.findByUserIdAndProductId(userId, productId);

        if (favorite != null) {
            // Remove the favorite
            favoritesRepo.delete(favorite);
            return true; // Deletion successful
        } else {
            return false; // Favorite not found
        }
    }

    public boolean isProductInFavorites(Integer userId, Integer productId) {
        // Check if the combination of userId and productId exists in the favorites
        // You need to implement this logic based on your data model and database setup
        // This is just a placeholder, and you should replace it with your actual implementation
        return favoritesRepo.existsByUserIdAndProductId(userId, productId);
    }

}


