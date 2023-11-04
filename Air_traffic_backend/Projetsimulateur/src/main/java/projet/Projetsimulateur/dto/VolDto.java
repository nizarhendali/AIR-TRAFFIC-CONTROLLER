package projet.Projetsimulateur.dto;

import lombok.Data;
import projet.Projetsimulateur.classes.Trajet;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class VolDto {

    private int id;

    private LocalTime heureDepart;

    private AvionDto avionDto;

    private List<Trajet> trajet=new ArrayList<>();


}
