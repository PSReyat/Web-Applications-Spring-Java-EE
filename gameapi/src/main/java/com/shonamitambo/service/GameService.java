package com.shonamitambo.service;

import java.util.List;

import com.shonamitambo.model.Game;

public interface GameService {
	long save(Game game);

	Game get(long id);

	List<Game> list();

	void update(long id, Game game);

	void delete(long id);
}
