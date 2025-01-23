package com.jotvs.dslist.services;

import com.jotvs.dslist.DTO.GameDTO;
import com.jotvs.dslist.DTO.GameMinDTO;
import com.jotvs.dslist.entities.Game;
import com.jotvs.dslist.projection.GameMinProjection;
import com.jotvs.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    //Injetamos -a dependencia- o componente Repository com a annotation @Autowired dentro de GameService
    //Vamos utilizar o gameRepository para fazer as consultas no BD
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        //Transformamos oq é Game para GameMinDTO
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long gameListId) {
        List<GameMinProjection> result = gameRepository.searchByList(gameListId);
        //Transformamos oq é Game para GameMinDTO
        return result.stream().map(GameMinDTO::new).toList();
    }
}