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
public class CifraFeistel {
    public String criptografar(int entrada, int key1, int key2){
///////////////////////1ª PARTE/////////////////////////////////////////////////        
        //Entrada do bloco de 8 bits
        //Convertendo para binário e depois string
        String bloco = Integer.toBinaryString(entrada);
        //quebrando a String em duas partes
        String parteL = bloco.substring(0, bloco.length()/2);
        String parteR = bloco.substring(bloco.length()/2, 8);             
        //convertendo a parte2 para int
        Binario binario = new Binario();
        int L = binario.converterBinarioParaDecimal(parteL);
        int R = binario.converterBinarioParaDecimal(parteR);
        //Funcao F
        int funcao = R+key1;
        //Realizar Operação XOR
        int xor = L ^ funcao;
        //invertendo os resultados
        L = R;
        R = xor;
///////////////////////FIM DA 1ª PARTE////////////////////////////////////////// 

///////////////////////2ª PARTE/////////////////////////////////////////////////
        //calculando a função
        funcao = R + key2;
        //realizando o xor
        xor = L ^ funcao;
        //invertendo os resultados
        L = R;
        R = xor;
        bloco = Integer.toBinaryString(L)+Integer.toBinaryString(R);
        return bloco;
        //System.out.println("Bloco cifrado: "+bloco);
///////////////////////FIM DA 2ª PARTE//////////////////////////////////////////   
    }
    
    public String descriptografar(int blocoCripto, int key1, int key2){
///////////////1ª PARTE///////////////////////////////////////////////////  
        //preparando e dividindo o bloco em L e R
        String bloco = Integer.toBinaryString(blocoCripto);
        String parteL = bloco.substring(0, bloco.length()/2);
        String parteR = bloco.substring(bloco.length()/2, bloco.length()); 
        Binario binario = new Binario();
        //convertendo binário para decimal
        int L = binario.converterBinarioParaDecimal(parteL);
        int R = binario.converterBinarioParaDecimal(parteR);
        //calculando a função
        int funcao = L+key2;
        //realizando o xor
        int xor = funcao ^ R;
        //invertendo os resultados
        R = L;
        L = xor;
///////////////FIM DA 1ª PARTE///////////////////////////////////////////
        //calculando a função
        funcao = L+key1;
        //realizando o xor
        xor = funcao ^ R;
        //invertendo os resultados
        R = L;
        L = xor;
        return Integer.toBinaryString(L) + Integer.toBinaryString(R);
    }
}
