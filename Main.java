import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cabeçalho
        System.out.println("******************************");
        System.out.println("* Faculdade UNIFAN             *");
        System.out.println("* Nome do Aluno: ADRIEN DO SANTOS    *");
        System.out.println("* Nome do Professor: Prof. BRENNO *");
        System.out.println("******************************");
        System.out.println("Bem-vindo ao Quiz de Carros!");
        System.out.println("Você responderá 2 perguntas de múltipla escolha.");
        System.out.println("Boa sorte!\n");

        // Array com as 2 questões
        Questao[] questoes = new Questao[2];
        preencherQuestoes(questoes); // Preencher com as questões do tema "Carros"

        int acertos = 0;
        int erros = 0;

        // Loop para exibir e processar as 2 perguntas
        for (int i = 0; i < questoes.length; i++) {
            System.out.println("Pergunta " + (i + 1) + ":");
            questoes[i].escrevaQuestao();
            String resposta = questoes[i].leiaResposta();
            if (questoes[i].isCorreta(resposta)) {
                acertos++;
            } else {
                erros++;
            }
        }

        // Resultado
        double percentualAcertos = ((double) acertos / questoes.length) * 100;
        System.out.println("Você acertou " + acertos + " questões.");
        System.out.println("Você errou " + erros + " questões.");
        System.out.printf("Sua porcentagem de acertos foi: %.2f%%\n", percentualAcertos);
    }

    // Método para preencher as questões
    private static void preencherQuestoes(Questao[] questoes) {
        questoes[0] = new Questao(
                "Qual é o carro mais vendido no mundo?",
                "A) Toyota Corolla",
                "B) Ford F-Series",
                "C) Honda Civic",
                "D) Volkswagen Golf",
                "E) Chevrolet Silverado",
                "A"
        );

        questoes[1] = new Questao(
                "Qual carro foi considerado o mais rápido em 2020?",
                "A) Bugatti Veyron",
                "B) Koenigsegg Jesko",
                "C) Hennessey Venom GT",
                "D) SSC Tuatara",
                "E) McLaren Speedtail",
                "D"
        );
    }
}

import java.util.Scanner;

public class Questao {
    String pergunta;
    String opcaoA;
    String opcaoB;
    String opcaoC;
    String opcaoD;
    String opcaoE;
    String correta;

    public Questao(String pergunta, String opcaoA, String opcaoB, String opcaoC, String opcaoD, String opcaoE, String correta) {
        this.pergunta = pergunta;
        this.opcaoA = opcaoA;
        this.opcaoB = opcaoB;
        this.opcaoC = opcaoC;
        this.opcaoD = opcaoD;
        this.opcaoE = opcaoE;
        this.correta = correta;
    }

    public boolean isCorreta(String resposta) {
        if (resposta.equalsIgnoreCase(this.correta)) {
            System.out.println("Parabéns, resposta Correta! - Letra: " + this.correta + "\n");
            return true;
        } else {
            System.out.println("Resposta Errada!");
            System.out.println("A opção correta é a letra: " + this.correta + "\n");
            return false;
        }
    }

    public String leiaResposta() {
        Scanner ler = new Scanner(System.in);
        String resp;
        do {
            System.out.print("Digite a resposta: ");
            resp = ler.next();
        } while (!respostaValida(resp));
        return resp;
    }

    private boolean respostaValida(String resp) {
        if (resp.equalsIgnoreCase("A") || resp.equalsIgnoreCase("B") || resp.equalsIgnoreCase("C") ||
                resp.equalsIgnoreCase("D") || resp.equalsIgnoreCase("E")) {
            return true;
        }
        System.out.println("Resposta inválida! Digite opção A, B, C, D ou E.\n");
        return false;
    }

    public void escrevaQuestao() {
        System.out.println(this.pergunta);
        System.out.println();
        System.out.println(this.opcaoA);
        System.out.println(this.opcaoB);
        System.out.println(this.opcaoC);
        System.out.println(this.opcaoD);
        System.out.println(this.opcaoE);
        System.out.println();
    }
}
