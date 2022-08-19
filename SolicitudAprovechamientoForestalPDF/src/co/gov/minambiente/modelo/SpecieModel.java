package co.gov.minambiente.modelo;

/**
 *
 * @author Andrés Güiza
 */
public class SpecieModel {
    
    private double quantity;
    private String unit;
    private String commonName;
    private String scientificName;
    private String partUsed;
    private String habit;
    private String closure;
    private String threatClassification;
    
    //Construnctors
    
    public SpecieModel(){
        this.quantity = 0;
        this.unit = "";
        this.commonName = "";
        this.scientificName = "";
        this.partUsed = "";
        this.habit = "";
        this.closure = "";
        this.threatClassification = "";
    }

    public SpecieModel(double quantity, String unit, String commonName,
            String scientificName, String partUsed, String habit, String closure, 
            String threatClassification) {
        this.partUsed = partUsed;
        this.quantity = quantity;
        this.unit = unit;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.habit = habit;
        this.closure = closure;
        this.threatClassification = threatClassification;
    }
    
    //Setters & getters

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getClosure() {
        return closure;
    }

    public void setClosure(String closure) {
        this.closure = closure;
    }

    public String getThreatClassification() {
        return threatClassification;
    }

    public void setThreatClassification(String threatClassification) {
        this.threatClassification = threatClassification;
    }
}
