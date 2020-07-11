package com.shonamitambo.controller;

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

import com.shonamitambo.model.Game;
import com.shonamitambo.service.GameService;

@RestController
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping("/api/game")
	public ResponseEntity<List<Game>> list(){
		List<Game> list = gameService.list();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/api/game/{id}")
	public ResponseEntity<Game> getSingleGame(@PathVariable("id") long id){
		Game game = gameService.get(id);
		
		return ResponseEntity.ok().body(game);
	}
	
	@PostMapping("/api/game")
	public ResponseEntity<?> saveGame(@RequestBody Game game){
		long id = gameService.save(game);
		
		return ResponseEntity.ok().body("The game with id " + id + " has been saved into the database");
	}
	
	@PutMapping("/api/game/{id}")
	public ResponseEntity<?> updateGame(@PathVariable long id, @RequestBody Game game){
		gameService.update(id, game);
		
		return ResponseEntity.ok().body("Game has been updated");
	}
	
	@DeleteMapping("/api/game/{id}")
	public ResponseEntity<?> deleteGame(@PathVariable long id){
		gameService.delete(id);
		
		return ResponseEntity.ok().body("Game has been deleted");
	}
	
	
}
