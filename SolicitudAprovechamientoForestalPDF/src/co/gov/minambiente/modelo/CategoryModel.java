package co.gov.minambiente.modelo;

/**
 *
 * @author marit
 */
public abstract class CategoryModel{
    
    private String name;
    
    //Cosntructors
    
    public CategoryModel(){
        this.name = "";
    }
    
    public CategoryModel(String name) {
        this.name = name;
    }
    
    public CategoryModel(String name, String methodUtilization) {
        this.name = name;
    }

    //Setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
