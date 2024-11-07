package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entite.Logement;
import entite.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

import java.util.List;

public class Mutations implements GraphQLRootResolver {
    private final RendezVousRepository rendezVousRepository;
    private final LogementRepository logementRepository;

    public Mutations(RendezVousRepository rendezVousRepository, LogementRepository logementRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.logementRepository = new LogementRepository();
    }

    public Boolean createRendezVous(int id, String date, String heure, int refLog, String numTel) {
        Logement l = logementRepository.getLogementsByReference(refLog);
        RendezVous rendezVous = new RendezVous(id, date, heure,l, numTel);
        return rendezVousRepository.addRendezVous(rendezVous);

    }


    public String updateRendezVous(int id, String date, String heure, String numTel) {
        Logement l = rendezVousRepository.getLogementByRDV(id);
        RendezVous rendezVous = new RendezVous(id, date, heure,l, numTel);
        if(rendezVousRepository.updateRendezVous(rendezVous))
            return "success";
        return "echec";

    }

    public boolean deleteRendezVous(int id) {
        return rendezVousRepository.deleteRendezVous(id);
    }
    public List<Logement> createLogement(int reference,String adresse) {
        Logement l = new Logement(reference,adresse);
         logementRepository.saveLogement(l);
         return logementRepository.getAllLogements();
    }
    public boolean supprimerLogement(int ref){
        return logementRepository.deleteLogement(ref);
    }
}
