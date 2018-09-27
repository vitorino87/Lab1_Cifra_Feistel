/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_criptografia_seg_redes_lab1_cifra_feistel;

/**
 *
 * @author Win7
 */
public class Test_Criptografia_Seg_Redes_lab1_Cifra_Feistel {
    private final static int valor = 128;
    private final static int key1 = 5;
    private final static int key2 = 6;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
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
