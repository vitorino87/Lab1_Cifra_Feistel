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
        // TODO code application logic here   
        String entrada = "10111000";
        Byte b = 126;
        Byte a = 0x51;
        int a2 = 250;
        String f = Integer.toBinaryString(a2);
        System.out.println(f);
        System.out.println(Integer.toBinaryString(211));
        int z = a2 ^ 211;
        System.out.println(Integer.toBinaryString(z));
        //System.out.println(String.valueOf(bit));
    }
    
}
