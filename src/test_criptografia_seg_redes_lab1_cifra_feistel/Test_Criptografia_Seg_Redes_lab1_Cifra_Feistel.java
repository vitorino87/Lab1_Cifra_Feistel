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
        //System.out.println("Insira um número decimal de 8 bits:");
        //int valor = sc.nextInt();
        System.out.println("Insira o texto a ser criptografado:");
        String valor = sc.nextLine();
        
        System.out.println("Insira a primeira chave:");
        //int key1 = sc.nextInt();
        String key1 = sc.nextLine();
        System.out.println("Insira a segunda chave:");
        //int key2 = sc.nextInt();
        String key2 = sc.nextLine();
        
        //processo de criptografia
        CifraFeistel cf = new CifraFeistel();                
        //String bloco = cf.criptografar(valor,key1,key2);
        //String bloco = cf.realizarCriptografia(valor, key1, key2);
        String keyAux1 = String.valueOf(key1);
        String keyAux2 = String.valueOf(key2);
        //String bloco = cf.realizarCriptografia(valor, String.valueOf(key1), String.valueOf(key2));
        String bloco = cf.realizarCriptografia(valor, keyAux1, keyAux2);

        Binario b = new Binario();
        
        //System.out.println("Número inserido: "+valor);
        //System.out.println("Caractere associado: "+(char)valor);
                
        //int blocoCripto = b.converterBinarioParaDecimal(bloco);
        //System.out.println("Criptografado: "+blocoCripto);
        System.out.println("Criptografado: "+bloco);
        System.out.println("Descriptografado: "+cf.realizarDescriptografia(bloco, keyAux1, keyAux2));
        //int a = blocoCripto;
        //System.out.println("Caractere associado - criptografia: "+(char)a);
        
        //processo de descriptografia
        //bloco = cf.descriptografar(blocoCripto,key1,key2);
        //System.out.println("Descriptografado: "+b.converterBinarioParaDecimal(bloco)); 
        //a = b.converterBinarioParaDecimal(bloco);
        //System.out.println("Caracter associado - descriptografado: "+(char)a);
    }   
}
