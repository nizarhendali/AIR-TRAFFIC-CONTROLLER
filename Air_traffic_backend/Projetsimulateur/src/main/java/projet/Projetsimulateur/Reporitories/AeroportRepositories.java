package projet.Projetsimulateur.Reporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.Projetsimulateur.classes.Aeroport;

public interface AeroportRepositories extends JpaRepository<Aeroport,Integer> {

    public Aeroport findAeroportByNomAeroport(String name);
    public Aeroport findAeroportById(int id);
}
