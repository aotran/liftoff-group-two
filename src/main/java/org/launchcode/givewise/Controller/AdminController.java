package org.launchcode.givewise.Controller;

import org.launchcode.givewise.models.data.FavoritesRepository;
import org.launchcode.givewise.models.data.ProductRepository;
import org.launchcode.givewise.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FavoritesRepository favoritesRepository;


}
