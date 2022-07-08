package br.edu.ifsuldeminas.mch.si.webii.postmanager.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Address;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.Cidade;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.User;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.AddressRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.CidadeRepository;
import br.edu.ifsuldeminas.mch.si.webii.postmanager.spring.model.repositories.UserRepository;

@Component
public class InitializeDataBase implements CommandLineRunner{
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private AddressRepository aRepo;
	
	@Autowired
	private CidadeRepository cRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Cidade cEmerson = new Cidade();
		cEmerson.setName("Nova Resende");
		cEmerson.setState("Minas Gerais");
		
		Cidade cLuiza = new Cidade();
		cLuiza.setName("Guaxupe");
		cLuiza.setState("Minas Gerais");
		
		Cidade eLuiza = new Cidade();
		eLuiza.setName("Ubatuba");
		eLuiza.setState("São Paulo");
		
		cRepo.save(cEmerson);
		cRepo.save(cLuiza);
		cRepo.save(eLuiza);
		cRepo.flush();
		
		Address aEmerson = new Address();
		aEmerson.setPlace("Candido Ornelas");
		aEmerson.setNumber(289);
		aEmerson.setZipCode("37560000");
		aEmerson.setCidade(cEmerson);
		
		Address aLuiza = new Address();
		aLuiza.setPlace("Bartolomeu de Camargo");
		aLuiza.setNumber(245);
		aLuiza.setZipCode("37750000");
		aLuiza.setCidade(cLuiza);
		
		aRepo.save(aEmerson);
		aRepo.save(aLuiza);
		aRepo.flush();
		
		User emerson = new User();
		emerson.setName("Emerson Assis");
		emerson.setEmail("assis@gmail.com");
		emerson.setGender("M");
		emerson.setAddress(aEmerson);
		
		User luiza = new User();
		luiza.setName("Luiza Carvalho");
		luiza.setEmail("lu@mail.com");
		luiza.setGender("F");
		luiza.setAddress(aLuiza);
		
		uRepo.save(emerson);
		uRepo.save(luiza);
	}
}
