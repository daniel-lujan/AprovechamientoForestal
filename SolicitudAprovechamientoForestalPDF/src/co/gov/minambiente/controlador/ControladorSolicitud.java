package co.gov.minambiente.controlador;

import co.gov.minambiente.controlador.database.RequestsDatabase;
import co.gov.minambiente.modelo.*;
import co.gov.minambiente.vista.formulario.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Natalia García
 */
public class ControladorSolicitud {

    private static RequestsDatabase requestsDatabase = new RequestsDatabase();
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
        request = new RequestModel(requestsDatabase.getNewReference());
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
        mostrarPrincipal();
    }

    public void instanciarVentanas() {
        try {
            seccion1 = new Seccion1(this);
            seccion2 = new Seccion2(this);
            seccion4_1 = new Seccion4_1(this);
            seccion4_2 = new Seccion4_2(this);
            seccion5_1 = new Seccion5_1(this);
            seccion5_2 = new Seccion5_2(this);
            seccion6 = new Seccion6(this);
        } catch (IOException e) {

        }
    }

    public void instanciarVentana3() {
        seccion3 = new Seccion3(this);
    }

    public void mostrarPrincipal() {
        principal.setVisible(true);
    }

    public void mostrarSeccion1() {
        seccion1.setVisible(true);
    }

    public void mostrarSeccion2() {
        seccion2.setVisible(true);
    }

    public void mostrarSeccion3() {
        seccion3.setVisible(true);
    }

    public void mostrarSeccion4_1() {
        seccion4_1.setVisible(true);
    }

    public void mostrarSeccion4_2() {
        seccion4_2.setVisible(true);
    }

    public void mostrarSeccion5_1() {
        seccion5_1.setVisible(true);
    }

    public void mostrarSeccion5_2() {
        seccion5_2.setVisible(true);
    }

    public void mostrarSeccion6() {
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
        System.out.println(request.getProperties().size());

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
        properties.get(0).setName(nombre);
        properties.get(0).setSurface(superficie);
        properties.get(0).setAdress(new AddressModel(direccion, tipo, departamento, municipio, vereda));
        properties.get(0).setRealEstateRegistration(matriculaInmobiliaria);
        properties.get(0).setCadastralIdNumber(cedulaCatastral);
    }

    public boolean guardarInformacionSeccion4_2(LinkedList<Object[]> coordinates) {
        LinkedList<CoordinateModel> lista = new LinkedList();
        if (coordinates.size() > 0) {
            if (coordinates.get(0).length == 3) {
                for (Object[] arr : coordinates) {
                    lista.add(new PlaneCoordinateModel(
                            (double) arr[1],
                            (double) arr[2],
                            (short) arr[0]));
                }
            } else {
                for (Object[] arr : coordinates) {
                    lista.add(new GeographicCoordinateModel(
                            (ArrayList) arr[0],
                            (ArrayList) arr[1],
                            (double) arr[2],
                            (String) arr[3],
                            (short) arr[4]));
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public void guardarInformacionSeccion5_1(String metodo, String[][] datosTabla, String uso) {
        request.setMethodUtilization(metodo);

        for (String[] datos : datosTabla) {
            request.getProperties().get(0).getSpecies().add(new SpecieModel(Double.parseDouble(datos[0]), datos[1], datos[2], datos[3],
                    datos[4], datos[5], datos[6], datos[7]));
        }

        request.setIntendedUse(uso);
    }

    public void guardarInformacionSeccion5_2(String otro, String estadoIndividual, String otro1) {

    }

    public void guardarInformacionSeccion6(String correo, int telefono, String direccion, String departamento, String vereda, String municipio, String nombre) {

    }

    public String verTypeProperty() {
        return request.getProperties().get(0).getTypeProperty();
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

}
