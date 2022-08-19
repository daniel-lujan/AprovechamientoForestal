package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryC3Model extends CategoryCModel{
    private boolean logging;
    private String individualStatus;
    private String cause;

    public CategoryC3Model(String locationOrType) {
        super(locationOrType);
        this.logging = false;
        this.individualStatus = "";
        this.cause = "";
    }
    
    public CategoryC3Model(String locationOrType, boolean logging, String individualStatus, String cause) {
        super(locationOrType);
        this.logging = false;
        this.individualStatus = individualStatus;
        this.cause = cause;
    }

    public boolean isLogging() {
        return logging;
    }

    public void setLogging(boolean logging) {
        this.logging = logging;
    }

    public String getIndividualStatus() {
        return individualStatus;
    }

    public void setIndividualStatus(String individualStatus) {
        this.individualStatus = individualStatus;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
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
