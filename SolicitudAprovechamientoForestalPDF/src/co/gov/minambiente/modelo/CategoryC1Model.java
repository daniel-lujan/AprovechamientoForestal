package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryC1Model extends CategoryCModel{
    private String individualStatus;

    public CategoryC1Model(String locationOrType) {
        super(locationOrType);
        individualStatus = "";
    }

    public CategoryC1Model(String locationOrType, String individualStatus) {
        super(locationOrType);
        this.individualStatus = individualStatus;
    } 

    public String getIndividualStatus() {
        return individualStatus;
    }

    public void setIndividualStatus(String individualStatus) {
        this.individualStatus = individualStatus;
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
