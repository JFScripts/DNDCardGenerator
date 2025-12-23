import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean rodando = true;
        Scanner input = new Scanner(System.in);;
        
        while (rodando) {
            System.out.println("[01] - Criar Carta");
            System.out.println("[02] - Gerar HTML");
            System.out.println("[03] - Sair");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    while (true) {
                        System.out.println("Pressione ENTER para criar uma nova carta ou digite qualquer coisa para VOLTAR ao menu:");
                        String controle = input.nextLine();

                        if (controle.trim().isEmpty()) {
                            
                            String linhaParaSalvar = criarCarta(input);

                            try {
                                FileWriter abrirArquivo = new FileWriter("magias.txt", true);
                                PrintWriter escreverArquivo = new PrintWriter(abrirArquivo);
                                escreverArquivo.println(linhaParaSalvar);
                                escreverArquivo.close(); 
                                System.out.println(">> Sucesso! Carta salva em 'magias.txt'");

                            } catch (IOException e) {
                                System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
                            }

                        } else {
                            break;
                        }
                    }
                    break;
                    case 2:
                        System.out.println(">>> Lendo arquivo e gerando HTML...");
                        try {
                            java.io.File arquivoTxt = new java.io.File("magias.txt");
                            if (!arquivoTxt.exists()) {
                                System.out.println("ERRO: O arquivo 'magias.txt' não existe. Crie cartas primeiro!");
                                break;
                            }
    
                            StringBuilder conteudoHtml = new StringBuilder();
                            conteudoHtml.append(GeradorHtml.pegarCabecalho());
    
                            Scanner leitorTxt = new Scanner(arquivoTxt);
    
                            while (leitorTxt.hasNextLine()) {
                                String linha = leitorTxt.nextLine();
                                

                                if (linha.trim().isEmpty()) continue;

                                String[] dados = linha.split("\\|");
    
                                if (dados.length < 5) {
                                    System.out.println("Aviso: Linha ignorada (formato inválido): " + linha);
                                    continue;
                                }
    
                                String cartaPronta = GeradorHtml.pegarMolde();
                                cartaPronta = cartaPronta.replace("{{NOME}}", dados[0].trim());
                                cartaPronta = cartaPronta.replace("{{SUBTITULO}}", dados[1].trim());
                                cartaPronta = cartaPronta.replace("{{DADOS}}", dados[2].trim());
                                cartaPronta = cartaPronta.replace("{{DESCRICAO}}", dados[3].trim());
                                cartaPronta = cartaPronta.replace("{{NIVEIS}}", dados[4].trim());
    
                                conteudoHtml.append(cartaPronta);
                            }
                            leitorTxt.close();
                            conteudoHtml.append(GeradorHtml.pegarRodape());
    
                            FileWriter arquivoHtml = new FileWriter("cartas.html");
                            PrintWriter escritorHtml = new PrintWriter(arquivoHtml);
                            escritorHtml.print(conteudoHtml.toString());
                            escritorHtml.close();
    
                            System.out.println(">>> SUCESSO! O arquivo 'cartas.html' foi gerado na pasta do projeto.");
                            System.out.println(">>> Abra ele no seu navegador e mande imprimir (CTRL+P).");
                            try {
                            File arquivoParaAbrir = new File("cartas.html");
                            
                            if (java.awt.Desktop.isDesktopSupported()) {
                                java.awt.Desktop.getDesktop().open(arquivoParaAbrir);
                                System.out.println(">>> Abrindo navegador...");
                            }
                        } catch (Exception e) {
                            System.out.println("Não consegui abrir sozinho. Vá na pasta e abra manualmente.");
                        }
                    } catch (IOException e) {
                        System.out.println("Não conseguiu gerar o HTML: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    rodando = false;
                    break;
            }
        }
        input.close();
    }
    
    private static String criarCarta(Scanner input){
        System.out.println("===NOVA CARTA===");
        System.out.println("Caso um campo não se aplique, apenas aperte ENTER");
        System.out.println(">>>Digite o Nome da Carta");
        String nome = input.nextLine();
        System.out.println(">>>Digite o subtitulo da carta");
        String subtitulo = input.nextLine();
        if(subtitulo.trim().isEmpty()){
            subtitulo = "-";
        }
        System.out.println(">>>Digite os dados Técnicos");
        String dadosTecnicos = input.nextLine();
        if(dadosTecnicos.trim().isEmpty()){
            dadosTecnicos = "-";
        }
        System.out.println(">>>Digite a descrição (não utilize '|'' )");
        String descricao = input.nextLine();
        if(descricao.trim().isEmpty()){
            descricao = "-";
        }
        System.out.println(">>>Digite o que acontece em niveis superiores");
        String niveisSuperiores = input.nextLine();
        if(niveisSuperiores.trim().isEmpty()){
            niveisSuperiores = "-";
        }

        return nome + " | " + subtitulo + " | " + dadosTecnicos + " | " + descricao + " | " + niveisSuperiores;  

    }
}
