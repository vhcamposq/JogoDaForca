package algoritimo;

import java.util.Scanner;

public class JogoDaForca {
    private static final String[] PALAVRAS = {"PROGRAMACAO", "JAVA", "DESENVOLVIMENTO", "COMPUTADOR", "GITHUB"};
    private static final int MAX_TENTATIVAS = 6;

    private String palavraOculta;
    private char[] palavraDescoberta;
    private int tentativasRestantes;

    public JogoDaForca() {
        palavraOculta = escolherPalavraAleatoria().toUpperCase();
        palavraDescoberta = new char[palavraOculta.length()];
        for (int i = 0; i < palavraOculta.length(); i++) {
            palavraDescoberta[i] = '_';
        }
        tentativasRestantes = MAX_TENTATIVAS;
    }

    private String escolherPalavraAleatoria() {
        return PALAVRAS[(int) (Math.random() * PALAVRAS.length)];
    }

    private void exibirStatus() {
        System.out.println("Palavra: " + String.valueOf(palavraDescoberta));
        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }

    private void realizarJogada(char letra) {
        boolean letraCorreta = false;
        for (int i = 0; i < palavraOculta.length(); i++) {
            if (palavraOculta.charAt(i) == letra) {
                palavraDescoberta[i] = letra;
                letraCorreta = true;
            }
        }

        if (!letraCorreta) {
            tentativasRestantes--;
        }
    }

    private boolean jogoContinua() {
        return tentativasRestantes > 0 && String.valueOf(palavraDescoberta).contains("_");
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        exibirStatus();

        while (jogoContinua()) {
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);

            realizarJogada(letra);
            exibirStatus();
        }

        scanner.close();

        if (String.valueOf(palavraDescoberta).contains("_")) {
            System.out.println("Você perdeu! A palavra era: " + palavraOculta);
        } else {
            System.out.println("Parabéns! Você acertou a palavra: " + palavraOculta);
        }
    }

    public static void main(String[] args) {
        JogoDaForca jogo = new JogoDaForca();
        jogo.jogar();
    }
}

