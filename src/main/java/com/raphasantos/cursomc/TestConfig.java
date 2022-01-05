package com.raphasantos.cursomc;

import com.raphasantos.cursomc.services.DbService;
import com.raphasantos.cursomc.services.EmailService;
import com.raphasantos.cursomc.services.MockEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DbService dbService;

    @Bean
    public boolean instantiateDataBase() throws ParseException {
        dbService.instantiateTestDataBase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
