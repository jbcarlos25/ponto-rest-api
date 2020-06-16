package com.example.demo.api.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.api.entity.Empresa;
import com.example.demo.api.entity.Funcionario;
import com.example.demo.api.enums.PerfilEnum;
import com.example.demo.api.utils.PasswordUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	private static final String EMAIL = "jbcarlos@gmail.com";
	private static final String CPF = "23323423524";
	
	@Before
	public void setUp() throws Exception{
		Empresa empresa= this.empresaRepository.save(obterDadosEmpresa());
		this.funcionarioRepository.save(obterDadosFuncionario(empresa));
		
	}
	@After
	public final void tearDown() {
		this.empresaRepository.deleteAll();
	}
	
	@Test
	public void testBuscarFuncionarioPorEmail() {
			Funcionario funcionario = this.funcionarioRepository.findByEmail(EMAIL);
			assertEquals(EMAIL, funcionario.getEmail());
			
		}
	
	@Test
	public void testBuscarFuncionarioPorCpf() {
			Funcionario funcionario = this.funcionarioRepository.findByCpf(CPF);
			assertEquals(CPF, funcionario.getCpf());
			
		}
	@Test
	public void testBuscarFuncionarioPorEmailECpf() {
			Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF, EMAIL);
			assertNotNull(funcionario);
			
		}
	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaEmailInvalido() {
			Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail(CPF,"adasgqer");
			assertNotNull(funcionario);
			
		}
	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaCpfInvalido() {
			Funcionario funcionario = this.funcionarioRepository.findByCpfOrEmail("3342342",EMAIL);
			assertNotNull(funcionario);
			
		}
	

	
	private Funcionario obterDadosFuncionario(Empresa empresa) throws NoSuchAlgorithmException{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("fulano");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setSenha(PasswordUtils.gerarBcrypt("124123"));
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setEmpresa(empresa);
		return funcionario;
		
	}
	
	public Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("empresa tal");
		empresa.setCnpj("2353242342134");
		return empresa;
	}

}
