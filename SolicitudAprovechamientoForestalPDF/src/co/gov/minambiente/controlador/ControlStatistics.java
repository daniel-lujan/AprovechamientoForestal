/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

import co.gov.minambiente.modelo.DateModel;
import co.gov.minambiente.modelo.RequestModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author valeria
 */

public class ControlStatistics {

    /**
     * De aca tomaremos la infomarcion de la fecha con formato (dia/mes/año) 
     * @param data
     * @param selectedDate
     * @return 
     */
    public ArrayList<RequestModel> filterDataByDate(ArrayList<RequestModel> data, DateModel selectedDate){
        
        ArrayList<RequestModel> filterList = new ArrayList<>();
        
        for(RequestModel requestModel : data){
            String creationDateRequest = requestModel.getCreationDate().getDateWithFormat();
            if(creationDateRequest.equals(selectedDate.getDateWithFormat())){
                filterList.add(requestModel);
            }
            
        }
        
        return filterList;
        
    }
    
    /**
     * En este metodo nos ayuda a mirar cuantos formularios se crearon por dia en cierto departamento
     * @param filterList
     * @return 
     */
    
    public ArrayList<RequestFrequency> frequencyByDeparmet(ArrayList<RequestModel> filterList){
        
        ArrayList<RequestFrequency> frecuenciasPorDepartamentos = new ArrayList<>();
        
        for (RequestModel requestModel : filterList) {
            boolean existeEnFrecuencia = false;
            
            String departamentoAux = requestModel.getInterested().getAdress().getDepartment();
            
            for (RequestFrequency frecuenciaFormulario : frecuenciasPorDepartamentos) {
                if(frecuenciaFormulario.getDepartamento().equals(departamentoAux)){
                    frecuenciaFormulario.setFrecuencia(frecuenciaFormulario.getFrecuencia() + 1);
                    existeEnFrecuencia = true;
                }
            }
            if(!existeEnFrecuencia){
                frecuenciasPorDepartamentos.add(new RequestFrequency(departamentoAux, 1));
            }
        }
        
        return frecuenciasPorDepartamentos;    
    }
    
    /**
     * Este nos dira el departamento que mas formularios ha llenado en esa fecha 
     * @param lista
     * @return 
     */
    
    public int findGreatestFrequency(ArrayList<RequestFrequency> lista){
        
        if(!lista.isEmpty()){
            
            int mayor = lista.get(0).getFrecuencia();
            for(RequestFrequency requestFrequency : lista){
                if(requestFrequency.getFrecuencia() > mayor){
                    mayor = requestFrequency.getFrecuencia();
                }
            }
            return mayor;
            
        }
        
        return 0;
        
    }
    
    /**
     * Este metodo nos ayuda a sacar el largo de las barras que se mostraran en el grafico
     * @param lista
     * @param tamanoBarra
     * @return 
     */
    
    public ArrayList<RequestFrequency> setFrequencyWidths(ArrayList<RequestFrequency> lista, int tamanoBarra){
        
        int mayorValor = findGreatestFrequency(lista);
        
        for(RequestFrequency requestFrequency : lista){
            requestFrequency.setTamano(requestFrequency.getFrecuencia()*tamanoBarra /mayorValor);
        }
        
        return lista;
        
    } 
    
    /**
     * Con este metodo empezaremos a crear las barras de los formularios realizados realizados por departamento 
     * cada barra es un departamento
     * @param Grafico
     * @param lista
     * @param xInicial
     * @param yInicial
     * @param anchoBarra
     * @param xInicialTitulo
     * @param colorBarra 
     */
    public void paintBars(Graphics Grafico, ArrayList<RequestFrequency> lista, int xInicial, int yInicial,
             int anchoBarra, int xInicialTitulo, Color colorBarra){
                
                int yRelativo;
                int yRelativoTitulo; 
                String tituloBarra;
                int yInicialTitulo = yInicial + (anchoBarra/2);
                Grafico.setFont(new Font("Tahoma", Font.BOLD, 14));
                for(int i = 0; i < lista.size(); i++){
                    yRelativo = yInicial+ ((anchoBarra + 15)*i);
                    yRelativoTitulo = yInicialTitulo + ((anchoBarra + 15)*i);
                    tituloBarra = lista.get(i).getDepartamento()+ "("+ String.valueOf(lista.get(i).getFrecuencia())+")";
                    Grafico.setColor(colorBarra);
                    Grafico.fillRect(xInicial, yRelativo, lista.get(i).getTamano(), anchoBarra);
                    Grafico.setColor(Color.darkGray);
                    Grafico.drawString(tituloBarra, xInicialTitulo, yRelativoTitulo);
            
                }                
     }
}
