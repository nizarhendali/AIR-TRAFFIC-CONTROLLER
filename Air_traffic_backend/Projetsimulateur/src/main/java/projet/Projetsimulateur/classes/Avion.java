package projet.Projetsimulateur.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import projet.Projetsimulateur.enums.TypeAvion;

import java.util.Collection;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int consommation;
    private int capaciteCarburant;

    @Enumerated(EnumType.STRING)
    private TypeAvion typeAvion;





}
