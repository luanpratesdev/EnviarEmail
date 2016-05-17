package br.com;

import java.io.UnsupportedEncodingException;

public class Conversoes {
	public static byte[] GetBytes(String str){
	    try {
			return str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return null;
	}

	public static String GetString(byte[] bytes){
		String s = null;
		try {
			s = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    return s;
	}
	
	public static String getValorString(byte[] bytes){
		String valor = "";
		for (byte b : bytes) {
			valor += b + " ";
		}
		return valor;
	}
	
	public static int[] stringToInt(String s){
		String[] textoSeparado = s.split(" ");
		int i[] = new int[textoSeparado.length];
		for (int n=0; n<textoSeparado.length; n++) {
			i[n] = Integer.parseInt(textoSeparado[n]);	
		}
		return i;
	}
	
	public static byte[] intToByte(int[] i){
		byte[] msgByte = new byte[i.length];
		for(int n=0; n<i.length; n++){
			msgByte[n] = (byte) i[n];
		}
		return msgByte;
	}
}
