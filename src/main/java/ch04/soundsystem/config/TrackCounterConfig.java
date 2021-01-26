package ch04.soundsystem.config;

import ch04.soundsystem.BlankDisc;
import ch04.soundsystem.CompactDisc;
import ch04.soundsystem.TrackCounter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        BlankDisc cd = new BlankDisc();
        cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
        cd.setArtist("The Beatles");
        List<String> tracks = new ArrayList<>();
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
        tracks.add("With a Little Help from My Friends");
        tracks.add("Lucy in the Sky with Diamonds");
        tracks.add("Getting Better");
        tracks.add("Fixing a Hole");
        tracks.add("She's Leaving Home");
        tracks.add("Being for the Benefit of Mr. Kite!");
        tracks.add("Within You Without You");
        tracks.add("When I'm Sixty-Four");
        tracks.add("Lovely Rita");
        tracks.add("Good Morning Good Morning");
        tracks.add("Sgt. Pepper's Lonely Hearts Club Band (Reprise)");
        tracks.add("A Day in the Life");

        cd.setTracks(tracks);
        return cd;
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
