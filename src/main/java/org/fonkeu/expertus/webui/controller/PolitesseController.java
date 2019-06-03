/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fonkeu.expertus.webui.controller;

import java.net.URI;
import java.net.URL;
import org.fonkeu.expertus.webui.model.SalutUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author TN
 */
@Controller
public class PolitesseController {
    private final Logger log= LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;
    @Value("${expertus.backend}")
    private String backendURL;
    
    
    @GetMapping("/politesse.htm")
    public ModelAndView Politesse(){
        
        return new ModelAndView("politesse");
        
    }
    
    @PostMapping("/enregistrer")
    public String enregistrer(@ModelAttribute("salutUI")SalutUI salut, final RedirectAttributes redirectAttributes){
        
        UriComponents url=UriComponentsBuilder.newInstance().path("http://localhost:8084/api/hello")
                .queryParam("name", salut.getName()).build();
        ResponseEntity <String> responseEntity= restTemplate.getForEntity(backendURL+"/api/hello?name="+salut.getName(), String.class);
        log.info(responseEntity.getBody());
        redirectAttributes.addFlashAttribute("message", responseEntity.getBody());
     return "redirect:/";
    }   
    
    @ModelAttribute("salutUI")
    public SalutUI salutUI(){
        return new SalutUI();
    }
}
