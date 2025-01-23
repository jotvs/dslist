package com.jotvs.dslist.controller;

import com.jotvs.dslist.DTO.GameDTO;
import com.jotvs.dslist.DTO.GameListDTO;
import com.jotvs.dslist.DTO.GameMinDTO;
import com.jotvs.dslist.services.GameListService;
import com.jotvs.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List <GameListDTO> result = gameListService.findAll();
        return result;
    }

}
