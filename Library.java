package br.unifil.dc.sisop;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;

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
}