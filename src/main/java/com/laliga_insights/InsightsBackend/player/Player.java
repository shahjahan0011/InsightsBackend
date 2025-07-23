package com.laliga_insights.InsightsBackend.player;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "player_data")
public class Player {

    @Id
    @Column(name = "name") //players can have the same name
    private String name;
    private String country;
    private String position;
    private Integer age;
    private Integer matches_played;
    private Integer starts;
    private Integer minutes_played;
    private Integer goals;
    private Integer assists;
    private Integer penalty;
    private Integer yellow_cards;
    private Integer red_cards;
    private Integer expected_goals;
    private Integer expected_assists;
    private String team_name;

    public Player() {
    }

    public Player(String name, String country, String position, Integer age, Integer matches_played, Integer starts, Integer minutes_played, Integer goals, Integer assists, Integer penalty, Integer yellow_cards, Integer red_cards, Integer expected_goals, Integer expected_assists, String team_name) {
        this.name = name;
        this.country = country;
        this.position = position;
        this.age = age;
        this.matches_played = matches_played;
        this.starts = starts;
        this.minutes_played = minutes_played;
        this.goals = goals;
        this.assists = assists;
        this.penalty = penalty;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.expected_goals = expected_goals;
        this.expected_assists = expected_assists;
        this.team_name = team_name;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPos() {
        return position;
    }

    public void setPos(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMatches_played() {
        return matches_played;
    }

    public void setMatches_played(Integer matches_played) {
        this.matches_played = matches_played;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Integer getMinutes_played() {
        return minutes_played;
    }

    public void setMinutes_played(Integer minutes_played) {
        this.minutes_played = minutes_played;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getPenalties_scored() {
        return penalty;
    }

    public void setPenalties_scored(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getYellow_cards() {
        return yellow_cards;
    }

    public void setYellow_cards(Integer yellow_cards) {
        this.yellow_cards = yellow_cards;
    }

    public Integer getRed_cards() {
        return red_cards;
    }

    public void setRed_cards(Integer red_cards) {
        this.red_cards = red_cards;
    }

    public Integer getExpected_goals() {
        return expected_goals;
    }

    public void setExpected_goals(Integer expected_goals) {
        this.expected_goals = expected_goals;
    }

    public Integer getExpected_assists() {
        return expected_assists;
    }

    public void setExpected_assists(Integer expected_assists) {
        this.expected_assists = expected_assists;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}


