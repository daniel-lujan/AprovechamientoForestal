package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryC4Model extends CategoryCModel{
    private String tipo;
    private String activity;
    
    public CategoryC4Model(String locationOrType) {
        super(locationOrType);
        this.tipo = tipo;
        this.activity = "";
    }
    
    public CategoryC4Model(String tipo, String activity, String locationOrType) {
        super(locationOrType);
        this.tipo = tipo;
        this.activity = activity;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
