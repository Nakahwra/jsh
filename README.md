# Jsh
### :pencil: Introdução
Um projeto desenvolvido para a primeira metade da disciplina de Sistemas Operacionais. O Jsh é uma Interface de Linha de Comando (CLI) em Java, nos
moldes do bash, tcsh, fish, zsh, cmd.exe, PowerShell, dentre tantos outros. 

O objetivo deste trabalho é nos aproximarmos das interfaces de programação (APIs) mais
baixas de um sistema operacional, que são as chamadas de sistema. Especificamente, vamos conhecer as principais chamadas oferecidas pela Java Virtual Machine (JVM), que possuem a vantagem de serem traduzidas para o sistema operacional hospedeiro sem precisarmos reprogramar ou recompilar o programa, enquanto provêm funcionalidade similar.

### :computer: Executando o programa
O programa implementa uma Interface de Linha de Comando, portanto, rodará a partir do terminal. É necessário ter seu ambiente configurado com um JRE (minimo 1.8) para rodar o projeto. 

Para executá-lo, primeiramente baixe o seu binário mais recente: [v1.5.0](https://github.com/Nakahwra/jsh/releases/tag/v1.5.0). Em seguida, através de seu terminal, abra o diretório em que o binário foi baixado e execute o comando `java -jar jsh-maven-1.5.0.jar` e o Jsh estará rodando em seu terminal.

### :sparkles: Funcionalidades
O Jsh, atualmente, possui 6 comandos internos. São eles:

- `encerrar`: finaliza a instância do programa;
- `relogio`: exibe a data e a hora atual do sistema;
- `la`: lista os nomes de todos os arquivos e diretórios do atual diretório de trabalho;
- `cd`: cria um novo diretório com nome definido pelo primeiro argumento;
- `ad`: apaga o diretório especificado pelo primeiro argumento;
- `mdt`: troca o atual diretório de trabalho pelo especificado pelo primeiro argumento;

O Jsh também é capaz de executar comandos externos, como códigos escritos em C, desde que tenha permissão. Basta inserir o nome do programa/arquivo que o Jsh processará e imprimirá a execução do programa em tela.

---
:rocket: Desenvolvido por **Lucas Nakahara**
