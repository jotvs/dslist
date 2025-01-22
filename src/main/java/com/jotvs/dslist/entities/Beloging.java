package com.jotvs.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_beloging")
public class Beloging {

    //Sinalizando a referência que a classe representa um ID de uma classe com dois atributos
    //que compôe esse ID
    @EmbeddedId
    private BelogingPK id = new BelogingPK();
    private Integer position;

    public Beloging(){
    }

    public BelogingPK getId() {
        return id;
    }

    public Beloging(Game game, GameList gameList, Integer position){
        //id é uma BelogingPK que possui esse métodos SET
        id.setGame(game);
        id.setGameList(gameList);
        this.position = position;
    }

    public void setId(BelogingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Beloging beloging = (Beloging) obj;
        return Objects.equals(getId(), beloging.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
