package com.shambhala.musicapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shambhala.musicapi.entity.Tracks;
import com.shambhala.musicapi.service.MusicService;

@RestController
public class MusicController{
	
	@Autowired
	MusicService mService;
	
	@GetMapping("/api/music")
	public ResponseEntity<List<Tracks>> listOfSongs(){
		List<Tracks> list = mService.get();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/api/music/{id}")
	public ResponseEntity<Tracks> getSong(@PathVariable("id") Long id){
		Tracks track = mService.getSong(id);
		
		return ResponseEntity.ok().body(track);
	}
	
	//Search functionality implemented in the REST API.
	@GetMapping("/api/music/search/{keyword}")
	public ResponseEntity<List<Tracks>> getSongBySearch(@PathVariable("keyword") String keyword){
		
		List<Tracks> list = mService.getSongBySearch(keyword);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@PostMapping("/api/music")
	public ResponseEntity<?> addSong(@RequestBody Tracks track){
		
		long id = mService.addSong(track);
		
		return ResponseEntity.ok().body("The track with the id: " + id + " has been saved into the database.");
		
	}
	
	@PutMapping("/api/music/{id}")
	public ResponseEntity<?> updateSong(@PathVariable("id") Long id, @RequestBody Tracks track){
		
		mService.updateSong(id, track);
		
		return ResponseEntity.ok().body("The track has been updated in the database.");
		
	}
	
	@DeleteMapping("/api/music/{id}")
	public ResponseEntity<?> deleteSong(@PathVariable("id") Long id){
		
		mService.deleteSong(id);
		
		return ResponseEntity.ok().body("Track has been deleted from the database");
	}
	
	
}
