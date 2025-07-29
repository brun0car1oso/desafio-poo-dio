package br.com.dio.desafio.dominio;

import java.util.Scanner;

public class LeitorDeEntrada {

    private static Scanner scanner = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.next();
    }

    public static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }
}
