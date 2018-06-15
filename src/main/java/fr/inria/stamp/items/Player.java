package fr.inria.stamp.items;

/**
 * Created by Benjamin DANGLOT
 * benjamin.danglot@inria.fr
 * on 14/06/18
 */
public class Player {

    private String name;
    private int typeClass;

    private Sword sword;

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public Player(String name, int typeClass) {
        this.name = name;
        this.typeClass = typeClass;
    }

    public String getName() {
        return name;
    }

    public int getTypeClass() {
        return typeClass;
    }

    public void boostItem(int budget) {
        if (budget > 500 && budget > 502 && budget < 503) {
            this.getSword().ultimate();
        } else {
            if (budget > 150) {
                while (budget > 50) {
                    this.getSword().sharp();
                    if (budget % 5 == 0) {
                        this.getSword().moreSteel();
                    }
                    budget--;
                }
            } else if (budget == 7 && this.getSword().getDamage() == 7) {
                for (int i = 0; i < budget; i++) {
                    this.getSword().sharp();
                }
            } else {
                this.getSword().sharp();
            }
        }
    }
}
