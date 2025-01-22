package com.jotvs.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

//Sinaliza que estamos encapsulando dois atributos em um em uma classe só
@Embeddable
public class BelogingPK {
    @ManyToOne
    @JoinColumn(name = "game_id") //Definindo o nome da chave estrangeira
    private Game game;
    @ManyToOne
    @JoinColumn(name = "gameList_id")
    private GameList gameList;

    public BelogingPK() {
    }

    public BelogingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BelogingPK that = (BelogingPK) obj;
        return Objects.equals(getGame(), that.getGame()) && Objects.equals(getGameList(), that.getGameList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGame(), getGameList());
    }
}
