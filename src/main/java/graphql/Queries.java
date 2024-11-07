package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Queries implements GraphQLRootResolver {
    private final RendezVousRepository rendezVousRepository;
    private final LogementRepository logementRepository;

    public Queries(RendezVousRepository rendezVousRepository,LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = new LogementRepository();
    }

    public List<RendezVous> allRendezVous() {
        return this.rendezVousRepository.getListeRendezVous();
    }

    public List<RendezVous> allRendezVousByRef(int refLog) {
        return rendezVousRepository.getListeRendezVousByLogementRef(refLog);
    }


    public RendezVous getRendezVousById(int id) {
        return rendezVousRepository.getRendezVousById(id);
}
public List<Logement> allLogement() {
        return logementRepository.getAllLogements();
}
public Logement getLogementByRef(int ref) {
        return logementRepository.getLogementsByReference(ref);
}
public List<Logement> logementByType(Logement.Type type) {
        return logementRepository.getLogementsByType(type);
}
}
