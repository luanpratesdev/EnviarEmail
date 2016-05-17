package br.com;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncriptaDecriptaAES {
	static String IV = "AAAAAAAAAAAAAAAA";
    static String textopuro = "o professor não irá conseguir ler nossa mensagem.";
    static String chaveencriptacao = "0123456789abcdef";

    public static void main(String [] args) {
          try {
                 System.out.println("Texto Puro: " + textopuro);
                  
                 byte[] textoencriptado = encrypt(textopuro);
                 
                 String txtenc = Conversoes.getValorString(textoencriptado);
                 byte[] tstenc2 = Conversoes.intToByte(Conversoes.stringToInt(txtenc));
                 System.out.print("Texto Encriptado: ");

                 String textodecriptado = decrypt(tstenc2);
                  
                 System.out.println("Texto Decriptado: " + textodecriptado);
           
          } catch (Exception e) {
                 e.printStackTrace();
          }
    }

    public static byte[] encrypt(String textopuro) throws Exception {
    	String chaveencriptacao = "0123456789abcdef";
    	Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }

    public static String decrypt(byte[] textoencriptado) throws Exception{
    	String chaveencriptacao = "0123456789abcdef";
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado),"UTF-8");
    }
  
}
