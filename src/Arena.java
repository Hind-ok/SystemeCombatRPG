public class Arena {

    private Creature[] creatures;
    private int index;

    Arena(int capacite){
        creatures = new Creature[capacite];
        index = 0;
    }

    // ajoute une créature si l’arène n’est pas pleine.
    public boolean ajouterCreature(Creature c) {
        if (index >= creatures.length) {
            System.out.println("L'arène est pleine! (" + index + "/" + creatures.length + ")");
            return false;
        }

        creatures[index] = c;
        index++;
        System.out.println(c.getNom() + " a été ajouté à l'arène. (" + index + "/" + creatures.length + ")");
        return true;
    }

    // affiche toutes les créatures enregistrées
    public void afficherCreatures() {
        if (index == 0) {
            System.out.println("L'arène est vide.");
            return;
        }

        System.out.println("\n=== CRÉATURES DANS L'ARÈNE (" + index + "/" + creatures.length + ") ===");
        for (int i = 0; i < index; i++) {
            System.out.print(i + ". ");
            creatures[i].afficherStatut();
        }
        System.out.println("========================================\n");
    }

    //combat tour par tour entre deux créatures.
    public void duel(int a, int b) {
        if (a < 0 || a >= index || b < 0 || b >= index || a == b) {
            System.out.println("Indices invalides.");
            return;
        }

        Creature creatureA = creatures[a];
        Creature creatureB = creatures[b];

        if (!creatureA.estVivant() || !creatureB.estVivant()) {
            System.out.println("Une des créatures n'est pas en état de combattre.");
            return;
        }

        System.out.println("\n=== DEBUT DU Combat ===");
        System.out.println(creatureA.getNom() + " vs " + creatureB.getNom());
        System.out.println("====================\n");

        int tour = 1;
        Creature attaquant = creatureA;
        Creature defenseur = creatureB;

        if (Math.random() < 0.5) {
            attaquant = creatureB;
            defenseur = creatureA;
        }

        while (creatureA.estVivant() && creatureB.estVivant()) {
            System.out.println("\n--- Tour " + tour + " ---");

            System.out.println("> " + attaquant.getNom() + " attaque:");

            if (attaquant instanceof Mage || attaquant instanceof Dragon) {

                Magique magique = (Magique) attaquant;
                if (Math.random() < 0.5 && ((Creature)attaquant).getMana() > 0) {
                    magique.attaqueSpeciale(defenseur);
                } else {
                    attaquant.attaquer(defenseur);
                }
            } else if (attaquant instanceof Guerrier || attaquant instanceof Archer) {

                Physique physique = (Physique) attaquant;
                if (Math.random() < 0.5 && ((Creature)attaquant).getMana() > 0) {
                    physique.coupPuissant(defenseur);
                } else {
                    attaquant.attaquer(defenseur);
                }
            }

            attaquant.regenererMana(10);
            defenseur.regenererMana(10);

            creatureA.afficherStatut();
            creatureB.afficherStatut();

            Creature temp = attaquant;
            attaquant = defenseur;
            defenseur = temp;

            tour++;

           // try {
           //     Thread.sleep(1000);
           // } catch (InterruptedException e) {
           //     e.printStackTrace();
           // }
        }

        System.out.println("\n=== FIN DU Combat ===");
        if (creatureA.estVivant()) {
            System.out.println(creatureA.getNom() + " remporte le duel.");
        } else {
            System.out.println(creatureB.getNom() + " remporte le duel.");
        }
        System.out.println("===================\n");
    }

    public void resetCreature(int a) {
        if (a >= 0 && a < index) {
            //creatures[a].rest();
            creatures[a].reinitialiserCompletement();
            System.out.println(creatures[a].getNom() + " a été réinitialisé.");
        } else {
            System.out.println("Indice invalide");
        }
    }

    public int getNombreCreatures() {
        return index;
    }

    public int getCapacite() {
        return creatures.length;
    }

    public Creature getCreature(int i) {
        if (i >= 0 && i < index) {
            return creatures[i];
        }
        return null;
    }


}

