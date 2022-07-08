package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Empresa;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.EmpresaRepository;

@Component
public class InitializeDataBase2 implements CommandLineRunner{
	
	@Autowired
	private EmpresaRepository eRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Empresa luiz = new Empresa();
		luiz.setNome("Santa Amalia");
		luiz.setCargo("Gerente");
		luiz.setUsuario("Luiza");
		
		eRepo.save(luiz);
	}
}
