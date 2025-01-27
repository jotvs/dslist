package com.jotvs.dslist.repositories;

import com.jotvs.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Modifying
    @Query(nativeQuery = true, value = """
    UPDATE tb_belonging SET position = :newPosition 
    WHERE gamelist_id = :gamelist_id 
    AND game_id = :gameId
    """)
    void updateBelongingPosition(Long gamelist_id, Long gameId, Integer newPosition);
}
