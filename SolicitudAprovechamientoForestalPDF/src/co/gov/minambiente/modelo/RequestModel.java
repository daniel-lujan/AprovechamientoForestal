/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.modelo;

import java.util.LinkedList;

/**
 *
 * @author marit
 */
public class RequestModel {

    private final String REFERENCE;
    private String typeRequest;
    private InterestedModel interested;
    private LinkedList<PropertyModel> properties;
    private String howToAcquire;
    private CategoryAModel categoryA;
    private CategoryBModel categoryB;
    private CategoryCModel categoryC;
    private CategoryDModel categoryD;
    private DateModel creationDate;
    private String fileNumber;
    private String actNumber;
    private String intendedUse;
    private String methodUtilization;

    //constructors
    public RequestModel(String reference) {
        this.REFERENCE = reference;
        this.typeRequest = "";
        this.interested = new InterestedModel();
        this.properties = new LinkedList<>();
        this.properties.add(new PropertyModel("Colectivo"));
        this.howToAcquire = "";
        this.fileNumber = "";
        this.actNumber = "";
        this.intendedUse = "";
        this.categoryA = new CategoryAModel();
        this.categoryB = new CategoryBModel();
        this.categoryC = new CategoryCModel();
        this.categoryD = new CategoryDModel();
        this.creationDate = new DateModel();
        this.methodUtilization = "";
    }

    public RequestModel(String reference, String typeRequest, InterestedModel interested, LinkedList<PropertyModel> properties) {
        this.REFERENCE = reference;
        this.typeRequest = typeRequest;
        this.interested = interested;
        this.properties = properties;
        this.howToAcquire = "";
        this.fileNumber = "";
        this.actNumber = "";
        this.intendedUse = "";
        this.categoryA = new CategoryAModel();
        this.categoryB = new CategoryBModel();
        this.categoryC = new CategoryCModel();
        this.categoryD = new CategoryDModel();
        this.creationDate = new DateModel();
        this.methodUtilization = "";
    }

    public RequestModel(String REFERENCE, String typeRequest, InterestedModel interested, LinkedList<PropertyModel> properties, String howToAcquire, CategoryAModel categoryA, CategoryBModel categoryB, CategoryCModel categoryC, CategoryDModel categoryD, DateModel creationDate, String fileNumber, String actNumber, String intendedUse, String methodUtilization) {
        this.REFERENCE = REFERENCE;
        this.typeRequest = typeRequest;
        this.interested = interested;
        this.properties = properties;
        this.howToAcquire = howToAcquire;
        this.categoryA = categoryA;
        this.categoryB = categoryB;
        this.categoryC = categoryC;
        this.categoryD = categoryD;
        this.creationDate = creationDate;
        this.fileNumber = fileNumber;
        this.actNumber = actNumber;
        this.intendedUse = intendedUse;
        this.methodUtilization = methodUtilization;
    }

    //Getters & setters
    public String getTypeRequest() {
        return typeRequest;
    }

    public void setTypeRequest(String typeRequest) {
        this.typeRequest = typeRequest;
    }

    public InterestedModel getInterested() {
        return interested;
    }

    public void setInterested(InterestedModel interested) {
        this.interested = interested;
    }

    public LinkedList<PropertyModel> getProperties() {
        return properties;
    }

    public void addProperties(PropertyModel property) {
        this.properties.add(0, property);
    }

    public String getHowToAcquire() {
        return howToAcquire;
    }

    public void setHowToAcquire(String howToAcquire) {
        this.howToAcquire = howToAcquire;
    }

    public CategoryAModel getCategoryA() {
        return categoryA;
    }

    public void setCategoryA(CategoryAModel categoryA) {
        this.categoryA = categoryA;
    }

    public CategoryBModel getCategoryB() {
        return categoryB;
    }

    public void setCategoryB(CategoryBModel categoryB) {
        this.categoryB = categoryB;
    }

    public CategoryCModel getCategoryC() {
        return categoryC;
    }

    public void setCategoryC(CategoryCModel categoryC) {
        this.categoryC = categoryC;
    }

    public CategoryDModel getCategoryD() {
        return categoryD;
    }

    public void setCategoryD(CategoryDModel categoryD) {
        this.categoryD = categoryD;
    }

    public DateModel getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(DateModel creationDate) {
        this.creationDate = creationDate;
    }

    public String getREFERENCE() {
        return REFERENCE;
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getActNumber() {
        return actNumber;
    }

    public void setActNumber(String actNumber) {
        this.actNumber = actNumber;
    }

    public String getIntendedUse() {
        return intendedUse;
    }

    public void setIntendedUse(String intendedUse) {
        this.intendedUse = intendedUse;
    }

    public String getMethodUtilization() {
        return methodUtilization;
    }

    public void setMethodUtilization(String methodUtilization) {
        this.methodUtilization = methodUtilization;
    }
}
