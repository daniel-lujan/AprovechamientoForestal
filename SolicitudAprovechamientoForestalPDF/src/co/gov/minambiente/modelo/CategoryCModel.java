package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryCModel extends CategoryModel{
    private String locationOrType;
    
    public CategoryCModel() {
        super("C. Árboles Aislados");
        this.locationOrType = "";
    }
    
    public CategoryCModel(String locationOrType) {
        super("C. Árboles Aislados");
        this.locationOrType = locationOrType;
    }

    public String getLocationOrType() {
        return locationOrType;
    }
    
    public void setLocationOrType(String locationOrType) {
        this.locationOrType = locationOrType;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setMethodUtilization(String methodUtilization) {
        super.setMethodUtilization(methodUtilization); 
    }

    @Override
    public String getMethodUtilization() {
        return super.getMethodUtilization();
    }
}
