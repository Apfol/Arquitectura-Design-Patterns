package proxy;

import static org.junit.Assert.*;

import org.junit.Test;

import adapter.Pasajero;
import adapter.Usuario;
import j_unit.User;

public class FacadeProxyTest {

	@Test
	public void testAdicionar() {

		String email = "casa@gmail.com";
		String password = "123";
		String key = "11234";
		
		FacadeProxy facadeProxy = FacadeProxy.getFacadeProxyInstance();
		
		User ejemplo = new User(email, password);
		facadeProxy.adicionar(key, ejemplo);
		
		User ejemplo1 = facadeProxy.buscar(key);
		
		assertEquals(ejemplo1.getEmail(), email);
		
	}

	@Test
	public void testActualizar() {

		String emailEjemplo1 = "casa@gmail.com";
		String passwordEjemplo1 = "123";
		String key = "11234";
		
		FacadeProxy facadeProxy = FacadeProxy.getFacadeProxyInstance();
		
		User ejemplo1 = new User(emailEjemplo1, passwordEjemplo1);
		facadeProxy.adicionar(key, ejemplo1);
		
		String emailEjemplo2 = "casa2@gmail.com";
		String passwordEjemplo2 = "1234";
		
		User ejemplo2 = new User(emailEjemplo2, passwordEjemplo2);
		facadeProxy.actualizar(key, ejemplo2);
		
		assertEquals(emailEjemplo2, facadeProxy.buscar(key).getEmail());
		
	}
	
	@Test
	public void testEliminar() {

		String emailEjemplo1 = "casa@gmail.com";
		String passwordEjemplo1 = "123";
		String key = "11234";
		
		FacadeProxy facadeProxy = FacadeProxy.getFacadeProxyInstance();
		
		User ejemplo1 = new User(emailEjemplo1, passwordEjemplo1);
		facadeProxy.adicionar(key, ejemplo1);
		
		facadeProxy.eliminar(key);
		
		assertTrue(facadeProxy.buscar(key) == null);
		
	}
	
	@Test
	public void testBuscar() {

		String emailEjemplo1 = "casa@gmail.com";
		String passwordEjemplo1 = "123";
		String key = "11234";
		
		FacadeProxy facadeProxy = FacadeProxy.getFacadeProxyInstance();
		
		User ejemplo1 = new User(emailEjemplo1, passwordEjemplo1);
		facadeProxy.adicionar(key, ejemplo1);
		
		assertTrue(facadeProxy.buscar(key) != null);
		
	}
	
	
}
