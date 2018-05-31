package eu.qnh.baseball.service;

import eu.qnh.baseball.InvalidNameException;
import eu.qnh.baseball.model.Player;
import eu.qnh.baseball.persistence.PlayerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceTest {

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private PlayerRepository playerRepository;


    @Test
    public void testFindAll() {

        //Mock the PlayerRepository;
        {
            List<Player> players = Arrays.asList(new Player(), new Player(), new Player());
            Mockito.when(this.playerRepository.findAll()).thenReturn(players);

        }


        {
            Iterable<Player> players = this.playerService.findAll();
            int counter = 0;
            for (Player element : players) {
                counter++;
            }

            Assert.assertEquals(3, counter);
        }

        Mockito.verify(this.playerRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindByNameWithInvalidName() {

        //Mock the repo
        {
            Mockito.when(this.playerRepository.findByName(null)).thenThrow(new InvalidNameException());
        }

        // perform the test

        {
            try {
                Optional<List<Player>> name = this.playerService.findByName(null);
                Assert.fail();
            } catch (InvalidNameException ine) {
                 // OK
            }
        }
    }

}
