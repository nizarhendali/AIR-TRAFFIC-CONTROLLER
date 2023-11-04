package projet.Projetsimulateur.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import projet.Projetsimulateur.enums.TypeAvion;


@Data
public class AvionDto {
    private int id;
    private int consommation;
    private int capaciteCarburant;
    @Enumerated(EnumType.STRING)
    private TypeAvion typeAvion;
}

