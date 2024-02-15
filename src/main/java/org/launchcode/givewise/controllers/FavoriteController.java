package org.launchcode.givewise.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.givewise.models.Favorites;
import org.launchcode.givewise.models.Product;
import org.launchcode.givewise.models.data.FavoritesRepository;
import org.launchcode.givewise.request.FavoriteRequest;
import org.launchcode.givewise.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.launchcode.givewise.config.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

@Slf4j
@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoritesService favoritesService;

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping("/add")
    public ResponseEntity<Favorites> addFavourite(@RequestBody FavoriteRequest favoriteDto){
        Favorites favorites = favoritesService.addFavorite(favoriteDto);
        log.info("Favorites added: {}", favorites);
        return ResponseEntity.ok(favorites);
    }
//    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Favorites>> getProduct() {
//        Integer userId = null;
//        List<Favorites> favorites = favoritesRepository.findByUserId(userId);
//
//        return ResponseEntity.ok(favorites);
//    }


}
