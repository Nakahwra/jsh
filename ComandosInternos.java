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
        throw new RuntimeException("Método ainda não implementado");
    }
    
    public static int criarNovoDiretorio(String nomeDir) {
        throw new RuntimeException("Método ainda não implementado");
    }
    
    public static int apagarDiretorio(String nomeDir) {

        throw new RuntimeException("Método ainda não implementado");
    }
    
    public static int mudarDiretorioTrabalho(String nomeDir){
        throw new RuntimeException("Método ainda não implementado");
    }
    
    /**
     * Essa classe não deve ser instanciada.
     */
    private ComandosInternos() {}
}
