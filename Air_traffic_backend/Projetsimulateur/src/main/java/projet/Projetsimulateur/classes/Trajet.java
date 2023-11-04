package projet.Projetsimulateur.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name="aeroportDepart_Id")
    private Aeroport aeroportDepart;

    @ManyToOne
    @JoinColumn(name="aeroportArriver_Id")
    private Aeroport aeroportArriver;

    private double distance;



}
