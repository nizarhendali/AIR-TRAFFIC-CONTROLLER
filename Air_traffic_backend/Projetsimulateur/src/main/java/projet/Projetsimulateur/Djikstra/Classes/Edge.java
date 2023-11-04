package projet.Projetsimulateur.Djikstra.Classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edge {
    public int AeroportDepartId;
    public int AeroportArriverId;
    public int weight;

}
