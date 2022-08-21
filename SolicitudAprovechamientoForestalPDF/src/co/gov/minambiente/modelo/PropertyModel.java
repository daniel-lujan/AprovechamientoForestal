package co.gov.minambiente.modelo;

import java.util.LinkedList;

/**
 * Esta clase contiene los métodos y atributos de un predio
 * @author Maritza
 */
public class PropertyModel {
    
    private String typeProperty;
    private String name;
    private String surface;
    private AddressModel adress;
    private String realEstateRegistration;
    private String cadastralIdNumber;
    private LinkedList<CoordinateModel> coordiantes;
    private LinkedList<SpecieModel> species;
    
    /**
     * Constructor vacío
     */
    public PropertyModel(){
        this.typeProperty = "";
        this.name = "";
        this.surface = "";
        this.adress = new AddressModel();
        this.realEstateRegistration = "";
        this.cadastralIdNumber = "";
        this.coordiantes = new LinkedList<>();
        this.species = new LinkedList<>();
    }
    
    /**
     * Constructor
     * @param typeProperty Tipo (Público, Colectivo, Privado)
     */
    public PropertyModel(String typeProperty){
        this.typeProperty = typeProperty;
        this.name = "";
        this.surface = "";
        this.adress = new AddressModel();
        this.realEstateRegistration = "";
        this.cadastralIdNumber = "";
        this.coordiantes = new LinkedList<>();
        this.species = new LinkedList<>();
    }
  
    /**
     * Constructor full
     * @param typeProperty Tipo (Público, Colectivo, Privado)
     * @param name Nombre
     * @param surface Superficie en hectáreas
     * @param adress Instancia de la dirección
     * @param realEstateRegistration Número de matrícula inmobiliaría
     * @param cadastralIdNumber Número de cédula catastral
     * @param coordiantes Lista de coordenadas del área
     * @param species Lista de instancias de especies objeto de la solicitud
     */
    public PropertyModel(String typeProperty, String name, String surface, 
            AddressModel adress, String realEstateRegistration, String cadastralIdNumber,
            LinkedList<CoordinateModel> coordiantes, LinkedList<SpecieModel> species) {
        this.typeProperty = typeProperty;
        this.name = name;
        this.surface = surface;
        this.adress = adress;
        this.realEstateRegistration = realEstateRegistration;
        this.cadastralIdNumber = cadastralIdNumber;
        this.coordiantes = coordiantes;
        this.species = species;
    }
    
    /**
     * Retorna el tipo (Público, Colectivo, Privado)
     * @return Tipo (Público, Colectivo, Privado)
     */
    public String getTypeProperty() {
        return typeProperty;
    }

    /**
     * Asigna el tipo (Público, Colectivo, Privado)
     * @param typeProperty Tipo (Público, Colectivo, Privado)
     */
    public void setTypeProperty(String typeProperty) {
        this.typeProperty = typeProperty;
    }

    /**
     * Retorna el nombre
     * @return Nombre
     */
    public String getName() {
        return name;
    }

    /**
     * Asigna el nombre
     * @param name Nombre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public AddressModel getAdress() {
        return adress;
    }

    public void setAdress(AddressModel adress) {
        this.adress = adress;
    }

    public String getRealEstateRegistration() {
        return realEstateRegistration;
    }

    public void setRealEstateRegistration(String realEstateRegistration) {
        this.realEstateRegistration = realEstateRegistration;
    }

    public String getCadastralIdNumber() {
        return cadastralIdNumber;
    }

    public void setCadastralIdNumber(String cadastralIdNumber) {
        this.cadastralIdNumber = cadastralIdNumber;
    }

    public LinkedList<CoordinateModel> getCoordiantes() {
        return coordiantes;
    }

    public void setCoordiantes(LinkedList<CoordinateModel> coordiantes) {
        this.coordiantes = coordiantes;
    }

    public LinkedList<SpecieModel> getSpecies() {
        return species;
    }

    public void setSpecies(LinkedList<SpecieModel> species) {
        this.species = species;
    }
    
    
    
    
}
