package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryC4Model extends CategoryCModel{
    private boolean logging;
    private String activity;
    
    public CategoryC4Model(String locationOrType) {
        super(locationOrType);
        this.logging = false;
        this.activity = "";
    }
    
    public CategoryC4Model(boolean logging, String activity, String locationOrType) {
        super(locationOrType);
        this.logging = logging;
        this.activity = activity;
    }

    public boolean isLogging() {
        return logging;
    }

    public void setLogging(boolean logging) {
        this.logging = logging;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    
    @Override
    public void setLocationOrType(String locationOrType) {
        super.setLocationOrType(locationOrType);
    }

    @Override
    public String getLocationOrType() {
        return super.getLocationOrType();
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
