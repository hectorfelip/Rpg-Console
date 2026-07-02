import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogadorUse jogador = new JogadorUse();
        int choice = 0;

        while (true) {
            System.out.println("RPG ON CMD!");

            do {
                try {
                    System.out.println("Desejar entrar\n1 - Sim\n2 - Não");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Menu\n");
                            while (choice != 4) {
                                try {
                                    System.out.println(
                                        "1 - Jogar\n2 - Deletar Personagem\n3 - Listar Personagens!\n4 - Sair"
                                    );

                                    choice = sc.nextInt();

                                    switch (choice) {
                                        case 1:
                                            jogador.verificar(sc);
                                            break;
                                        case 2:
                                            jogador.dellChar(sc);
                                            break;
                                        case 3:
                                            jogador.list();
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println(
                                                "Entre 1 - Jogar! | 2 - Deletar Personagem! |3 - Listar Personagens! | 4 - Sair"
                                            );
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println(
                                        "Erro: Responda somente com as opções disponiveis!"
                                    );
                                } catch (Exception e) {
                                    System.out.println("Erro: Tente novamente");
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Saindo...");
                            return;
                        default:
                            System.out.println("Entre 1 - sim e 2 - não!");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(
                        "Erro: Responda somente com as opções disponiveis!"
                    );
                    sc.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: Tente novamente");
                    // sc.nextLine();
                    break;
                } finally {
                    // sc.close();
                }
            } while (choice != 2);
        }
    }
}
