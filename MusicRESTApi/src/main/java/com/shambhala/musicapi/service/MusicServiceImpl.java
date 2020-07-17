package com.shambhala.musicapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shambhala.musicapi.dao.MusicDAO;
import com.shambhala.musicapi.entity.Tracks;

@Service
public class MusicServiceImpl implements MusicService{
	
	@Autowired
	private MusicDAO mDAO;
	
	@Override
	@Transactional
	public List<Tracks> get() {
		return mDAO.get();
	}

	@Override
	@Transactional
	public Tracks getSong(Long id) {
		return mDAO.getSong(id);
	}
	
	@Override
	public List<Tracks> getSongBySearch(String keyword) {
		return mDAO.getSongBySearch(keyword);
	}

	@Override
	@Transactional
	public long addSong(Tracks track) {
		return mDAO.addSong(track);
	}

	@Override
	@Transactional
	public void updateSong(Long id, Tracks track) {
		mDAO.updateSong(id, track);
	}

	@Override
	@Transactional
	public void deleteSong(Long id) {
		mDAO.deleteSong(id);
	}

	

}
