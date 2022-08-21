package co.gov.minambiente.modelo;

/**
 * Esta clase contiene los métodos y atributos de una coordenada
 * @author Maritza
 */
public abstract class CoordinateModel {
    
    private final short POINT;
   
    /**
     * Constructor full
     * @param point Número de punto
     */
    public CoordinateModel(short point) {
        this.POINT = point;
    } 
    
    /**
     * Retorna el número de punto
     * @return Número de punto
     */
    public short getPOINT() {
        return POINT;
    }
    
}
