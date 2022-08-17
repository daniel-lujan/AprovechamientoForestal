package co.gov.minambiente.modelo;

/**
 *
 * @author Andrés Güiza
 */
public class CategoryAModel extends CategoryModel {
    
    private String typeUtilization;

    //Constructors  
    public CategoryAModel(String name){
        super(name);
        this.typeUtilization = null;
    }

    public CategoryAModel(String typeUtilization, String name) {
        super(name);
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
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
