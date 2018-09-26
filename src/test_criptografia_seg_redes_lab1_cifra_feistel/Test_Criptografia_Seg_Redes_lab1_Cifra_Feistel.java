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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        CifraFeistel cf = new CifraFeistel();
        System.out.println("Entrada: 250\nChave 1: 12\nChave 2: 11");
        String bloco = cf.criptografar(250,12,11);
        Binario b = new Binario();
        int block = b.converterBinarioParaDecimal(bloco);
        System.out.println("Criptografado: "+block);
        bloco = cf.descriptografar(block,12,11);
        System.out.println("Descriptografado: "+b.converterBinarioParaDecimal(bloco));      
    }   
}
