package com.example.kaddemb.Etudiant;

import com.example.kaddemb.Contrat.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService {
    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    public List<Etudiants> getEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiants addEtudiant(Etudiants e) {
        return etudiantRepository.save(e);
    }

    public void deleteEtudiant(Long ide) {
        etudiantRepository.deleteById(ide);
    }
@Transactional
    public void updateEtudiant(Long ide, Etudiants e) {
        Etudiants etudiants=etudiantRepository.findById(ide).orElseThrow(
                () ->new IllegalStateException("L'etudiant dont l'Id est "+ide+" n'existe pas"));
        etudiants.setPrenomE(e.getPrenomE());
        etudiants.setNomE(e.getNomE());
        etudiants.setPpt(e.getPpt());

        etudiantRepository.save(etudiants);
    }



}
