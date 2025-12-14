public class Guerrier extends Creature implements Physique{

    private static final int HP_MAX = 140;
    private static final int MANA_MAX = 40;
    private static final int DEGATS_BASE = 20;
    private static final int COUT_COUP_PUISSANT = 20;

    public Guerrier(String nom) {
        super(nom, HP_MAX, MANA_MAX, DEGATS_BASE);
    }

    public void attaquer(Creature cible) {
        System.out.println(nom+ " Attaque avec son épée ");
        cible.recevoirDegats(degatsBase);
    }

    public void coupPuissant(Creature cible) {
        if (mana >= COUT_COUP_PUISSANT) {
            System.out.println(nom+ " effectue un coup puissant ");
            mana -= COUT_COUP_PUISSANT;
            int degats = degatsBase * 2;
            cible.recevoirDegats(degats);
            System.out.println("Dégats infligés: " + degats);
        } else {
            System.out.println("Mana insuffisant, Attaque normale.");
            attaquer(cible);
        }
    }
}
