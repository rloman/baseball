package eu.qnh.baseball.service;

import eu.qnh.baseball.model.Player;
import eu.qnh.baseball.persistence.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Iterable<Player> findAll() {

        return this.playerRepository.findAll();
    }

    public Optional<Player> findById(long id) {
        return this.playerRepository.findById(id);
    }

    public Optional<List<Player>> findByName(String name) {

        Optional<List<Player>> resultFromService = this.playerRepository.findByName(name);
        return resultFromService;
    }

    @Transactional
    public Player save(Player player) {
        return this.playerRepository.save(player);
    }
}
