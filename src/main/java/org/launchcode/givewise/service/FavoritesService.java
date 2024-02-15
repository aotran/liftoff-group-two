package org.launchcode.givewise.service;

import org.launchcode.givewise.models.Favorites;
import org.launchcode.givewise.models.data.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;



}

//    public List<Favorites> getFavoritesByUserId(Integer userId){
//    return favoritesRepository.findByUserId(userId);
