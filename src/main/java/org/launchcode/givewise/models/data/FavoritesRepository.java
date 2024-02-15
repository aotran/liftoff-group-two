package org.launchcode.givewise.models.data;

import org.launchcode.givewise.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {
//    List<Favorites> findByUserId(Integer userId);
}
