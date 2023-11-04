package projet.Projetsimulateur.Reporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import projet.Projetsimulateur.classes.Trajet;

import java.util.List;


public interface TrajetRepositories extends JpaRepository<Trajet,Integer> {
public List<Trajet> findTrajetsByAeroportDepart_IdAndDistanceLessThanOrAeroportArriver_Id(int id,double distance,int id1);

    List<Trajet> findTrajetsByDistanceLessThan(double dis);
    public List<Trajet> findTrajetsByAeroportDepart_IdOrAeroportArriver_Id(int id1,int id2);

}
