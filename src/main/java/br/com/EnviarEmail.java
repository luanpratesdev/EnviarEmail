package br.com;

import java.security.InvalidKeyException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EnviarEmail {
	static String EMAIL_DESTINATARIO;
	static final String EMAIL_EMITENTE = "emailcriptografado.seguro@gmail.com";
	static final String HOST_NAME = "smtp.gmail.com";
	static final String SSL_SMTP_PORT = "465";
	static final int SSL_SMTP_PORT_INT = 465;

	public static String CriptogafarTexto(String texto, String emailDestinatario) {
		EMAIL_DESTINATARIO = emailDestinatario;
		String msgAES = "";
		try {
            byte[] textoencriptado = EncriptaDecriptaAES.encrypt(texto);
            msgAES = Conversoes.getValorString(textoencriptado);
			
            byte[] tstenc2 = Conversoes.intToByte(Conversoes.stringToInt(msgAES));
			String textodecriptado = EncriptaDecriptaAES.decrypt(tstenc2);
			System.out.println(textodecriptado);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String msgRC4 = criptograficaRC4(msgAES);
		return criptografiaOTP(msgRC4);
		
	}

	public static String criptograficaRC4(String textoOriginal) {
		System.out.println("Criptografia RC4");
		String msgCriptografada = "";
		try {
			EncriptaDecriptaRC4 rc4 = new EncriptaDecriptaRC4("testkey");
			char[] textoCriptografado = rc4.criptografa(textoOriginal.toCharArray());
			msgCriptografada = new String(textoCriptografado);
			String msgDecriptografada = new String(rc4.decriptografa(textoCriptografado));
			
			System.out.println("Texto Criptografado: " +msgCriptografada);
			System.out.println("Texto Decriptografado:" + msgDecriptografada);
			
		} catch (InvalidKeyException e) {
			System.err.println(e.getMessage());
		}
		return msgCriptografada;
	}

	public static String criptografiaOTP(String menssagem) {
		System.out.println("\n\nCriptografia OTP");
		EncriptaDecriptaOTP otp = new EncriptaDecriptaOTP();

		String chave = otp.genKey(menssagem.length());
		String msgCriptografada = otp.criptografa(menssagem, chave);
		String msgDecriptografada = otp.decriptografa(msgCriptografada, chave);
		String msgParaEnviarPorEmail = "";
		
		byte[] chaveByte = Conversoes.GetBytes(chave);
		byte[] msgByte = Conversoes.GetBytes(msgCriptografada);
		
		System.out.println("Menssagem: " + menssagem);
		System.out.println("Chave: " + chave);
		System.out.println("Chave Byte:" +Conversoes.getValorString(chaveByte));
		System.out.println("Mensagem Criptografada: " + msgCriptografada);
		System.out.println("Mensagem Criptografada Byte: " +Conversoes.getValorString(msgByte));
		System.out.println("Mensagem Decriptografada: " + msgDecriptografada);
		
		//enviarEmail(msgByte.length + " " + Conversoes.getValorString(msgByte) + "\n" + Conversoes.getValorString(chaveByte));
		
		msgParaEnviarPorEmail = msgByte.length + " " + Conversoes.getValorString(msgByte) + Conversoes.getValorString(chaveByte);
		
		return msgParaEnviarPorEmail;
	}

	public static void enviarEmail(String mensagem) {
		MultiPartEmail email = new MultiPartEmail();
		try {
			email.setHostName(HOST_NAME);
			email.setSslSmtpPort(SSL_SMTP_PORT);
			email.setFrom(EMAIL_EMITENTE);
			email.addTo(EMAIL_DESTINATARIO);
			email.setAuthenticator(new DefaultAuthenticator("emailcriptografado.seguro@gmail.com", "j9s2lrp13"));
			email.setSmtpPort(SSL_SMTP_PORT_INT);
			email.setSslSmtpPort(SSL_SMTP_PORT);
			email.setSSL(true);
			email.setTLS(true);
			email.setSubject("Segurança de Informação - Mensagem");
			email.setMsg(mensagem);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean validEmail(String email) {
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);
		if (m.find()) {
			return true;
		} else {
			return false;
		}
	}
}
