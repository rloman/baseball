package eu.qnh.baseball.persistence;

import eu.qnh.baseball.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {


    List<Player> findByName(String name);

    List<Player> findByNameAndPosition(String name, String pos);

    List<Player> findByNameAndShirtNumberOrderByNameAsc(String name, int shirtNumber);

}
