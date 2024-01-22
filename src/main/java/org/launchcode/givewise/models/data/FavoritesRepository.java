package org.launchcode.givewise.models.data;

import org.launchcode.givewise.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {
}
