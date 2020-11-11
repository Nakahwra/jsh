package br.unifil.dc.sisop;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;

public class Library {
  public static String getUID() {
    String uid = "";

    try {
        // comando para pegar UID
        String command = "id -u " + Jsh.user_name;

        // Executando comando
        Process executeCommand = Runtime.getRuntime().exec(command);
        InputStream result = executeCommand.getInputStream();

        // Armazenando resultado do comando na var. uid
        int c;
        while ((c = result.read()) != -1) {
            uid += (char)c;
        }
        result.close();

        // formatando resultado
        uid = uid.replaceAll("\n", "");

        return uid;

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("ERRO: não foi possível recuperar UID");
        return "";
    }
  }
  
  // recebe o input cru do usuário e o divide entre comando e string de argumentos
  public static String[] getCommand(String inputtedCmd) {
    return inputtedCmd.split(" ", 2);
  }

  // splita a string de argumentos em um array
  public static String[] getArguments(String inputtedArgs) {
      return inputtedArgs.split(" ");
  }

    // método para exibição de erro
  public static void printError(Exception error) {
    System.out.println("ERRO: " + error.getMessage());
  }

  public static File dirPath(String dirName) {
    String path = Jsh.dir_name + "/" + dirName;
    
    return new File(path);
  }

  public static File getProgram(String commandName) {

    // Instanciando diretório atual
    File currentDir = new File(Jsh.dir_name);
    // Criando lista do conteúdo presente no diretório atual
    File[] listDir = currentDir.listFiles();

    File searchedProgram = null;

    // Printando cada conteúdo da lista
    for (File dir : listDir) {
        if(!dir.isDirectory() && dir.getName().equals(commandName)) {
            searchedProgram = new File(Jsh.dir_name + "/" + dir.getName());
        }
    }

    return searchedProgram;
  }
}