package eu.qnh.baseball.rest;

import eu.qnh.baseball.model.Player;
import eu.qnh.baseball.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private PlayerService playerService;

    @Value("${application.controllerName}")
    private String controllerName;



    @GetMapping
    public Iterable<Player> list() {

        return this.playerService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Player> findById(@PathVariable long id) {

        Optional<Player> optionalPlayer = this.playerService.findById(id);

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

    @PostMapping
    public ResponseEntity<Player> create(@RequestBody Player newPlayer) {
        return ResponseEntity.ok(this.playerService.save(newPlayer));
    }



    @PostConstruct // again this is for test purpose only and to get started ...
    public void addSomeData() {
        for(int i = 0 ;i<5;i++) {
            Player player = new Player();
            player.setName("Steven "+ Double.valueOf(Math.random() * 100).intValue());
            player.setPosition("FirstHalve");
            player.setShirtNumber(i);

            this.playerService.save(player);

            LOGGER.info("The player is saved [{}] with id [{}]", player, player.getId());
        }
    }
}