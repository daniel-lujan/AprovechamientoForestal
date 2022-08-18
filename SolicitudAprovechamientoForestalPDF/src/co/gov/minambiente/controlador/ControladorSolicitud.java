package co.gov.minambiente.controlador;

import co.gov.minambiente.modelo.AddressModel;
import co.gov.minambiente.modelo.DepartmentModel;
import co.gov.minambiente.modelo.RequestModel;
import co.gov.minambiente.modelo.AttorneyModel;
import co.gov.minambiente.modelo.CategoryAModel;
import co.gov.minambiente.modelo.CategoryBModel;
import co.gov.minambiente.modelo.CategoryCModel;
import co.gov.minambiente.modelo.CategoryDModel;
import co.gov.minambiente.modelo.CategoryModel;
import co.gov.minambiente.modelo.PropertyModel;
import co.gov.minambiente.vista.formulario.Principal;
import co.gov.minambiente.vista.formulario.Seccion1;
import co.gov.minambiente.vista.formulario.Seccion2;
import co.gov.minambiente.vista.formulario.Seccion3;
import co.gov.minambiente.vista.formulario.Seccion4_1;
import co.gov.minambiente.vista.formulario.Seccion4_2;
import co.gov.minambiente.vista.formulario.Seccion5_1;
import co.gov.minambiente.vista.formulario.Seccion5_2;
import co.gov.minambiente.vista.formulario.Seccion6;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.control.RadioButton;

/**
 *
 * @author Natalia García
 */
public class ControladorSolicitud {

    private RequestModel request;
    private Principal principal;
    private Seccion1 seccion1;
    private Seccion2 seccion2;
    private Seccion3 seccion3;
    private Seccion4_1 seccion4_1;
    private Seccion4_2 seccion4_2;
    private Seccion5_1 seccion5_1;
    private Seccion5_2 seccion5_2;
    private Seccion6 seccion6;

    public ControladorSolicitud() {
        request = new RequestModel("1");
        principal = new Principal();
        mostrarPrincipal();
    }

    public void instanciarVentanas() throws IOException {
        seccion1 = new Seccion1(this);
        seccion2 = new Seccion2(this);
        seccion3 = new Seccion3(this);
        seccion4_1 = new Seccion4_1(this);
        seccion4_2 = new Seccion4_2(this);
        seccion5_1 = new Seccion5_1(this);
        seccion5_2 new Seccion5_2(this);
        seccion6 = new Seccion6(this);
    }
    
    public void mostrarPrincipal(){
        principal.setVisible(true);
    }
    
    public void mostrarSeccion1(){
        seccion1.setVisible(true);
    }
    
    public void mostrarSeccion2(){
        seccion2.setVisible(true);
    }
    
    public void mostrarSeccion3(){
        seccion3.setVisible(true);
    }
    
    public void mostrarSeccion4_1(){
        seccion4_1.setVisible(true);
    }
    
    public void mostrarSeccion4_2(){
        seccion4_2.setVisible(true);
    }
    
    public void mostrarSeccion5_1(){
        seccion5_1.setVisible(true);
    }
    
    public void mostrarSeccion5_2(){
        seccion5_2.setVisible(true);
    }
    
    public void mostrarSeccion6(){
        seccion6.setVisible(true);
    }

    public void guardarInformacionSeccion1(String tipoSolicitud, String tipoPersonaInteresado, String nombreInteresado, String tipoIdInteresado,
            String numeroIdInteresado, boolean aplicaApoderado, String nombreApoderado, String tipoIdApoderado, String numeroIdApoderado,
            String TPApoderado, String calidad, String otro, String tipoPredio, boolean aplicaCosto, String costo, String costoLetras) {
        request.setTypeRequest(tipoSolicitud);
        request.getInterested().setTypePerson(tipoPersonaInteresado);
        request.getInterested().setName(nombreInteresado);
        request.getInterested().setTypeId(tipoIdInteresado);
        request.getInterested().setId(numeroIdInteresado);

        if (aplicaApoderado) {
            request.getInterested().setAttorney(new AttorneyModel(TPApoderado, nombreApoderado, tipoIdApoderado, numeroIdApoderado));
        }

        if (calidad.equals("Otro")) {
            request.getInterested().setInterestedQuality(otro);
        } else {
            request.getInterested().setInterestedQuality(calidad);
        }

        request.addProperties(new PropertyModel(tipoPredio));

        if (aplicaCosto) {
            ArrayList<String> cost = new ArrayList<>();
            cost.add(costo);
            cost.add(costoLetras);
            request.getInterested().setProjectCost(cost);
        }
    }

