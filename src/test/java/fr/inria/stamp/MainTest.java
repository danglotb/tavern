package fr.inria.stamp;

import fr.inria.stamp.tavern.Item;
import fr.inria.stamp.tavern.Player;
import fr.inria.stamp.tavern.Seller;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 05/09/17
 */
public class MainTest {

	@Test
	public void test() throws Exception {
		Seller seller = new Seller(100, Arrays.asList(new Item("Potion", 5),
				new Item("Torch", 7),
				new Item("Beer", 2),
				new Item("Cheese", 3),
				new Item("Sword", 25)
		));
		Player player = new Player(1000);

		assertEquals("Player{gold=1000, items=[]}", player.toString());
		assertEquals("Seller{gold=100, items=[Potion, Torch, Beer, Cheese, Sword]}", seller.toString());

		player.buyItem("Potion", seller);

		assertEquals("Player{gold=995, items=[Potion]}", player.toString());
		assertEquals("Seller{gold=105, items=[Potion, Torch, Beer, Cheese, Sword]}", seller.toString());
	}

}
