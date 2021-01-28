package ch05.spittr.data;

import ch05.spittr.Spitter;
import ch05.spittr.Spittle;

import java.util.List;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

}
