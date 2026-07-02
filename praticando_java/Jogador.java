import java.util.*;

public abstract class Jogador extends Personagem {

    // CONSTRUTOR UM
    public Jogador() {}

    // CONSTRUTOR DOIS

    public Jogador(
        String nome,
        String classe,
        int ataque,
        int vida,
        String arma,
        String armadura
    ) {
        super(nome, classe, ataque, vida, arma, armadura);
    }

    // METODOS
    public void savePlayer(Scanner sc) {
        String nome, classe;
        projectRepo repo = new projectRepo();

        // LISTA PARA ADICIONAR O JSON QUE FUNCIONARIA COMO BANCO DADOS VIA BIBLIOTECA GSON
        List<JogadorUse> jogadores = repo.load();

        // DEFININDO DADOS QUE SERÃO ADICIONADOS AO JSON(BANCO DE DADOS)

        try {
            sc.nextLine();
            System.out.println("Defina o nome do personagem!");
            nome = sc.nextLine();
            System.out.println("Defina a classe do jogador!");
            classe = sc.nextLine();

            JogadorUse jogador = new JogadorUse(
                nome,
                classe,
                0,
                20,
                "null",
                "null"
            );
            jogadores.add(jogador);

            repo.save(jogadores);

            System.out.println("SUCCESS!");
        } catch (Exception e) {
            System.out.println("ERRO: Tente novamente!");
        }
    }

    @Override
    public boolean exist(String nome) {
        List<JogadorUse> nomesJogadores = repo.load();

        for (Jogador a : nomesJogadores) {
            String nomeDeJogador = a.getNome();
            if (nome.equalsIgnoreCase(nomeDeJogador)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean haveArmour(String nomes) {
        List<JogadorUse> nomesJogadores = repo.load();

        for (Jogador name : nomesJogadores) {
            if (name.getNome().trim().equalsIgnoreCase(nomes)) {
                return !name.getArmadura().trim().isEmpty();
            }
        }

        return false;
    }

    @Override
    public void verificar(Scanner sc) {
        String temp;
        int t = 0;
        try {
            sc.nextLine();
            System.out.println("Qual o seu personagem? (Escreva o nome dele!)");

            temp = sc.nextLine();

            if (!exist(temp)) {
                while (t != 2) {
                    try {
                        System.out.println(
                            "Esse personagem não existe!\nDeseja criar um novo personagem?\n 1 - sim\n 2 - não"
                        );
                        t = sc.nextInt();
                        switch (t) {
                            case 1:
                                savePlayer(sc);
                                return;
                            case 2:
                                return;
                            default:
                                System.out.println(
                                    "Escolha entre 1 - sim e 2 - não!"
                                );
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERRO: Escolha uma das opções!");
                        return;
                    } catch (Exception e) {
                        System.out.println("ERRO: Tente novamente!");
                        return;
                    }
                }
            } else {
                System.out.println("Iniciando...");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Escreva um nome!");
        } catch (Exception e) {
            System.out.println("ERRO: Tente novamente");
        }
    }

    @Override
    public void dellChar(Scanner sc) {
        List<JogadorUse> nomesJogadores = repo.load();

        System.out.println("Qual personagem você quer deletar?");
        sc.nextLine();
        String nometemp = sc.nextLine();
        try {
            if (nometemp.trim().equalsIgnoreCase("all")) {
                System.out.println("Tem certeza?\n(y - sim | n - não)");
                String x = sc.nextLine();
                if (x.equalsIgnoreCase("y")) {
                    nomesJogadores.clear();
                }
            }
            System.out.println("SUCCESS!");
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Escolha uma das opções!");
        } catch (Exception e) {
            System.out.println("ERRO: Tente novamente!");
        }

        nomesJogadores.removeIf(k -> k.getNome().equalsIgnoreCase(nometemp));
        repo.save(nomesJogadores);
    }

    @Override
    public void list() {
        List<JogadorUse> nomesJogadores = repo.load();

        if (nomesJogadores.isEmpty()) {
            System.out.println("Não há personagens cadastrados!");
        } else {
            for (JogadorUse jogadorUse : nomesJogadores) {
                System.out.printf(
                    "Nome:%s\nClasse:%s\nVida:%d\nArma:%s\nArmadura:%s\n",
                    jogadorUse.getNome(),
                    jogadorUse.getClass(),
                    jogadorUse.getVida(),
                    jogadorUse.getArma(),
                    jogadorUse.getArmadura()
                );
            }
        }
    }

    // GETTERS
    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }

    public String getArma() {
        return arma;
    }

    public String getArmadura() {
        return armadura;
    }

    // SETTERS
    public void setNome(String nome) {
        if (nome.trim().isEmpty()) {
            System.out.println("O nome não pode ficar vazio");
        } else if (nome.trim().matches("-?\\d+")) {
            System.out.println("O nome não pode apenas comter números!");
        }
    }

    public void setClasse(String classe) {
        if (classe.trim().isEmpty()) {
            System.out.println("A classe não pode estar vazia!");
        } else if (classe.trim().matches("-?\\d+")) {
            System.out.println("Classe não contém números!");
        }
    }

    public void setAtaque(int ataque) {
        if (ataque == 0) {
        }
    }
}
