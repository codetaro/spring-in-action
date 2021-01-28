package ch05.spittr.data;

import ch05.spittr.Spittle;

import java.util.List;

public interface SpittleRepository {

    List<Spittle> findRecentSpittles();

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);

}
