import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private Arena arena;

    public MainMenu() {
        scanner = new Scanner(System.in);
        initialiserArena();
    }

    private void initialiserArena() {
        System.out.println("=== SYSTEME DE COMBAT RPG ===\n");
        System.out.print("Entrez la capacité maximale de l'arène: ");
        int capacite = scanner.nextInt();
        scanner.nextLine();

        arena = new Arena(capacite);
        System.out.println("Arène créée avec une capacité de " + capacite + " créatures.\n");
    }

    public void afficherMenu() {
        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ajouter une créature");
            System.out.println("2. Afficher toutes les créatures");
            System.out.println("3. Lancer un duel entre deux créatures");
            System.out.println("4. Réinitialiser une créature");
            System.out.println("5. Quitter le programme");
            System.out.print("\nChoisissez une option: ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        ajouterCreature();
                        break;
                    case 2:
                        arena.afficherCreatures();
                        break;
                    case 3:
                        lancerDuel();
                        break;
                    case 4:
                        resetCreature();
                        break;
                    case 5:
                        quitter = true;
                        System.out.println("Merci d'avoir utilisé le système de combat RPG!");
                        break;
                    default:
                        System.out.println("Option invalide! Veuillez choisir 1-5.");
                }
            } catch (Exception e) {
                System.out.println("Erreur de saisie! Veuillez entrer un nombre.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private void ajouterCreature() {
        if (arena.getNombreCreatures() >= arena.getCapacite()) {
            System.out.println("L'arène est pleine! (" + arena.getNombreCreatures() +
                    "/" + arena.getCapacite() + ")");
            return;
        }

        System.out.println("\n=== AJOUTER UNE CRÉATURE ===");
        System.out.println("Types disponibles:");
        System.out.println("1. Guerrier");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.println("4. Dragon");
        System.out.print("\nChoisissez le type: ");

        try {
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Entrez le nom de la créature: ");
            String nom = scanner.nextLine();

            Creature nouvelleCreature = null;

            switch (type) {
                case 1:
                    nouvelleCreature = new Guerrier(nom);
                    break;
                case 2:
                    nouvelleCreature = new Mage(nom);
                    break;
                case 3:
                    nouvelleCreature = new Archer(nom);
                    break;
                case 4:
                    nouvelleCreature = new Dragon(nom);
                    break;
                default:
                    System.out.println("Type invalide.");
                    return;
            }

            if (nouvelleCreature != null) {
                arena.ajouterCreature(nouvelleCreature);
            }
        } catch (Exception e) {
            System.out.println("Erreur de saisie!");
            scanner.nextLine();
        }
    }

    private void lancerDuel() {
        int nombre = arena.getNombreCreatures();
        if (nombre < 2) {
            System.out.println("Il faut au moins 2 créatures pour un duel.");
            System.out.println("Créatures disponibles: " + nombre);
            return;
        }

        arena.afficherCreatures();

        try {
            System.out.print("Entrez l'indice de la première créature: ");
            int a = scanner.nextInt();

            System.out.print("Entrez l'indice de la deuxième créature: ");
            int b = scanner.nextInt();
            scanner.nextLine();

            arena.duel(a, b);
        } catch (Exception e) {
            System.out.println("Erreur de saisie!");
            scanner.nextLine();
        }
    }

    private void resetCreature() {
        if (arena.getNombreCreatures() == 0) {
            System.out.println("L'arène est vide!");
            return;
        }

        arena.afficherCreatures();

        try {
            System.out.print("Entrez l'indice de la créature à réinitialiser: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            arena.resetCreature(index);
        } catch (Exception e) {
            System.out.println("Erreur de saisie!");
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.afficherMenu();
    }
}