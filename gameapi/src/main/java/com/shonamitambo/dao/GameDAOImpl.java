package com.shonamitambo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shonamitambo.model.Game;

@Repository
public class GameDAOImpl implements GameDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public long save(Game game) {
		sessionFactory.getCurrentSession().save(game);
		
		return game.getId();
	}

	@Override
	public Game get(long id) {
		return sessionFactory.getCurrentSession().get(Game.class, id);
	}

	@Override
	public List<Game> list() {
		List<Game> list = sessionFactory.getCurrentSession().createQuery("FROM GameList").list();
		
		return list;
	}

	@Override
	public void update(long id, Game game) {
		Session session = sessionFactory.getCurrentSession();
		Game previousGame = session.byId(Game.class).load(id);
		
		previousGame.setTitle(game.getTitle());
		previousGame.setDeveloper(game.getDeveloper());
		previousGame.setPublisher(game.getPublisher());
		previousGame.setReleaseYear(game.getReleaseYear());
		
		//session.flush();
		
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Game game = session.byId(Game.class).load(id);
		
		session.delete(game);
		
	}

}
