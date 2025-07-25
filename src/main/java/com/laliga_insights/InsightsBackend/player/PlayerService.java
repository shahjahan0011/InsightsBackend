package com.laliga_insights.InsightsBackend.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByTeam(String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam_name()))
                .collect(Collectors.toList());
    }

    public List<Player> getMultiplePlayers(List<String> searchText){
        List<String> lowerCaseSearchText = searchText.stream()
                .map(String::toLowerCase)
                .toList();

        return playerRepository.findAll().stream()
                .filter(player -> lowerCaseSearchText.stream().anyMatch(search -> player.getName().toLowerCase().contains(search))) //works with incomplete strings
                //lowerCaseSearchText.contains(player.getName().toLowerCase()) 'needed eact string to work'
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByPosition(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

//    public List<Player> getPlayerByCountry(String searchText){
//        return playerRepository.findAll().stream()
//                .filter(player -> player.getCountry().toLowerCase().contains(searchText.toLowerCase()))
//                .collect(Collectors.toList());
//    }
    public List<Player> getPlayerByCountry(String searchText) {
        return playerRepository.findByCountryContainingIgnoreCase(searchText.trim());
    }

    public List<Player> getPlayerByTeamAndPosition(String teamName, String position){
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam_name()) && position.equals(player.getPos()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player updatePlayer = existingPlayer.get();
            updatePlayer.setName(updatedPlayer.getName());
            updatePlayer.setTeam_name(updatedPlayer.getTeam_name());
            updatePlayer.setPos(updatedPlayer.getPos());
            updatePlayer.setCountry(updatedPlayer.getCountry());

            playerRepository.save(updatePlayer);
            return updatePlayer;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }


}
