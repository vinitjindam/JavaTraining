package com.crudplayer.crudplayerdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.crudplayer.crudplayerdemo.model.Player;
import com.crudplayer.crudplayerdemo.service.PlayerService;

@CrossOrigin
@RequestMapping("players")
@RestController
public class PlayerController {
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping
	public ResponseEntity<Player> savePlayer(@RequestBody Player player){
		return new ResponseEntity<Player>(playerService.savePlayer(player),HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<Player>> getAllPlayers(){
		return new ResponseEntity<List<Player>>(playerService.getAllPlayers(),HttpStatus.OK);
	}

}
