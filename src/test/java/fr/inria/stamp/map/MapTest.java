package fr.inria.stamp.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 14/06/18
 */
public class MapTest {

    @Test
    public void testInit() throws Exception {
        final Map map = new Map(20, 20);
        assertEquals(20, map.getWidth());
        assertEquals(20, map.getHeight());
    }

    @Test
    public void testCanMoveTo() throws Exception {
        final Map map = new Map(20, 20);
        assertTrue(map.canMoveTo(0, 0, 1, 1));
        assertFalse(map.canMoveTo(0, 0, -1, -1));
        assertTrue(map.canMoveTo(1, 1, -1, -1));
        assertFalse(map.canMoveTo(19, 19, 1, 1));
    }

    @Test
    public void testIsInMap() throws Exception {
        final Map map = new Map(20, 20);
        assertTrue(map.isInMap(0, 0));
        assertTrue(map.isInMap(19, 19));
        assertTrue(map.isInMap(15, 15));
        assertFalse(map.isInMap(20, 20));
        assertFalse(map.isInMap(-1, -1));
    }
}
