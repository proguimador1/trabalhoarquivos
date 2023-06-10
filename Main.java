import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\r?\n");
        LimpadorConsole limpadorTela = new LimpadorConsole();


        while(true) {

            //Limpar tela
            try {
                limpadorTela.limparTela();
            } catch (IOException e) {
                System.out.println(e);
            } catch (InterruptedException e2) {
                System.out.println(e2);
            }

            System.out.println("------------Menu Principal------------");

            
            System.out.println("\n" + "Digite a opcao desejada:" + "\n");
            System.out.println("1 - Adicionar respostas de alunos de uma disciplina");
            System.out.println("2 - Gerar arquivos contendo gabarito dos alunos de uma disciplina");
            String opcao;
            do {
                System.out.print("Opc: ");
                opcao = teclado.next();
            } while (!(opcao.equals("1") || opcao.equals("2")));
    
            if (opcao.equals("1")) {
                File diretorio = new File("./");
                File subdir1 = new File(diretorio, "RespostasDisciplinas");
                subdir1.mkdir();
                System.out.print("\n" + "Digite o nome da disciplina a adicionar: ");
                String nomeDisciplina = teclado.next();
                File arquivo = new File(subdir1, nomeDisciplina + ".txt");

                try {
                    FileWriter fw = new FileWriter(arquivo, true);
                    BufferedWriter bw = new BufferedWriter(fw);

                    while (!opcao.equals("2")){


                        //Submenu 1
                        System.out.println("\n" + "Digite a opcao desejada:" + "\n");
                        System.out.println("1 - Adicionar as respostas de um aluno");
                        System.out.println("2 - Voltar ao menu");
        
                        do {
                            System.out.print("Opc: ");
                            opcao = teclado.next();
                        } while (!(opcao.equals("1") || opcao.equals("2")));
        
                        if(opcao.equals("1")){
                            System.out.print("\n" + "Digite as 10 respostas (ex: VFVFVFVFVF): ");
                            String respostas = teclado.next();
                            System.out.print("\n" + "Digite agora o nome do aluno: ");
                            String nomeAluno = teclado.next();

                            // testetsat7dssdiyasidsasipahdhipashpksadphksadphksdkphpsdsjpd
                            System.out.println("O NOME DO ALUNO FOI : " + nomeAluno);

                            bw.write(respostas + "\t" + nomeAluno);
                            bw.newLine();
                            bw.flush();
                        } else {
                            fw.close();
                            bw.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }

            }  
            else if (opcao.equals("2")) {
                //
            }

            
        }
    }
}