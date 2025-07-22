package com.laliga_insights.InsightsBackend.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
        @RequestParam(required = false) String team,
        @RequestParam(required = false) List<String> name,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) String country){

            if(position != null && team != null){
                return playerService.getPlayerByTeamAndPosition(team, position);
            } else if (team != null) {
                return playerService.getPlayersByTeam(team);
            } else if (name != null) {
                return playerService.getMultiplePlayers(name);
            } else if (country != null) {
                return playerService.getPlayerByCountry(country);
            } else if (position != null) {
                return playerService.getPlayerByPosition(position);
            } else {
                return playerService.getPlayers();
            }
        }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player newPlayer) {
        Player createdPlayer = playerService.addPlayer(newPlayer);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player newPlayer) {
        Player updatedPlayer = playerService.updatePlayer(newPlayer);
        if (updatedPlayer != null) {
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName) {
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player Deleted Successfully", HttpStatus.OK);
    }
}
