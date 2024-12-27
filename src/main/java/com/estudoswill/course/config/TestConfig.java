package com.estudoswill.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudoswill.course.entities.User;
import com.estudoswill.course.repositories.UserRepository;

@Configuration // Indica que esta classe contém configurações de Spring
@Profile("test") // Especifica que esta configuração é ativada apenas quando o perfil 'test' está ativo
public class TestConfig implements CommandLineRunner{

    @Autowired // Injeta a dependência do UserRepository, associando a instância automaticamente
    private UserRepository userRepository;

	@Override // Vai rodar quando a aplicação iniciar
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

		// Salvando todos os objetos criados
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
