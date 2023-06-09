package com.crudplayer.crudplayerdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudplayer.crudplayerdemo.model.Player;

@Repository
public interface PlayerDao extends JpaRepository<Player, String>{

}
