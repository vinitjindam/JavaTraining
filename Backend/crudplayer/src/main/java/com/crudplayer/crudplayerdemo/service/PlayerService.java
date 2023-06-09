package com.crudplayer.crudplayerdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crudplayer.crudplayerdemo.model.Player;

@Service
public interface PlayerService {

	public Player savePlayer(Player player);
	public List<Player> getAllPlayers();
}
