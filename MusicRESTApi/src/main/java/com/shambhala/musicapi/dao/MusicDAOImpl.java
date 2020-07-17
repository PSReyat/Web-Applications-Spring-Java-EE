package com.shambhala.musicapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shambhala.musicapi.entity.Tracks;

@Repository
public class MusicDAOImpl implements MusicDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@PersistenceContext
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Tracks> get() {
		List<Tracks> songs = sessionFactory.getCurrentSession().createQuery("FROM tracks").getResultList();
		
		return songs;
	}

	@Override
	public Tracks getSong(Long id) {
		Session session = sessionFactory.getCurrentSession();
		
		Tracks track = session.byId(Tracks.class).load(id);
		
		return track;
	}
	
	@Override
	public List<Tracks> getSongBySearch(String keyword) {
		
		String sql = "SELECT artist, title, album, genre, release_year "
				  + "FROM tracks "
				  + "WHERE artist REGEXP '" + keyword +"' OR "
				  + "title REGEXP '" + keyword + "' OR "
				  + "album REGEXP '" + keyword + "' OR "
				  + "genre REGEXP '" + keyword + "' OR "
				  + "release_year REGEXP '" + keyword + "'";
		
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery query = session.createSQLQuery(sql);
		
		List<Tracks> list = query.list();

		return list;
		
	}

	@Override
	public long addSong(Tracks track) {
		
		sessionFactory.getCurrentSession().save(track);
		
		return track.getId();
	}

	@Override
	public void updateSong(Long id, Tracks track) {
		
		Session session = sessionFactory.getCurrentSession();
		Tracks formerTrack = session.byId(Tracks.class).load(id);
		
		formerTrack.setArtist(track.getArtist());
		formerTrack.setTitle(track.getTitle());
		formerTrack.setAlbum(track.getAlbum());
		formerTrack.setGenre(track.getGenre());
		formerTrack.setTrackLength(track.getTrackLength());
		formerTrack.setReleaseYear(track.getReleaseYear());
		
		
		
		//session.update(formerTrack);
	}

	@Override
	public void deleteSong(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Tracks track = session.byId(Tracks.class).load(id);
		
		session.delete(track);
		
	}

}
