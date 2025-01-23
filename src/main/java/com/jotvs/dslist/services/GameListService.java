package com.jotvs.dslist.services;

import com.jotvs.dslist.DTO.GameListDTO;
import com.jotvs.dslist.DTO.GameMinDTO;
import com.jotvs.dslist.entities.Game;
import com.jotvs.dslist.entities.GameList;
import com.jotvs.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    //Injetamos -a dependencia- o componente Repository com a annotation @Autowired dentro de GameService
    //Vamos utilizar o gameRepository para fazer as consultas no BD
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional (readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //Transformamos oq é GameList para GameListDTO
        return result.stream().map(GameListDTO::new).toList();
    }

}
