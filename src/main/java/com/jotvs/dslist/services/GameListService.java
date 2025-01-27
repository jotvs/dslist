package com.jotvs.dslist.services;

import com.jotvs.dslist.DTO.GameListDTO;
import com.jotvs.dslist.DTO.GameMinDTO;
import com.jotvs.dslist.entities.Game;
import com.jotvs.dslist.entities.GameList;
import com.jotvs.dslist.projection.GameMinProjection;
import com.jotvs.dslist.repositories.GameListRepository;
import com.jotvs.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    //Injetamos o componente (a dependencia) Repository com a annotation @Autowired dentro de GameService
    //Vamos utilizar o gameRepository para fazer as consultas no BD
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList entity = gameListRepository.findById(id).get();
        return new GameListDTO(entity);
    }
    @Transactional (readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        //Transformamos oq é GameList para GameListDTO
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long gameListId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(gameListId);

        //obj aponta para o sourceIndex (game) removido da lista
        GameMinProjection obj = list.remove(sourceIndex);

        //Adicionamos obg na posição desejada - o objeto que estava no lugar de destino avança uma position
        list.add(destinationIndex, obj);

        //Achamos o primeiro e o ultimo index dessa lista
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        //Atualização da lista no banco de dados
        for( int i = min; i <= max; i++){
            //Id da lista, Id do game, atualiza para posição i
            gameListRepository.updateBelongingPosition(gameListId, list.get(i).getId(), i);
        }
    }

}
