public class Dragon extends Creature implements Magique{

    private static final int HP_MAX = 200;
    private static final int MANA_MAX = 150;
    private static final int DEGATS_BASE = 25;
    private static final int COUT_ATTAQUE_SPECIALE = 50;
    private static final double RESISTANCE = 0.10;

    public Dragon(String nom) {
        super(nom, HP_MAX, MANA_MAX, DEGATS_BASE);
    }

    public void attaquer(Creature cible) {
        System.out.println(nom + " attaque avec ses griffes ");
        cible.recevoirDegats(degatsBase);
    }

    public void attaqueSpeciale(Creature cible) {
        if (mana >= COUT_ATTAQUE_SPECIALE) {
            System.out.println(nom + " crache du feu ");
            mana -= COUT_ATTAQUE_SPECIALE;
            int degats = degatsBase * 4;
            cible.recevoirDegats(degats);
            System.out.println("Dégats infligés: " + degats);
        } else {
            System.out.println("Mana insuffisant pour l'attaque spéciale ");
        }
    }

    public void recevoirDegats(int deg) {
        int degatsFinal = (int)(deg * (1 - RESISTANCE));
        System.out.println(nom + " résiste a " + (int)(RESISTANCE * 100) + "% des dégats (" + deg + " == " + degatsFinal + ")");
        super.recevoirDegats(degatsFinal);
    }

}
