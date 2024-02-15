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

//    public List<Favorites> getFavoritesByUserId(Integer userId) {
//        return favoritesRepo.findByUserId(userId);
//    }

}


