package projet.Projetsimulateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import projet.Projetsimulateur.Djikstra.Classes.Edge;
import projet.Projetsimulateur.Djikstra.Classes.Graph;
import projet.Projetsimulateur.Djikstra.Services.Djikstrampl;
import projet.Projetsimulateur.Exceptions.trajetNotfound;
import projet.Projetsimulateur.Reporitories.AeroportRepositories;
import projet.Projetsimulateur.Services.ServiceAeroportimpl;
import projet.Projetsimulateur.Services.SimulateurInterface;
import projet.Projetsimulateur.classes.Aeroport;
import projet.Projetsimulateur.classes.Avion;
import projet.Projetsimulateur.classes.Localisation;
import projet.Projetsimulateur.classes.Trajet;
import projet.Projetsimulateur.enums.TypeAvion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ProjetsimulateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetsimulateurApplication.class, args);
	}



@Bean
CommandLineRunner commandLineRunner(SimulateurInterface simulateurinterface, AeroportRepositories aeroportRepositories){
	return args -> {
       /*
		Aeroport a1 = new Aeroport();
		a1.setNomAeroport("Casablanca");
		a1.setLoc(new Localisation(null, 33.3667, -7.5867));
		a1.setNbrPistes(10);
		a1.setNbrPlaceAuSol(12);
		a1.setDureeBoucleDAttentEnVol(10);
		a1.setEstFerme(false);
		a1.setDelaiAntiCollision(5);
		a1.setTempAcceAuxPistes(10);
		a1.setTempAtenteAuSol(20);
		a1.setTempDecolageAtterissage(60);
		simulateurinterface.saveAeroport(a1);
		Aeroport a2 = new Aeroport();
		a2.setNomAeroport("Tanger");
		a2.setLoc(new Localisation(null, 35.759465, -5.833954));
		a2.setNbrPistes(20);
		a2.setNbrPlaceAuSol(3);
		a2.setEstFerme(false);
		a2.setDureeBoucleDAttentEnVol(8);
		a2.setDelaiAntiCollision(2);
		a2.setTempAcceAuxPistes(12);
		a2.setTempAtenteAuSol(23);
		a2.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a2);


		Aeroport a3 = new Aeroport();
		a3.setNomAeroport("paris");
		a3.setLoc(new Localisation(null, 48.856614, 2.3522219));
		a3.setNbrPistes(20);
		a3.setNbrPlaceAuSol(3);
		a3.setDureeBoucleDAttentEnVol(8);
		a3.setDelaiAntiCollision(2);
		a3.setTempAcceAuxPistes(12);
		a3.setEstFerme(false);
		a3.setTempAtenteAuSol(23);
		a3.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a3);


		Aeroport a4 = new Aeroport();
		a4.setNomAeroport("londre");
		a4.setLoc(new Localisation(null, 51.509093, -0.094151));
		a4.setNbrPistes(20);
		a4.setNbrPlaceAuSol(3);
		a4.setDureeBoucleDAttentEnVol(8);
		a4.setDelaiAntiCollision(2);
		a4.setTempAcceAuxPistes(12);
		a4.setEstFerme(false);
		a4.setTempAtenteAuSol(23);
		a4.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a4);


		Aeroport a5 = new Aeroport();
		a5.setNomAeroport("Mexico");
		a5.setLoc(new Localisation(null, 23.634501, -102.552784));
		a5.setNbrPistes(20);
		a5.setNbrPlaceAuSol(3);
		a5.setDureeBoucleDAttentEnVol(8);
		a5.setDelaiAntiCollision(2);
		a5.setTempAcceAuxPistes(12);
		a5.setTempAtenteAuSol(23);
		a5.setEstFerme(true);
		a5.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a5);
		/////////////////
		Aeroport a6 = new Aeroport();
		a6.setNomAeroport("Jakarta");
		a6.setLoc(new Localisation(null, -6.2087634, 106.845599));
		a6.setNbrPistes(20);
		a6.setNbrPlaceAuSol(3);
		a6.setDureeBoucleDAttentEnVol(8);
		a6.setDelaiAntiCollision(2);
		a6.setTempAcceAuxPistes(12);
		a6.setTempAtenteAuSol(23);
		a6.setEstFerme(false);
		a6.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a6);
		//////////////////
		Aeroport a7 = new Aeroport();
		a7.setNomAeroport("Beljing");
		a7.setLoc(new Localisation(null, 39.904211, 116.407395));
		a7.setNbrPistes(20);
		a7.setNbrPlaceAuSol(3);
		a7.setDureeBoucleDAttentEnVol(8);
		a7.setDelaiAntiCollision(2);
		a7.setTempAcceAuxPistes(12);
		a7.setTempAtenteAuSol(23);
		a7.setEstFerme(false);
		a7.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a7);
		////////
		Aeroport a8 = new Aeroport();
		a8.setNomAeroport("São Paulo-Guarulhos");
		a8.setLoc(new Localisation(null, -23.4356, -46.4731));
		a8.setNbrPistes(20);
		a8.setNbrPlaceAuSol(3);
		a8.setDureeBoucleDAttentEnVol(8);
		a8.setDelaiAntiCollision(2);
		a8.setTempAcceAuxPistes(12);
		a8.setTempAtenteAuSol(23);
		a8.setEstFerme(false);
		a8.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a8);
		///////
		Aeroport a9 = new Aeroport();
		a9.setNomAeroport("King Shaka");
		a9.setLoc(new Localisation(null, -29.6145, 31.1196));
		a9.setNbrPistes(20);
		a9.setNbrPlaceAuSol(3);
		a9.setDureeBoucleDAttentEnVol(8);
		a9.setDelaiAntiCollision(2);
		a9.setTempAcceAuxPistes(12);
		a9.setTempAtenteAuSol(23);
		a9.setEstFerme(false);
		a9.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a9);
		////////////////
		Aeroport a10 = new Aeroport();
		a10.setNomAeroport("Domodedovo");
		a10.setLoc(new Localisation(null, 55.4103, 37.9025));
		a10.setNbrPistes(20);
		a10.setNbrPlaceAuSol(3);
		a10.setDureeBoucleDAttentEnVol(8);
		a10.setDelaiAntiCollision(2);
		a10.setTempAcceAuxPistes(12);
		a10.setTempAtenteAuSol(23);
		a10.setEstFerme(false);
		a10.setTempDecolageAtterissage(30);
		simulateurinterface.saveAeroport(a10);


		Avion avion1 = new Avion();
		avion1.setTypeAvion(TypeAvion.LONG);
		avion1.setConsommation(100);
		avion1.setCapaciteCarburant(60000);
		simulateurinterface.saveAvion(avion1);

		Avion avion2 = new Avion();
		avion2.setTypeAvion(TypeAvion.COURT);
		avion2.setConsommation(60);
		avion2.setCapaciteCarburant(1800);
		simulateurinterface.saveAvion(avion2);

		//Plane Creation Plane-3
		Avion avion3 = new Avion();
		avion3.setTypeAvion(TypeAvion.MOYEN);
		avion3.setConsommation(80);
		avion3.setCapaciteCarburant(7800);
		simulateurinterface.saveAvion(avion3);

		//Plane Creation Plane-4


		simulateurinterface.addAllTraject();*/

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {

			System.out.println("------------------------- bienvenue ---------------------------");
			System.out.println("Menu:");
			System.out.println("1 : Liste des airoports .");
			System.out.println("2 : Liste des avion .");
			System.out.println("3 : Ajouter Vol .");
			System.out.println("4. quitte");
			System.out.print("choisissez: ");
			choice = scanner.nextInt();


			switch (choice) {
				case 1:
					System.out.println("Listes des aeroports : ");
					for (Aeroport aeroport : simulateurinterface.findAllAeroport()) {
						System.out.println(aeroport.toString());
					}
					// Perform actions for Option 1
					break;
				case 2:
					System.out.println("listes des avions");
					for (Avion avion : simulateurinterface.findAllAvion()) {
						System.out.println(avion.toString());
					}
					break;
				case 3:System.out.println("Aeroport de depart:");
					int aerodepart = scanner.nextInt();
					scanner.nextLine(); // Consume the remaining newline character

					System.out.println("Aeroport d'arrivee:");
					int aeroar = scanner.nextInt();
					scanner.nextLine(); // Consume the remaining newline character

					System.out.println("Avion:");
					String avion = scanner.nextLine();
					TypeAvion type;
					if (avion.equals("long")) {
						type = TypeAvion.LONG;
					} else if (avion.equals("court")) {
						type = TypeAvion.COURT;
					} else {
						type = TypeAvion.MOYEN;
					}

					System.out.println("Heure depart:");
					String heure = scanner.nextLine();
					simulateurinterface.simulerVols(simulateurinterface.findAvionBytAndTypeAvion(type), aerodepart, aeroar, heure);
					//simulateurinterface.simulerVols( simulateurinterface.findAvionBytAndTypeAvion(type),aerodepart,aeroar,heure);
					break;
				case 4:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice");
					break;
			}
			System.out.println(); // Empty line for readability
		} while (choice != 4);

		scanner.close();


	};
}

}
