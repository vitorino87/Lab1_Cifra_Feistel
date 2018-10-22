/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_criptografia_seg_redes_lab1_cifra_feistel;

import java.util.Scanner;

/**
 *
 * @author Win7
 */
public class Test_Criptografia_Seg_Redes_lab1_Cifra_Feistel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        Scanner sc = new Scanner(System.in);        
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("\tCRIPTOGRAFANDO COM A CIFRA FEISTEL");
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("Insira o texto a ser criptografado:");
        String valor = sc.nextLine();

        System.out.println("Insira a primeira chave:");
        String key1 = sc.nextLine();
        System.out.println("Insira a segunda chave:");
        String key2 = sc.nextLine();

        //processo de criptografia
        CifraFeistel cf = new CifraFeistel();

        String keyAux1 = String.valueOf(key1);
        String keyAux2 = String.valueOf(key2);
        String bloco = cf.realizarCriptografia(valor, keyAux1, keyAux2);

        System.out.println("Criptografado: " + bloco);
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("\tDESCRIPTOGRAFANDO COM A CIFRA FEISTEL");
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println("Insira o texto criptografado: " + bloco);

        System.out.println("Insira a primeira chave:");
        key1 = sc.nextLine();
        System.out.println("Insira a segunda chave:");
        key2 = sc.nextLine();
        keyAux1 = String.valueOf(key1);
        keyAux2 = String.valueOf(key2);
        System.out.println("Descriptografado: " + cf.realizarDescriptografia(bloco, keyAux1, keyAux2));
        System.out.println("==================================================");

    }
}
