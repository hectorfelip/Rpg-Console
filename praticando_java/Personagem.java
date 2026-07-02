import java.util.*;

public abstract class Personagem {

    transient projectRepo repo = new projectRepo();

    protected String nome;
    protected String classe;
    protected int ataque;
    protected int vida;
    protected String arma;
    protected String armadura;

    public Personagem() {}

    public Personagem(String nome, String classe) {
        this.nome = nome;
        this.classe = classe;
    }

    public Personagem(
        String nome,
        String classe,
        int ataque,
        int vida,
        String arma,
        String armadura
    ) {
        this.nome = nome;
        this.classe = classe;
        this.ataque = ataque;
        this.vida = vida;
        this.arma = arma;
        this.armadura = armadura;
    }

    public abstract boolean haveArmour(String nome);

    public abstract void list();

    public abstract boolean exist(String nome);

    public abstract void verificar(Scanner sc);

    public abstract void dellChar(Scanner sc);
}
