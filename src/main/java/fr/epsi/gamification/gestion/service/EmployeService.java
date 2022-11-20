package fr.epsi.gamification.gestion.service;

import fr.epsi.gamification.gestion.beans.Employe;
import fr.epsi.gamification.gestion.interfaces.WebServices;
import fr.epsi.gamification.gestion.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService implements WebServices<Employe> {

    @Autowired
    private final EmployeRepository employeRepository;

    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    @Override
    public List<Employe> get_all() {
        return employeRepository.findAll();
    }

    @Override
    public void add_one(Employe e) {

        employeRepository.save(e);

    }

    @Override
    public Employe update(int id, Employe e) {
        return employeRepository.findById(id)
                .map(p ->{
                    p.setNom(e.getNom());
                    p.setPrenom(e.getPrenom());
                    p.setDate_naissance(e.getDate_naissance());
                    p.setPays(e.getPays());
                    return employeRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Attention une execption à été generer client introuvable"));
    }

    @Override
    public void remove(int id) {

        Employe employe = employeRepository.findById(id).get();

        if(employe != null)
            employeRepository.delete(employe);

    }

    @Override
    public Employe getById(int id) {
        return employeRepository.findById(id).orElseThrow(()-> new RuntimeException("Desoler employe non trouver"));
    }
}
