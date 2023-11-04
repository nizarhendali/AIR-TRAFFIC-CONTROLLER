package projet.Projetsimulateur.Reporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.Projetsimulateur.classes.Trajet;
import projet.Projetsimulateur.classes.Vol;

import java.util.List;

public interface VolRepositories  extends JpaRepository<Vol,Integer> {
    public List<Vol> findAll();
    public Vol save(Vol v);
}
