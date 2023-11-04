package projet.Projetsimulateur.dto;

import lombok.Data;
import projet.Projetsimulateur.classes.Localisation;

import java.util.ArrayList;

@Data
public class AerportDto {

    private int id;
    private String nomAeroport;
    private int nbrPistes;
    private int nbrPlaceAuSol;
    private int tempAtenteAuSol;
    private int tempAcceAuxPistes;
    private int delaiAntiCollision;
    private int tempDecolageAtterissage;
    private int dureeBoucleDAttentEnVol;
    private boolean estFerme;
    private Localisation loc;


}
