package eu.qnh.baseball.model;

public final class PlayerTestUtils {



    public static Player createPlayerWithId(long id) {

        Player p = new Player();
        p.setId(id);

        return p;

    }


    private PlayerTestUtils() {

    }
}
