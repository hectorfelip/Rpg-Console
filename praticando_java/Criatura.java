public abstract class Criatura extends Personagem {

    public Criatura(
        String nome,
        String classe,
        int ataque,
        int vida,
        String arma,
        String armadura
    ) {
        super(nome, classe, ataque, vida, arma, armadura);
    }
}
