package projet.Projetsimulateur.Services;

import projet.Projetsimulateur.Exceptions.AeroportNotfound;
import projet.Projetsimulateur.Exceptions.trajetNotfound;
import projet.Projetsimulateur.classes.Aeroport;
import projet.Projetsimulateur.classes.Avion;
import projet.Projetsimulateur.classes.Trajet;
import projet.Projetsimulateur.classes.Vol;
import projet.Projetsimulateur.dto.AerportDto;
import projet.Projetsimulateur.dto.VolDto;
import projet.Projetsimulateur.enums.TypeAvion;

import java.util.ArrayList;
import java.util.List;

public interface SimulateurInterface {
    public Aeroport saveAeroport(Aeroport aeroport);
    public Avion saveAvion(Avion avion);
    public List<Avion> findAllAvion();


    Avion findAvionBytAndTypeAvion(TypeAvion type);

    public List<AerportDto> findAllAeroportDTO();
    public List<Aeroport> findAllAeroport();


    public List<Avion> findAllAvions();
    public Trajet saveTrajet(Trajet trajet);


    public AerportDto getAeroport(int id) ;

    public Trajet getTrajet(int id) ;

    //Aeroport findAeroportByNomAeroport(String name) throws AeroportNotfound;

    Aeroport findByNomAeroport(String name) throws AeroportNotfound;


    void Calculdistance(int AeroportdpId, int AeroportarrId) throws trajetNotfound, AeroportNotfound;
    int calculeDistanceAeroport (double long1 ,double lat1,double long2,double lat2);


    void addAllTraject();
    void addVol(Vol v);

    List<Trajet> simulation(String aeroportname, TypeAvion typeAvion) throws AeroportNotfound;

    List<Integer> trajetslist( double distance,int id,int id1);

    /* @Override
         public void DjikstraOneToMany(String Aeroportdpname, TypeAvion typeAvion) throws AeroportNotfound, trajetNotfound {
             List<Trajet> trajets=simulation(Aeroportdpname,typeAvion);
             for (Trajet tr:trajets){
                 for (Trajet t:trajets){
                     Calculdistance(tr.getAeroportArriver().getId(),t.getAeroportArriver().getId());
                 }

             }
         }*/
    List<AerportDto> getAeroportList();



    List<VolDto> simulerVols(Avion avion, int depart, int arrive, String heure);

    List<Vol> VolsList();


    /* @Override
         public void DjikstraOneToMany(String Aeroportdpname, TypeAvion typeAvion) throws AeroportNotfound, trajetNotfound {
             List<Trajet> trajets=simulation(Aeroportdpname,typeAvion);
             for (Trajet tr:trajets){
                 for (Trajet t:trajets){
                     Calculdistance(tr.getAeroportArriver().getId(),t.getAeroportArriver().getId());
                 }

             }
         }*/



    // void DjikstraOneToMany(String Aeroportdpname, TypeAvion typeAvion) throws AeroportNotfound, trajetNotfound;
}
