package com.shonamitambo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shonamitambo.dao.GameDAO;
import com.shonamitambo.model.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO gameDAO;

	@Override
	@Transactional
	public long save(Game game) {
		return gameDAO.save(game);
	}

	@Override
	@Transactional
	public Game get(long id) {
		return gameDAO.get(id);
	}

	@Override
	@Transactional
	public List<Game> list() {
		return gameDAO.list();
	}

	@Override
	@Transactional
	public void update(long id, Game game) {
		gameDAO.update(id, game);
	}

	@Override
	@Transactional
	public void delete(long id) {
		gameDAO.delete(id);

	}

}
