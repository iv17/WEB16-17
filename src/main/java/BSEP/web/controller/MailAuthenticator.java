package BSEP.web.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {

	String username;
	String password;

	public MailAuthenticator (String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}


}
