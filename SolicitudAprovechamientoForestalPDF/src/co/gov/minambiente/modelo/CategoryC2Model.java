package co.gov.minambiente.modelo;

/**
 *
 * @author Natalia García
 */
public class CategoryC2Model extends CategoryCModel{

    public CategoryC2Model(String locationOrType) {
        super(locationOrType);
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
