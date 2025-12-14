import java.util.Random;

public class Archer extends Creature implements Physique{

    private static final int HP_MAX = 110;
    private static final int MANA_MAX = 50;
    private static final int DEGATS_BASE = 18;
    private static final int COUT_COUP_PUISSANT = 15;
    private static final double CHANCE_CRITIQUE = 0.3;
    private Random random;

    public Archer(String nom) {
        super(nom, HP_MAX, MANA_MAX, DEGATS_BASE);
        this.random = new Random();
    }

    public void attaquer(Creature cible) {
        System.out.println(nom + " tire une flèche ");
        cible.recevoirDegats(degatsBase);
    }

    public void coupPuissant(Creature cible) {
        if (mana >= COUT_COUP_PUISSANT) {
            System.out.println(nom + " tire une flèche puissante ");
            mana -= COUT_COUP_PUISSANT;

            int degats = degatsBase * 2;

            if (random.nextDouble() < CHANCE_CRITIQUE) {
                System.out.println("COUP CRITIQUE ");
                degats *= 3;
            }

            cible.recevoirDegats(degats);
            System.out.println("Dégats infligés: " + degats);
        } else {
            System.out.println("Mana insuffisant, Attaque normale.");
            attaquer(cible);
        }
    }

}
