package com.jotvs.dslist.controller;

import com.jotvs.dslist.DTO.GameDTO;
import com.jotvs.dslist.DTO.GameListDTO;
import com.jotvs.dslist.DTO.GameMinDTO;
import com.jotvs.dslist.DTO.ReplacementDTO;
import com.jotvs.dslist.services.GameListService;
import com.jotvs.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        GameListDTO result = gameListService.findById(id);
        return result;
    }
    @GetMapping
    public List<GameListDTO> findAll(){
        List <GameListDTO> result = gameListService.findAll();
        return result;
    }
    @GetMapping (value= "/{gameListId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long gameListId){
        List <GameMinDTO> result = gameService.findByList(gameListId);
        return result;
    }

    @PostMapping (value= "/{gameListId}/replacement")
    public void move(@PathVariable Long gameListId, @RequestBody ReplacementDTO body){
        gameListService.move(gameListId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
