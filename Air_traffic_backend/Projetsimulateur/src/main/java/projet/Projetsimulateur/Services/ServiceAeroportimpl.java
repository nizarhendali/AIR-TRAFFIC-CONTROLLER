package projet.Projetsimulateur.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projet.Projetsimulateur.Djikstra.Classes.Edge;
import projet.Projetsimulateur.Djikstra.Classes.Graph;
import projet.Projetsimulateur.Djikstra.Services.Djikstrampl;
import projet.Projetsimulateur.Exceptions.AeroportNotfound;
import projet.Projetsimulateur.Exceptions.trajetNotfound;
import projet.Projetsimulateur.Mapper.SimulateurMapper;
import projet.Projetsimulateur.Reporitories.AeroportRepositories;
import projet.Projetsimulateur.Reporitories.AvionRepositories;
import projet.Projetsimulateur.Reporitories.TrajetRepositories;
import projet.Projetsimulateur.Reporitories.VolRepositories;
import projet.Projetsimulateur.classes.Aeroport;
import projet.Projetsimulateur.classes.Avion;
import projet.Projetsimulateur.classes.Trajet;
import projet.Projetsimulateur.classes.Vol;
import projet.Projetsimulateur.dto.AerportDto;
import projet.Projetsimulateur.dto.VolDto;
import projet.Projetsimulateur.enums.TypeAvion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class ServiceAeroportimpl implements SimulateurInterface {
    private AeroportRepositories aeroportRepositories;
    private TrajetRepositories trajetRepositories;
    private VolRepositories volRepositories;

    private AvionRepositories avionRepositories;
    private SimulateurMapper dtomap;

    @Override
    public Aeroport saveAeroport(Aeroport aeroport) {
        Aeroport aeroport1 = aeroportRepositories.save(aeroport);
        return aeroport;
    }

    @Override
    public Avion saveAvion(Avion avion1) {
        Avion avion = avionRepositories.save(avion1);
        return avion;
    }

    @Override
    public List<Avion> findAllAvion() {
        return avionRepositories.findAll();
    }

    @Override
    public Avion findAvionBytAndTypeAvion(TypeAvion type) {
        return avionRepositories.findAvionByTypeAvion(type);
    }

    @Override
    public List<AerportDto> findAllAeroportDTO() {
        List<Aeroport> aeroports = aeroportRepositories.findAll();
        List<AerportDto> aerportDtos = aeroports.stream()
                .map(aeroport -> dtomap.fronAeroport(aeroport))
                .collect(Collectors.toList());


        return aerportDtos;
    }

    public List<Aeroport> findAllAeroport() {
        return aeroportRepositories.findAll();
    }

    @Override
    public List<Avion> findAllAvions() {
        return avionRepositories.findAll();
    }

    @Override
    public Trajet saveTrajet(Trajet trajet) {
        Trajet trajet1 = trajetRepositories.save(trajet);
        return trajet1;
    }

    @Override
    public AerportDto getAeroport(int id) {
        AerportDto aerportDto=dtomap.fronAeroport(aeroportRepositories.findAeroportById(id));

        return aerportDto;
    }

    @Override
    public Trajet getTrajet(int id)  {

        Trajet trajet = trajetRepositories.findById(id).orElse(null);

        return trajet;
    }


    @Override
    public Aeroport findByNomAeroport(String name) throws AeroportNotfound {
        Aeroport aeroport = aeroportRepositories.findAeroportByNomAeroport(name);
        if (aeroport == null) {
            throw new AeroportNotfound("l'aeroport n'existe pas");
        }
        return aeroport;
    }


    @Override
    public void Calculdistance(int AeroportdpId, int AeroportarrId) throws trajetNotfound, AeroportNotfound {
        List<Edge> edges = new ArrayList<>();
        List<Trajet> trajets = trajetRepositories.findAll();
        for (Trajet t : trajets) {

            edges.add(new Edge(t.getAeroportDepart().getId(), t.getAeroportArriver().getId(), (int) t.getDistance()));
        }


        // total number of nodes in the graph (labelled from 0 to 4)
        int n = edges.size();

        // construct graph
        Graph graph = new Graph(edges, n);

        // run the Dijkstra’s algorithm from every node

        ArrayList<Integer> listeRoute;
        listeRoute = (ArrayList<Integer>)
                Djikstrampl.findShortestPaths(graph, AeroportdpId, n, AeroportarrId);

        //System.out.println(listeRoute);
        affichagetrajet(listeRoute);
    }

    @Override
    public int calculeDistanceAeroport(double lon1, double lat1, double lon2, double lat2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6371000 * c;

        return (int) (distance * Math.pow(10, -3)); //distance KM
    }


    public void affichagetrajet(List<Integer> routes) throws AeroportNotfound {
        String msg = "";
        for (Integer i : routes) {
            msg += "->" + getAeroport(i).getNomAeroport();
        }
        System.out.println(msg);

    }

    @Override
    public void addAllTraject() {
        List<Aeroport> aeroports = aeroportRepositories.findAll();
        for (int i = 0; i < aeroports.toArray().length; i++) {

            for (int j = 0; j < aeroports.toArray().length; j++) {
                if (i == j) {

                } else {
                    Trajet t = new Trajet();
                    t.setAeroportDepart(aeroports.get(i));
                    t.setAeroportArriver(aeroports.get(j));
                    t.setDistance(calculeDistanceAeroport(aeroports.get(i).getLoc().getLng(), aeroports.get(i).getLoc().getLat(), aeroports.get(j).getLoc().getLng(), aeroports.get(j).getLoc().getLat()));
                    saveTrajet(t);
                }
            }

        }

    }

    @Override
    public void addVol(Vol v) {
        volRepositories.save(v);
    }

    @Override
    public List<Trajet> simulation(String aeroportname, TypeAvion typeAvion) throws AeroportNotfound {

        Aeroport aeroport = findByNomAeroport(aeroportname);
        List<Trajet> trajets;

        if (typeAvion == TypeAvion.COURT) {
            trajets = trajetRepositories.findTrajetsByAeroportDepart_IdAndDistanceLessThanOrAeroportArriver_Id(aeroport.getId(), 2000, aeroport.getId());

            for (Trajet t : trajets) {
                System.out.println(t.toString());
            }
        } else if (typeAvion == TypeAvion.MOYEN) {
            trajets = trajetRepositories.findTrajetsByAeroportDepart_IdAndDistanceLessThanOrAeroportArriver_Id(aeroport.getId(), 6000, aeroport.getId());

            for (Trajet t : trajets) {
                System.out.println(t.toString());
            }
        } else {
            trajets = trajetRepositories.findTrajetsByAeroportDepart_IdOrAeroportArriver_Id(aeroport.getId(), aeroport.getId());
            for (Trajet t : trajets) {
                System.out.println(t.toString());
            }
        }
        return trajets;

    }

    @Override
    public List<Integer> trajetslist( double distance,int id_depart,int id_arr)  {
        System.out.println(distance);

        List<Trajet> trajets = trajetRepositories.findTrajetsByDistanceLessThan(distance);
        List<Edge> edges = new ArrayList<>();
        for (Trajet e : trajets) {
            edges.add(new Edge(e.getAeroportDepart().getId(), e.getAeroportArriver().getId(), (int) e.getDistance()));

        }

        System.out.println(edges);
        // total number of nodes in the graph (labelled from 0 to 4)
        ;
        int n = trajets.size();
        // construct graph
        Graph graph = new Graph(edges, n);

        // run the Dijkstra’s algorithm from every node

        ArrayList<Trajet> trajet=new ArrayList<>();

        /*
        * for(Integer i:
            Djikstrampl.findShortestPaths(graph, id_depart, n, id_arr)){
             trajet.add(getTrajet((int)i));
        }*/




        return  Djikstrampl.findShortestPaths(graph, id_depart, n, id_arr);
    }
   /* @Override
    public void DjikstraOneToMany(String Aeroportdpname, TypeAvion typeAvion) throws AeroportNotfound, trajetNotfound {
        List<Trajet> trajets=simulation(Aeroportdpname,typeAvion);
        for (Trajet tr:trajets){
            for (Trajet t:trajets){
                Calculdistance(tr.getAeroportArriver().getId(),t.getAeroportArriver().getId());
            }

        }
    }*/
   @Override
   public List<AerportDto> getAeroportList() {
      // log.info("get Aeroport list {}");
       List<Aeroport> listeAeroport ;
       listeAeroport = aeroportRepositories.findAll();
       List<AerportDto> listeAeroportDto =new ArrayList<>();
       for( Aeroport aeroport : listeAeroport) {
           AerportDto aeroportDto ;
           aeroportDto = dtomap.fronAeroport(aeroport);
           listeAeroportDto.add(aeroportDto);
       }
       return listeAeroportDto;
   }
@Override
   public List<VolDto> simulerVols(Avion avion, int depart, int arrive, String heure) {
        double distance;
        distance=avion.getCapaciteCarburant()*100/avion.getConsommation();
           List<Integer> aeroportDtso2 = trajetslist(distance,depart,arrive);
           System.out.println(aeroportDtso2);
           if(aeroportDtso2.size()!=0){
               Vol vol= new Vol();
               vol.setAvion(avion);
               LocalTime time=LocalTime.parse(heure);
               vol.setHeureDepart(time);
               vol.setTrajet(trajetRepositories.findAllById(aeroportDtso2));
               volRepositories.save(vol);
           }else {
               System.out.println("cette avion n' a pas la capacite suffaisent pour fait cette vol");
           }
       return null;
   }

    @Override
    public List<Vol> VolsList() {
      return   volRepositories.findAll();
    }
}
