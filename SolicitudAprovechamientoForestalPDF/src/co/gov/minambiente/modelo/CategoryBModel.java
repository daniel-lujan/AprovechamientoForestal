package co.gov.minambiente.modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Natalia García
 */
public class CategoryBModel extends CategoryModel{
    private String typeOperation;
    private ArrayList<String> revenuesExpected;
    private String associatedCategory;

    public CategoryBModel() {
        super("B. Manejo Sostenible de Flora Silvestre y los Productos Forestales No Maderables");
        this.typeOperation = "";
        this.revenuesExpected = new ArrayList<>();
        this.associatedCategory = "";
    }

    public CategoryBModel(String typeOperation, ArrayList<String> revenuesExpected, String associatedCategory) {
        super("B. Manejo Sostenible de Flora Silvestre y los Productos Forestales No Maderables");
        this.typeOperation = typeOperation;
        this.revenuesExpected = revenuesExpected;
        this.associatedCategory = associatedCategory;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public ArrayList<String> getRevenuesExpected() {
        return revenuesExpected;
    }

    public void setRevenuesExpected(ArrayList<String> revenuesExpected) {
        this.revenuesExpected = revenuesExpected;
    }

    public String getAssociatedCategory() {
        return associatedCategory;
    }

    public void setAssociatedCategory(String associatedCategory) {
        this.associatedCategory = associatedCategory;
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
