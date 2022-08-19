package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryC3Model extends CategoryCModel{
    private String tipo;
    private String individualStatus;
    private String cause;

    public CategoryC3Model(String locationOrType) {
        super(locationOrType);
        this.tipo = tipo;
        this.individualStatus = "";
        this.cause = "";
    }
    
    public CategoryC3Model(String locationOrType, String tipo, String individualStatus, String cause) {
        super(locationOrType);
        this.tipo= tipo;
        this.individualStatus = individualStatus;
        this.cause = cause;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
