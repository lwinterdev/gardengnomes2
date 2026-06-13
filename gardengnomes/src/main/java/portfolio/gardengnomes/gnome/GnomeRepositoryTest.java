package portfolio.gardengnomes.gnome;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GnomeRepositoryTest {

    @Autowired
    private GnomeRepository repository;

    @Test
    void shouldSaveAndRetrieveGnome() {
        // arrange
        Gnome gnome = new Gnome();
        gnome.setUsername("waldgeist");
        gnome.setDisplayName("Forest Spirit");

        // act
        Gnome saved = repository.save(gnome);
        List<Gnome> all = repository.findAll();

        // assert
        assertNotNull(saved.getId());
        assertTrue(all.size() > 0);
        assertEquals("waldgeist", all.get(0).getUsername());
    }
}