    public void guardarInformacionSeccion2(String numeroExpediente, String numeroActo) {
        request.setFileNumber(numeroExpediente);
        request.setActNumber(numeroActo);
    }

    public void guardarInformacionSeccion3(String terrenosDominio, LinkedList<String> categorias, String tipoAprovechamientoA, String claseManejo,
            String ingresos, String ingresosLetras, String categoriaAsociada, String tipoAprovechamientoD) {
        request.setHowToAcquire(terrenosDominio);
        for (String categoria : categorias) {
            switch (categoria) {
                case "A":
                    request.getCategoryA().setTypeUtilization(tipoAprovechamientoA);
                    break;
                case "B":
                    ArrayList<String> revenues = new ArrayList<>();
                    revenues.add(ingresos);
                    revenues.add(ingresosLetras);
                    request.getCategoryB().setTypeOperation(claseManejo);
                    request.getCategoryB().setRevenuesExpected(revenues);
                    request.getCategoryB().setAssociatedCategory(categoriaAsociada);
                    break;
                case "C":
                    break;
                case "D":
                    request.getCategoryD().setTypeUtilization(tipoAprovechamientoD);
                    break;
            }
        }
    }

    public void guardarInformacionSeccion4_1(String nombre, String superficie, String direccion, String tipo, String departamento,
            String municipio, String vereda, String matriculaInmobiliaria, String cedulaCatastral) {
        LinkedList<PropertyModel> properties = request.getProperties();
        for (PropertyModel property : properties) {
            property.setName(nombre);
            property.setSurface(superficie);
            property.setAdress(new AddressModel(direccion, tipo, departamento, municipio, vereda));
            property.setRealEstateRegistration(matriculaInmobiliaria);
            property.setCadastralIdNumber(cedulaCatastral);
        }
    }

    public void guardarInformacionSeccion4_2() {

    }

    public void guardarInformacionSeccion5_1() {

    }

    public void guardarInformacionSeccion5_2(String otro, String estadoIndividual, String otro1) {

    }

    public void guardarInformacionSeccion6(String correo, int telefono, String direccion, String departamento, String vereda, String municipio, String nombre) {

    }

    public String getTypeProperty() {
        LinkedList<PropertyModel> propertys = request.getProperties();
        return propertys.getFirst().getTypeProperty();
    }

    public LinkedList<String> cargarDepartamentos() throws IOException {
        LinkedList<DepartmentModel> departamentos = Utils.loadMunicipalities((new File("resources\\MunicipiosDepartamentosColombia.txt")));
        LinkedList<String> nombresDepartamentos = new LinkedList<>();
        for (DepartmentModel departamento : departamentos) {
            nombresDepartamentos.add(departamento.getDEPARTMENTNAME());
        }
        return nombresDepartamentos;
    }

    public LinkedList<String> cargarMunicipios(String d) throws IOException {
        LinkedList<DepartmentModel> departamentos = Utils.loadMunicipalities((new File("resources\\MunicipiosDepartamentosColombia.txt")));
        for (DepartmentModel departamento : departamentos) {
            if (departamento.getDEPARTMENTNAME().equals(d)) {
                return departamento.getMUNICIPALITIES();
            }
        }
        return null;
    }

    public void guardarSeccion4_2() {
        if (a.cblCoordenadasPlanas.isSelected()) {

        }
        if (a.cblCoordenadasGeograficas.isSelected()) {

        }
    }

    private static class LinkedLink<T> {

        public LinkedLink() {
        }
    }
}
