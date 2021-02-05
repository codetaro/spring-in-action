package ch06.tiles.spittr.data;

import ch06.tiles.spittr.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

}
