package projet.Projetsimulateur.classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vol {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "heure_depart", columnDefinition = "time")
    private LocalTime heureDepart;

    @ManyToOne
    private Avion avion;
    @OneToMany()
    private List<Trajet> trajet=new ArrayList<>();


}
