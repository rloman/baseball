package eu.qnh.baseball.rest;

import eu.qnh.baseball.model.Player;
import eu.qnh.baseball.persistence.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping
    public Iterable<Player> list() {

        return this.playerRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Player> findById(@PathVariable long id) {

        Optional<Player> optionalPlayer = this.playerRepository.findById(id);

        if(optionalPlayer.isPresent()) {
            // dan pas
            return new ResponseEntity<>(optionalPlayer.get(), HttpStatus.OK);

//            return ResponseEntity.ok(optionalPlayer.get());
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            throw new ResourceNotFoundException();
//            return ResponseEntity.notFound().build();
        }

    }

    @PostConstruct // again this is for test purpose only and to get started ...
    public void addSomeData() {
        for(int i = 0 ;i<5;i++) {
            Player player = new Player();
            player.setName("Steven "+ Double.valueOf(Math.random() * 100).intValue());
            player.setPosition("FirstHalve");
            player.setShirtNumber(i);

            this.playerRepository.save(player);
        }
    }
}