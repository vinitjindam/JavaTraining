package com.crudplayer.crudplayerdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudplayer.crudplayerdemo.dao.PlayerDao;
import com.crudplayer.crudplayerdemo.model.Player;

@Service
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired(required=false)
	PlayerDao playerDao;

	@Override
	public Player savePlayer(Player player) {
		player.setStatus("pending");
		player.setTeam("");
		playerDao.save(player);
		return player;
	}

	@Override
	public List<Player> getAllPlayers() {
		return (List<Player>)playerDao.findAll();
	}
	
	

}
