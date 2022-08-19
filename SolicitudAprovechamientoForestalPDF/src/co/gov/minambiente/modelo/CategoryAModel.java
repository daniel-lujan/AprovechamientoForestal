package co.gov.minambiente.modelo;

/**
 *
 * @author Andrés Güiza
 */
public class CategoryAModel extends CategoryModel {
    
    private String typeUtilization;

    //Constructors  
    public CategoryAModel(){
        super("A. Productos forestales maderables");
        this.typeUtilization = "";
    }

    public CategoryAModel(String typeUtilization, String methodUtilization) {
        super("A. Productos forestales maderables",methodUtilization);
        this.typeUtilization = typeUtilization;
    }
    
    //Setters & getters

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
