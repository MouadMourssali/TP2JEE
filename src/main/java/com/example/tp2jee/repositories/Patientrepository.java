package com.example.tp2jee.repositories;

import com.example.tp2jee.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patientrepository extends JpaRepository<Patient,Long> {
}
