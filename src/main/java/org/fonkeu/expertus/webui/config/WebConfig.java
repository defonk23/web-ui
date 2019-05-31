/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fonkeu.expertus.webui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author TN
 */
@Configuration
public class WebConfig {
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
}
