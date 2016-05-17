package br.com;

import java.security.InvalidKeyException;

public class DescriptografarMensagem {
	public static void main(String[] args) {
		ordemDescriptografia("103 -60 -123 -60 -82 -61 -124 -62 -95 -61 -94 -60 -101 107 89 -61 -75 100 -60 -118 -62 -84 -62 -75 119 78 -61 -102 -60 -126 -59 -121 -62 -69 -62 -66 98 -60 -118 -62 -108 92 -61 -91 101 101 -61 -76 116 103 -60 -114 -62 -77 -60 -65 106 -61 -89 -61 -70 -62 -118 -61 -77 -59 -100 -61 -125 -60 -121 -61 -91 -60 -121 -59 -110 -62 -118 -62 -120 -62 -105 99 -60 -106 -59 -123 -61 -95 -61 -95 -62 -77 -60 -80 -61 -102 -61 -116 90 -60 -122 112 84 116 57 109 113 72 88 52 100 79 95 77 54 52 57 83 57 81 107 53 75 90 115 67 68 99 92 66 85 62 51 105 78 51 109 119 117 89 115 79 113 89 95 84 119 95 120 69 80 74 109 106 122 97 55 109 84 84 54");
	}
	
	public static String ordemDescriptografia(String msg){
		String msgDescriptografadaOTP = descriptografarMensagemOTP(msg);
		String msgDescriptografadaRC4 = descriptografarMensagemRC4(msgDescriptografadaOTP);
		return descriptografiaMensagemAES(msgDescriptografadaRC4);
	}
	
	public static String descriptografiaMensagemAES(String msgCriptografada){
		System.out.println("\n\nDescriptografia AES"); 
		byte[] tstenc2 = Conversoes.intToByte(Conversoes.stringToInt(msgCriptografada));
		String textodecriptado = null;
		try {
			textodecriptado = EncriptaDecriptaAES.decrypt(tstenc2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(textodecriptado);
          
        System.out.println("Texto Decriptado: " + textodecriptado);
        return textodecriptado;
	}
	
	public static String descriptografarMensagemRC4(String msgCriptografada){
		System.out.println("\n\nDescriptografia RC4");
		String msgDecriptografada = "";
		try {
			EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("testkey");
//			String msgCriptografada = "Ã¨Ã§Ã�`'";
			char[] textoCriptografado = msgCriptografada.toCharArray();
			msgDecriptografada = new String(rc4.decriptografa(textoCriptografado));
			
			System.out.println("Texto Criptografado: " + msgCriptografada);
			System.out.println("Texto Decriptografado:" + msgDecriptografada);
			
		} catch (InvalidKeyException e) {
			System.err.println(e.getMessage());
		}
		return msgDecriptografada;
	}
	
	public static String seperarChave(String msg){
		String[] textoSeparado = msg.split(" ");
		String msgChave = "";
		for (int i = 1; i <= Integer.valueOf(textoSeparado[0]); i++) {
			msgChave += textoSeparado[i] + " ";
		}
		return msgChave;
	}
	
	public static String separarMsg(String msg){
		String[] textoSeparado = msg.split(" ");
		String msgChave = "";
		for (int i = Integer.valueOf(textoSeparado[0])+1; i < textoSeparado.length; i++) {
			msgChave += textoSeparado[i] + " ";
		}
		return msgChave;
	}
	
	public static String descriptografarMensagemOTP(String msgEmail){
		System.out.println("Descriptografia OTP");
		EncriptaDecriptaOTP otp = new EncriptaDecriptaOTP();
		
		byte[] msgByte = Conversoes.intToByte(Conversoes.stringToInt(seperarChave(msgEmail)));
		byte[] chaveByte = Conversoes.intToByte(Conversoes.stringToInt(separarMsg(msgEmail)));
		
		String chave = Conversoes.GetString(chaveByte);
		String msgCriptografada = Conversoes.GetString(msgByte);
		
		String msgDecriptografada = otp.decriptografa(msgCriptografada, chave);

		System.out.println("Chave: " + chave);
		System.out.println("Mensagem Criptografada: " + msgCriptografada);
		System.out.println("Mensagem Decriptografada: " + msgDecriptografada);
		
		return msgDecriptografada;
	}
}
