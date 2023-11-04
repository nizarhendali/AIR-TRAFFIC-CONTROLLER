package projet.Projetsimulateur.Reporitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import projet.Projetsimulateur.classes.Avion;
import projet.Projetsimulateur.enums.TypeAvion;

import java.util.List;

public interface AvionRepositories extends JpaRepository<Avion,Integer>{
    public List<Avion> findAllBy();
    public  Avion findAvionByTypeAvion(TypeAvion type);

}
