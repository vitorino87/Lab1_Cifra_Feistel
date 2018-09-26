/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_criptografia_seg_redes_lab1_cifra_feistel;

/**
 *
 * @author tiago.lucas
 */
public class Binario {
    public void converterDecimalParaBinario(){
        
    }
    public int converterBinarioParaDecimal(String binario){
        int[] valor = new int[binario.length()];
        int decimal = 0;
        binario = inverterString(binario);
        for(int i=0;i<binario.length();i++){
            valor[i]=Integer.parseInt(binario.substring(i, i+1));
            decimal += valor[i]*Math.pow(2,i);
        }
        return decimal;
    }
    public String inverterString(String stringQualquer){
        String stringInvertida="";
        for(int i=stringQualquer.length()-1;i>=0;i--){
            stringInvertida+=stringQualquer.charAt(i);
        }
        return stringInvertida;
    }
}
