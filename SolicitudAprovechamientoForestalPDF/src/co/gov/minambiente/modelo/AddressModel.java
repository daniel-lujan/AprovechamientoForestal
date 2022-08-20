package co.gov.minambiente.modelo;

/**
 *
 * @author marit
 */
public class AddressModel {
    
    private String street;
    private String typeArea;
    private String department;
    private String municipality;
    private String sidewalk;

   
    public AddressModel(){
        this.street = "";
        this.typeArea = "";
        this.department = "";
        this.municipality = "";
        this.sidewalk = "";
    }
    
    public AddressModel(String street, String typeArea, String department, String municipality, String sidewalk){
        this.street = street;
        this.typeArea = typeArea;
        this.department = department;
        this.municipality = municipality;
        this.sidewalk = sidewalk;
    }
    public AddressModel(String street, String typeArea, String department, String municipality){
        this.street = street;
        this.typeArea = typeArea;
        this.department = department;
        this.municipality = municipality;
       
    
    }
    

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTypeArea() {
        return typeArea;
    }

    public void setTypeArea(String typeArea) {
        this.typeArea = typeArea;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSidewalk() {
        return sidewalk;
    }

    public void setSidewalk(String sidewalk) {
        this.sidewalk = sidewalk;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }
    
    
}
