package co.gov.minambiente.modelo;

/**
 *
 * @author marit
 */
public class AttorneyModel extends PersonModel {
    
    private String profesionalCard;
    
  
    
    public AttorneyModel(){
        this.profesionalCard = "";
    }

    public AttorneyModel(String profesionalCard) {
        this.profesionalCard = profesionalCard;
    }

    public AttorneyModel(String profesionalCard, String name, String typeId, String id) {
        super(name, typeId, id);
        this.profesionalCard = profesionalCard;
    }
    
  

    public String getProfesionalCard() {
        return profesionalCard;
    }

    public void setProfesionalCard(String profesionalCard) {
        this.profesionalCard = profesionalCard;
    }

    @Override
    public void setId(String id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTypeId(String typeId) {
        super.setTypeId(typeId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTypeId() {
        return super.getTypeId(); //To change body of generated methods, choose Tools | Templates.
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
