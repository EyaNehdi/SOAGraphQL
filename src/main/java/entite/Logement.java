package entite;

import java.util.Objects;

public class Logement {
	private int reference;
	private String adresse;
	private String delegation;
	private String gouvernorat;
	private Type type;
	private String description;

	public Logement(int reference, String adresse) {
		this.reference = reference;
		this.adresse = adresse;
	}

	private float prix;
	
	public enum Type {Studio, Appartement, Villa, EtageVilla} ;


	public Logement(int reference, String adresse, String delegation, String gouvernorat, Type type, String description, float prix) {
		this.reference = reference;
		this.adresse = adresse;
		this.delegation = delegation;
		this.gouvernorat = gouvernorat;
		this.type = type;
		this.description = description;
		this.prix = prix;
	}

	public Logement() {
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDelegation() {
		return delegation;
	}

	public void setDelegation(String delegation) {
		this.delegation = delegation;
	}

	public String getGouvernorat() {
		return gouvernorat;
	}

	public void setGouvernorat(String gouvernorat) {
		this.gouvernorat = gouvernorat;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Logement logement = (Logement) o;
		return reference == logement.reference && Float.compare(prix, logement.prix) == 0 && Objects.equals(adresse, logement.adresse) && Objects.equals(delegation, logement.delegation) && Objects.equals(gouvernorat, logement.gouvernorat) && type == logement.type && Objects.equals(description, logement.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reference, adresse, delegation, gouvernorat, type, description, prix);
	}
}
