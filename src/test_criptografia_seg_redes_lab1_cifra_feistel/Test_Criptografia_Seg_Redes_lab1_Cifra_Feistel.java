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
        System.out.println("Insira um número de até 8 bits:");
        int valor = sc.nextInt();
        System.out.println("Insira uma chave de até 4 bits:");
        int key1 = sc.nextInt();
        System.out.println("Insira outra chave de até 4 bits:");
        int key2 = sc.nextInt();
        CifraFeistel cf = new CifraFeistel();                
        String bloco = cf.criptografar(valor,key1,key2);
        Binario b = new Binario();
        System.out.println("valor inserido: "+valor);
        int blocoCripto = b.converterBinarioParaDecimal(bloco);
        System.out.println("Criptografado: "+blocoCripto);
        bloco = cf.descriptografar(blocoCripto,key1,key2);
        System.out.println("Descriptografado: "+b.converterBinarioParaDecimal(bloco));      
    }   
}
