package com.exemplo.demo.api.utils;


import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.api.utils.PasswordUtils;

public class PasswordUtilsTest {
	
	private static final String SENHA = "12345";
	private final BCryptPasswordEncoder bcryptEndcoder = new BCryptPasswordEncoder();
	
	@Test
	public void testSenhaNula() throws Exception {
		assertNull(PasswordUtils.gerarBcrypt(null));
	}
	@Test
	public void testGerarHashSenha() throws Exception {
		String hash = PasswordUtils.gerarBcrypt(SENHA);
		assertTrue(bcryptEndcoder.matches(SENHA, hash));
	}

}
