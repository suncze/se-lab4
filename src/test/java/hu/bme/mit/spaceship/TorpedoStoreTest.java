
package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 0.0);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());
        assertEquals(true, store.isEmpty());
    }

    @Test
    void fire_Failure() {
        TorpedoStore store = new TorpedoStore(5, 1.0);

        boolean result = store.fire(1);

        assertEquals(false, result);
        assertEquals(5, store.getTorpedoCount());
    }

    @Test
    void fire_MultipleTorpedos() {
        TorpedoStore store = new TorpedoStore(10, 0.0);

        boolean result = store.fire(3);

        assertEquals(true, result);
        assertEquals(7, store.getTorpedoCount());
    }
    
    @Test
    void fire_SequentialFiring() {
        TorpedoStore store = new TorpedoStore(5, 0.0);

        boolean first = store.fire(2);
        boolean second = store.fire(3);

        assertEquals(true, first);
        assertEquals(true, second);
        assertEquals(0, store.getTorpedoCount());
        assertEquals(true, store.isEmpty());
    }
}
