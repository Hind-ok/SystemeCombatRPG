public class Mage extends Creature implements Magique {

    private static final int HP_MAX = 90;
    private static final int MANA_MAX = 120;
    private static final int DEGATS_BASE = 15;
    private static final int COUT_ATTAQUE_SPECIALE = 35;

    public Mage(String nom) {
        super(nom, HP_MAX, MANA_MAX, DEGATS_BASE);
    }

    public void attaquer(Creature cible) {
        System.out.println(nom + " lance un sort mineur ");
        cible.recevoirDegats(degatsBase);
    }

    public void attaqueSpeciale(Creature cible) {
        if (mana >= COUT_ATTAQUE_SPECIALE) {
            System.out.println(nom + " lance un puissant sort de feu");
            mana -= COUT_ATTAQUE_SPECIALE;
            int degats = degatsBase * 3;
            cible.recevoirDegats(degats);
            System.out.println("Dégats infligés: " + degats);
        } else {
            System.out.println("Mana insuffisant pour l'attaque spéciale.");
        }
    }

}
