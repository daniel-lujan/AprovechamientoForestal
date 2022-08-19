package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryDModel extends CategoryModel{
    private String typeUtilization;

    public CategoryDModel() {
        super("D. Guaduales y bambusales");
        this.typeUtilization = "";
    }
    
    public CategoryDModel(String typeUtilization) {
        super("D. Guaduales y bambusales");
        this.typeUtilization = typeUtilization;
    }

    public String getTypeUtilization() {
        return typeUtilization;
    }

    public void setTypeUtilization(String typeUtilization) {
        this.typeUtilization = typeUtilization;
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
