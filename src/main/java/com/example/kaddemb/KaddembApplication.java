package com.example.kaddemb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
@EnableScheduling

@SpringBootApplication
public class KaddembApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaddembApplication.class, args);
    }

    @Scheduled(fixedRate = 60000) //EXECUTER LA TACHE A DES INTERVALLES PERIODIQUE
    public void methode1(){
        System.out.println("FIXED RATE");
    }
    @Scheduled(fixedDelay = 60000) //declancher avec un retard de 60 secondes
    public  void methode2(){
        System.out.println("FIXED DELAY");
    }

}
