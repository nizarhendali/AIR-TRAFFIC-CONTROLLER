package projet.Projetsimulateur.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import projet.Projetsimulateur.Reporitories.AeroportRepositories;
import projet.Projetsimulateur.Reporitories.VolRepositories;
import projet.Projetsimulateur.Services.SimulateurInterface;
import projet.Projetsimulateur.classes.Aeroport;
import projet.Projetsimulateur.classes.Vol;
import projet.Projetsimulateur.dto.AerportDto;
import projet.Projetsimulateur.dto.VolDto;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin("*")
public class AeroportRestController {
    private VolRepositories volRepositories;
    private AeroportRepositories aeroportRepositories;

    private SimulateurInterface simulateurInterface;


    @GetMapping("/aeroports")
    public List<Aeroport> aeroports(){

        return aeroportRepositories.findAll();
    }
    @GetMapping("/simulerVols")
    public List<Vol> simulerVols(){
        return volRepositories.findAll() ;
    }
}



