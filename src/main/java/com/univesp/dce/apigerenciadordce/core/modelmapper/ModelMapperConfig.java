package com.univesp.dce.apigerenciadordce.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper  modelMapper = new ModelMapper();
        // implementar mapas de tipos customizados

        
        return modelMapper;
    }
}
