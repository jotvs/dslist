package com.jotvs.dslist.repositories;

import com.jotvs.dslist.entities.Game;
import com.jotvs.dslist.projection.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """

		SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.gamelist_id =  gamelist_id
		ORDER BY tb_belonging.position
			""")
	List<GameMinProjection> searchByList(Long gamelist_id);
}
