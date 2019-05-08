package com.isra.pratice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isra.pratice.domain.Pessoa;
import com.isra.pratice.repository.PessoaRepository;

@SpringBootApplication
public class Pratice1Application  implements CommandLineRunner{
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Pratice1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		Pessoa pessoa1 = new Pessoa(null, "Israel Araujo", "isra.rar@icloud.com", "09696767439");
		Pessoa pessoa2 = new Pessoa(null, "Max", "Max@icloud.com", "096958747439");
		Pessoa pessoa3 = new Pessoa(null, "Klebao", "Klebao@icloud.com", "11196767439");
		Pessoa pessoa4 = new Pessoa(null, "WagnerBoy", "Wagner@icloud.com", "11196767439");
		
		pessoaRepository.saveAll(Arrays.asList(pessoa1,pessoa2,pessoa3,pessoa4));
		
		
	}

}
