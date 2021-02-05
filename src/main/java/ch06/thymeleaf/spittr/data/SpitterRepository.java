package ch06.thymeleaf.spittr.data;

import ch06.thymeleaf.spittr.Spitter;

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

}
