package com.laliga_insights.InsightsBackend.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

    void deleteByName(String playerName);
    Optional<Player> findByName(String name);
    List<Player> findByCountryContainingIgnoreCase(String country);
    List<Player> findByNameContainingIgnoreCase(String name);
}
