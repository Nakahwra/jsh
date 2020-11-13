package br.unifil.dc.sisop;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public class ComandosInternosTest 
{
    @Test
    public void exibirRelogioTest()
    {
        int exitCode = ComandosInternos.exibirRelogio();
        assertEquals(0, exitCode);
    }

    @Test
    public void escreverListaArquivosTest()
    {
        int exitCode = ComandosInternos.escreverListaArquivos(Optional.of(System.getProperty("user.dir")));
        assertEquals(0, exitCode);
    }

    @Test
    public void criarNovoDiretorioTest()
    {
        int exitCode = ComandosInternos.criarNovoDiretorio("Nome");
        assertEquals(0, exitCode);
    }

    @Test
    public void apagarDiretorioTest()
    {
        int exitCode = ComandosInternos.apagarDiretorio("Nome");
        assertEquals(0, exitCode);
    }

    @Test
    public void mudarDiretorioTrabalhoTest()
    {
        int exitCode = ComandosInternos.mudarDiretorioTrabalho("/home/");
        assertEquals(0, exitCode);
    }
}
