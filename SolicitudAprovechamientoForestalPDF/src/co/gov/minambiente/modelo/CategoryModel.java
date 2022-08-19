package co.gov.minambiente.modelo;

/**
 *
 * @author marit
 */
public abstract class CategoryModel{
    
    private String name;
    private String methodUtilization;
    
    //Cosntructors
    
    public CategoryModel(){
        this.name = "";
        this.methodUtilization = "";
    }
    
    public CategoryModel(String name) {
        this.name = name;
    }
    
    public CategoryModel(String name, String methodUtilization) {
        this.name = name;
        this.methodUtilization = methodUtilization;
    }

    //Setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodUtilization() {
        return methodUtilization;
    }

    public void setMethodUtilization(String methodUtilization) {
        this.methodUtilization = methodUtilization;
    }
}
