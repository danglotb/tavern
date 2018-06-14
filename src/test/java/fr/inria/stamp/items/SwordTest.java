package fr.inria.stamp.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 14/06/18
 */
public class SwordTest {

    @Test
    public void test() throws Exception {
        final Player player = new Player("player", -1);
        final Sword sword = new Sword(10, 5, 7, player);
        player.setSword(sword);
        player.boostItem(1);
    }

}
