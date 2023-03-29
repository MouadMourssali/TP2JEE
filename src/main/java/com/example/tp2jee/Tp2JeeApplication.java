package com.example.tp2jee;

import com.example.tp2jee.entities.Patient;
import com.example.tp2jee.repositories.Patientrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2JeeApplication implements CommandLineRunner {
    @Autowired
    private Patientrepository patientrepository;

    public static void main(String[] args) {

        SpringApplication.run(Tp2JeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        patientrepository.save(new Patient(null, "Mouad", new Date(), false, 56));
        patientrepository.save(new Patient(null, "anwar", new Date(), false, 1));
        List<Patient>patients=patientrepository.findAll();
        patients.forEach(patient -> {
            System.out.println("$$$$$$$$$$$$$$$$$$$");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.getScore());
            System.out.println(patient.isMalade());
                }
        );
        System.out.println("$$$$$$$$$$$$$$$$$$$");
        Patient patient=patientrepository.findById(2L).orElse(null);
        if(patient!=null){
            System.out.println(patient.getNom());
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$");
        patient.setScore(1084);
        patientrepository.save(patient);
    }

}
