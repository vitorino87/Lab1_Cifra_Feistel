/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_criptografia_seg_redes_lab1_cifra_feistel;

import java.util.ArrayList;

/**
 *
 * @author tiago.lucas
 */
public class CifraFeistel {

    public String criptografar(int entrada, int key1, int key2) {
///////////////////////1ª PARTE/////////////////////////////////////////////////        
        //Entrada do bloco de 8 bits
        //Convertendo para binário e depois string
        String bloco = Integer.toBinaryString(entrada);
        bloco = checarTamanho(bloco, 8);
        //quebrando a String em duas partes
        String parteL = bloco.substring(0, bloco.length() / 2);
        String parteR = bloco.substring(bloco.length() / 2, bloco.length());
        //convertendo a parte2 para int
        Binario binario = new Binario();
        int L = binario.converterBinarioParaDecimal(parteL);
        int R = binario.converterBinarioParaDecimal(parteR);
        //Funcao F
        int funcao = calcularFuncao(R, key1);
        //Realizar Operação XOR
        int xor = L ^ funcao;
        //invertendo os resultados
        L = R;
        R = xor;
///////////////////////FIM DA 1ª PARTE////////////////////////////////////////// 

///////////////////////2ª PARTE/////////////////////////////////////////////////
        //calculando a função
        funcao = calcularFuncao(R, key2);
        //realizando o xor
        xor = L ^ funcao;
        //invertendo os resultados
        L = R;
        R = xor;
        bloco = Integer.toBinaryString(L) + Integer.toBinaryString(R);
        return bloco;
        //System.out.println("Bloco cifrado: "+bloco);
///////////////////////FIM DA 2ª PARTE//////////////////////////////////////////   
    }

    public String descriptografar(int blocoCripto, int key1, int key2) {
///////////////1ª PARTE///////////////////////////////////////////////////  
        //preparando e dividindo o bloco em L e R
        String bloco = Integer.toBinaryString(blocoCripto);
        bloco = checarTamanho(bloco, 8);
        String parteL = bloco.substring(0, bloco.length() / 2);
        String parteR = bloco.substring(bloco.length() / 2, bloco.length());
        Binario binario = new Binario();
        //convertendo binário para decimal
        int L = binario.converterBinarioParaDecimal(parteL);
        int R = binario.converterBinarioParaDecimal(parteR);
        //calculando a função        
        int funcao = calcularFuncao(L, key2);
        //realizando o xor
        int xor = funcao ^ R;
        //invertendo os resultados
        R = L;
        L = xor;
///////////////FIM DA 1ª PARTE///////////////////////////////////////////
        //calculando a função
        funcao = calcularFuncao(L, key1);
        //realizando o xor
        xor = funcao ^ R;
        //invertendo os resultados
        R = L;
        L = xor;
        return checarTamanho(Integer.toBinaryString(L), 4) + checarTamanho(Integer.toBinaryString(R), 4);
    }

    public int calcularFuncao(int val, int key) {
        //return val - 1 + key + 22;
        return val+key;
    }

    public String checarTamanho(String input, int tam) {
        if (input.length() < tam) {
            int num = tam - input.length();
            for (int i = 0; i < num; i++) {
                input = "0" + input;
            }
        }
        return input;
    }

    public String realizarCriptografia(String text, int key1, int key2) {
        String textCripto = "";
        for (int i = 0; i < text.length(); i++) {
            String aux = criptografar(text.charAt(i), key1, key2);
            Binario b = new Binario();
            int auxChar = b.converterBinarioParaDecimal(aux);
            textCripto += (char) auxChar;
        }
        return textCripto;
    }

    public String realizarDescriptografia(String textCripto, int key1, int key2) {
        String text = "";
        for (int i = 0; i < textCripto.length(); i++) {
            String aux = descriptografar(textCripto.charAt(i), key1, key2);
            Binario b = new Binario();
            int auxChar = b.converterBinarioParaDecimal(aux);
            text += (char) auxChar;
        }
        return text;
    }

    public String realizarCriptografia(String text, String key1, String key2) {
        String textCripto = "";
        int[] keyAux1 = new int[key1.length()];
        int[] keyAux2 = new int[key2.length()];
        try {
            for (int i = 0; i < key1.length(); i++) {
                keyAux1[i] = Integer.valueOf(String.valueOf(key1.charAt(i)));
            }
            for (int i = 0; i < key2.length(); i++) {
                keyAux2[i] = Integer.valueOf(String.valueOf(key2.charAt(i)));
            }
        } catch (Exception ex) {
            try {
                for (int i = 0; i < key1.length(); i++) {
                    keyAux1[i] = key1.charAt(i);
                }
                for (int i = 0; i < key2.length(); i++) {
                    keyAux2[i] = key2.charAt(i);
                }
            } catch (Exception ex1) {
                System.out.println("Chave inválida. Erro: " + ex1.toString());
            }
        }

        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < text.length(); i++) {
            String aux = criptografar(text.charAt(i), keyAux1[cont1], keyAux2[cont2]);
            Binario b = new Binario();
            int auxChar = b.converterBinarioParaDecimal(aux);
            textCripto += (char) auxChar;
            cont1++;
            cont2++;
            if (cont1 == key1.length()) {
                cont1 = 0;
            }
            if (cont2 == key2.length()) {
                cont2 = 0;
            }
        }
        return textCripto;
    }

    public String realizarDescriptografia(String textCripto, String key1, String key2) {
        String text = "";
        int[] keyAux1 = new int[key1.length()];
        int[] keyAux2 = new int[key2.length()];
        try {
            for (int i = 0; i < key1.length(); i++) {
                keyAux1[i] = Integer.valueOf(String.valueOf(key1.charAt(i)));
            }
            for (int i = 0; i < key2.length(); i++) {
                keyAux2[i] = Integer.valueOf(String.valueOf(key2.charAt(i)));
            }
        } catch (Exception ex) {
            try {
                for (int i = 0; i < key1.length(); i++) {
                    keyAux1[i] = key1.charAt(i);
                }
                for (int i = 0; i < key2.length(); i++) {
                    keyAux2[i] = key2.charAt(i);
                }
            } catch (Exception ex1) {
                System.out.println("Chave inválida. Erro: " + ex1.toString());
            }
        }

        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < textCripto.length(); i++) {
            String aux = descriptografar(textCripto.charAt(i), keyAux1[cont1], keyAux2[cont2]);
            Binario b = new Binario();
            int auxChar = b.converterBinarioParaDecimal(aux);
            text += (char) auxChar;
            cont1++;
            cont2++;
            if (cont1 == key1.length()) {
                cont1 = 0;
            }
            if (cont2 == key2.length()) {
                cont2 = 0;
            }
        }
        return text;
    }

    public ArrayList<String> dividirBinario(int entrada) {
        ArrayList<String> ar = new ArrayList<String>();
        //Convertendo para binário e depois string
        String bloco = Integer.toBinaryString(entrada);
        bloco = checarTamanho(bloco, 8);
        //quebrando a String em duas partes
        String parteL = bloco.substring(0, bloco.length() / 2);
        String parteR = bloco.substring(bloco.length() / 2, bloco.length());
        ar.add(parteL);
        ar.add(parteR);
        return ar;
    }

    public void funcao2() {

    }
}
