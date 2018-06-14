package fr.inria.stamp.items;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 14/06/18
 */
public class Sword {

    private int damage;
    private int size;
    private int weight;

    private Player player;

    public Sword(int damage, int size, int weight, Player player) {
        this.damage = damage;
        this.size = size;
        this.weight = weight;
        this.player = player;
    }

    public void sharp() {
        if (this.player.getTypeClass() == -1) {
            this.damage++;
        } else {
            this.damage++;
        }
    }

    public void enlarge() {
        if (this.player.getTypeClass() == -1) {
            this.size++;
        } else {
            this.size++;
        }

    }

    public void moreSteel() {
        if (this.player.getTypeClass() == -1) {
            this.weight++;
        } else {
            this.weight++;
        }
    }

    public void ultimate() {
        this.damage += 1000;
        this.weight = 10;
        this.size = 500;
    }

    public int getDamage() {
        return damage;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
