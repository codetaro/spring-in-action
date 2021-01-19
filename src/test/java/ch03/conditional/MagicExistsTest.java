package ch03.conditional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConfig.class)
public class MagicExistsTest {

    @Autowired
    private ApplicationContext context;

    @BeforeClass
    public static void onlyOnce() {
        System.setProperty("magic", "Abracadabra");
    }

    @Test
    public void shouldNotBeNull() {
        assertTrue(context.containsBean("magicBean"));
    }
}