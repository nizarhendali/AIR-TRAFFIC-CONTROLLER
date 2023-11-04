package projet.Projetsimulateur.Mapper;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import projet.Projetsimulateur.classes.Aeroport;
import projet.Projetsimulateur.classes.Avion;
import projet.Projetsimulateur.dto.AerportDto;
import projet.Projetsimulateur.dto.AvionDto;

@Service
public class SimulateurMapper {

    public AerportDto fronAeroport(Aeroport aeroport){
        AerportDto aerportDto=new AerportDto();
        BeanUtils.copyProperties(aeroport,aerportDto);
        return aerportDto;
    }
    public AerportDto fromAeroport(Aeroport aeroport){
        return null;
    }

    public AvionDto fromAvion(Avion avion){
        AvionDto avionDto=new AvionDto();
        BeanUtils.copyProperties(avion,avionDto);
        return  avionDto;
    }
}
