package com.shambhala.musicapi.service;

import java.util.List;

import com.shambhala.musicapi.entity.Tracks;

public interface MusicService {
	
	List<Tracks> get();
	
	Tracks getSong(Long id);
	
	List<Tracks> getSongBySearch(String keyword);
	
	long addSong(Tracks track);
	
	void updateSong(Long id, Tracks track);
	
	void deleteSong(Long id);
	
}
