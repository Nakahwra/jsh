package br.unifil.dc.sisop;

import java.io.File;
import java.util.Optional;
import java.util.Scanner;
/**
 * Write a description of class Jsh here.
 *
 * @author Ricardo Inacio Alvares e Silva
 * @version 180823
 */
public final class Jsh {
    // Recupera informações para se exibir no prompt
    public static String user_name = System.getProperty("user.name");
    public static String dir_name = System.getProperty("user.dir");
    public static String uid;
    
    /**
    * Funcao principal do Jsh.
    */
    public static void promptTerminal() {

        while (true) {
    		exibirPrompt();
    		ComandoPrompt comandoEntrado = lerComando();
    		executarComando(comandoEntrado);
    	}
    }

    /**
    * Escreve o prompt na saida padrao para o usuário reconhecê-lo e saber que o
    * terminal está pronto para receber o próximo comando como entrada.
    */
    public static void exibirPrompt() {
        // recuperando UID do usuário
        uid = Library.getUID();

        // construindo e printando prompt
        String prompt = "\n" + user_name + "#" + uid + ":" + dir_name + "\n->";
        System.out.print(prompt);
    }

    /**
    * Preenche as strings comando e parametros com a entrada do usuario do terminal.
    * A primeira palavra digitada eh sempre o nome do comando desejado. Quaisquer
    * outras palavras subsequentes sao parametros para o comando. A palavras sao
    * separadas pelo caractere de espaco ' '. A leitura de um comando eh feita ate
    * que o usuario pressione a tecla <ENTER>, ou seja, ate que seja lido o caractere
    * EOL (End Of Line).
    *
    * @return 
    */
    public static ComandoPrompt lerComando() {
        // Instanciando scanner e recebendo o comando inserido pelo usuário
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        // Instancia classe de comando
        ComandoPrompt commandPrompt = new ComandoPrompt(input);
        return commandPrompt;

    }

    /**
    * Recebe o comando lido e os parametros, verifica se eh um comando interno e,
    * se for, o executa.
    * 
    * Se nao for, verifica se é o nome de um programa terceiro localizado no atual 
    * diretorio de trabalho. Se for, cria um novo processo e o executa. Enquanto
    * esse processo executa, o processo do uniterm deve permanecer em espera.
    *
    * Se nao for nenhuma das situacoes anteriores, exibe uma mensagem de comando ou
    * programa desconhecido.
    */
    public static void executarComando(ComandoPrompt comando) {
      switch (comando.getNome()) {

        case "encerrar":
            System.out.println("\nEncerrando terminal...");
            System.exit(0);
            
        case "relogio":
            ComandosInternos.exibirRelogio();
            break;

        case "la":
          ComandosInternos.escreverListaArquivos(Optional.of(dir_name));
          break;

        case "cd":
          String newDirName = comando.getArgumentos().get(0);
          ComandosInternos.criarNovoDiretorio(newDirName);
          break;

        case "ad":
          String dirToRemove = comando.getArgumentos().get(0);
          ComandosInternos.apagarDiretorio(dirToRemove);
          break;

        case "mdt":
          String moveToDir = comando.getArgumentos().get(0);
          ComandosInternos.mudarDiretorioTrabalho(moveToDir);
          break;
        
        default:
          executarPrograma(comando);
          break;
        }
    }

    public static int executarPrograma(ComandoPrompt comando) {
      int exitCode;
        
      try {
          
          String command = comando.getNome();

          // verifica se existe e recupera o programa no diretório
          File program = Library.getProgram(command);

          // Se nenhum programa for retornado, lança exceção
          if(program == null) throw new Exception("Programa não existe.");
          // Valida se o programa tem permissão de execução, se não, lança erro.
          if(!program.canExecute()) throw new Exception("Programa não tem permissão para executar.");

          // Instanciando criador de processos
          ProcessBuilder processBuilder = new ProcessBuilder(program.getAbsolutePath());
          // Criando processo
          Process process = processBuilder.start();
          
          // Esperando programa executar e recuperando exit code.
          exitCode = process.waitFor();

          // Se o exit code for diferente de 0, lança exceção
          if(exitCode != 0) throw new Exception("Programa terminado em erro.");
          
          // Lendo o input stream
          byte[] output = process.getInputStream().readAllBytes();
          // Transformando input stream em String
          String outputStr = new String(output);
          
          // Printando a execução do programa
          System.out.println(outputStr);

          // retornando exit code
          return exitCode;

      } catch (Exception error) {
          Library.printError(error);
          exitCode = 1;
          return exitCode;
      }
      
    }
    
    
    /**
     * Entrada do programa. Provavelmente você não precisará modificar esse método.
     */
    public static void main(String[] args) {

        promptTerminal();
    }
    
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private Jsh() {}
}
