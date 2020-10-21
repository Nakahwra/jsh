package br.unifil.dc.sisop;

import java.util.Optional;

/**
 * Write a description of class ComandosInternos here.
 *
 * @author Ricardo Inacio Alvares e Silva
 * @version 180823
 */
public final class ComandosInternos {
    
    public static int exibirRelogio() {
      try {

            // Instanciando formatadores de data e hora
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH:mm:ss");

            // Recuperando data e hora local
            LocalDateTime localDate = LocalDateTime.now();

            // Construíndo output
            System.out.println(date.format(localDate) + " às " + hour.format(localDate));
            return 0;

        } catch(Exception error) {
            Library.printError(error);
            return 1;
        }
    }
    
    public static int escreverListaArquivos(Optional<String> nomeDir) {
        try {
            // Instanciando diretório atual
            File currentDir = new File(nomeDir.get());
            // Criando lista do conteúdo presente no diretório atual
            File[] listDir = currentDir.listFiles();
    
            // Printando cada conteúdo da lista
            for (File dir : listDir) {
                if(dir.isDirectory()) {
                    System.out.print(dir.getName() + "/  ");
                } else {
                    System.out.print(dir.getName() + "  ");
                }
            }
    
            // meramente quebra de linha
            System.out.println();
    
            return 0;

        } catch(Exception error) {

            Library.printError(error);
            return 1;
        }
    }
    
    public static int criarNovoDiretorio(String nomeDir) {
      File newDirPath = Library.dirPath(nomeDir);

      if(newDirPath.exists() && newDirPath.isDirectory()) {
          System.out.println("\nAVISO: Diretório já existe.");
          return 1;
      }
      
      newDirPath.mkdir();
      return 0;
    }
    
    public static int apagarDiretorio(String nomeDir) {
      File dirToRemovePath = Library.dirPath(nomeDir);

      if(!dirToRemovePath.exists() || !dirToRemovePath.isDirectory()) {
          System.out.println("\nAVISO: Argumento de remoção inválido.");
          return 1;
      }

      dirToRemovePath.delete();
      return 0;
    }
    
    public static int mudarDiretorioTrabalho(String nomeDir){
        throw new RuntimeException("Método ainda não implementado");
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
