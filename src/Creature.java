public abstract class Creature {

    protected String nom;
    protected int hp;
    protected int hpMax;
    protected int mana;
    protected int manaMax;
    protected int degatsBase;

    public Creature(String nom, int hpMax, int manaMax, int degatsBase){
        this.nom = nom;
        this.hp = hpMax;
        this.hpMax = hpMax;
        this.mana = manaMax;
        this.manaMax = manaMax;
        this.degatsBase = degatsBase;
    }

    boolean estVivant(){
        return hp > 0;
    }

    public abstract void attaquer(Creature cible);

    public void recevoirDegats(int deg){
        this.hp -= deg;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void regenererMana(int valeur){
        this.mana += valeur;
        if (this.mana>manaMax)
            this.mana = manaMax;
    }

    public  void afficherStatut(){
        System.out.println(nom + "points de vie hp :"+ this.hp + "mana :"+ this.mana);
    }

    public void rest(){
        if (estVivant()) {
            this.hp = hpMax;
            this.mana = manaMax;
        }
    }
}
