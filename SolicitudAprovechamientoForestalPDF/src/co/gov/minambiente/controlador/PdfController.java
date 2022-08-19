/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;


import co.gov.minambiente.modelo.RequestModel;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrés Güiza
 */
public class PdfController {

    public static String espacio = "\u00A0";
    public static LinkedList<Text> texts;
    public static String titleFont = "ArialNarrowBold.ttf";
    public static String bodyFont = "ArialMT.ttf";
    public static Color grayBg = new DeviceRgb(200, 188, 190);
    public static Color greenBg = new DeviceRgb(185, 229, 161);
    public static Color whiteBg = new DeviceRgb(0, 0, 0);
    public static Color blueBg = new DeviceRgb(152, 228, 235);

    public static void fillDocument(PdfWorkspace generatedDoc, RequestModel solicitude) throws MalformedURLException, IOException {

        int lineCounter = drawPage1(generatedDoc, solicitude);
        lineCounter = drawPage2(lineCounter, generatedDoc, solicitude);
        lineCounter = drawPage3(lineCounter, generatedDoc, solicitude);
        generatedDoc.crearPdf();
    }

    public static int drawPage1(PdfWorkspace generatedDoc, RequestModel solicitude) {

        try {
            texts = cargarBD();
        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int lineCounter = 3;
        try {

            addHeader(generatedDoc, texts);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, grayBg, 0);
            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 9);

            Paragraph p;
            p = generatedDoc.nuevoParrafo(new Text(espacio + espacio), titleFont, 10f);
            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getInterested().getName() + "\n");
            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter, String.valueOf(solicitude.getInterested().getId()) + "\n");
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);

            if (solicitude.getInterested().getAttorney().getName() != null) {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getInterested().getAttorney().getName() + "\n");
                lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter,
                        String.valueOf(solicitude.getInterested().getAttorney().getId()),
                        String.valueOf(solicitude.getInterested().getAttorney().getProfesionalCard()) + "\n");
            } else {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, "" + "\n");
                lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter,
                        "",
                        "" + "\n");
            }

            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);

            if (!(solicitude.getInterested().getInterestedQuality().equals("Propietario")
                    || solicitude.getInterested().getInterestedQuality().equals("Poseedor")
                    || solicitude.getInterested().getInterestedQuality().equals("Tenedor")
                    || solicitude.getInterested().getInterestedQuality().equals("Ocupante")
                    || solicitude.getInterested().getInterestedQuality().equals("Autorizado")
                    || solicitude.getInterested().getInterestedQuality().equals("Ente territorial")
                    || solicitude.getInterested().getInterestedQuality().equals("Consejo comunitario")
                    || solicitude.getInterested().getInterestedQuality().equals("Resguardo indígena"))) {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getInterested().getInterestedQuality() + "\n");
            } else {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter);
                lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            }

            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);

            if (solicitude.getInterested().getProjectCost() != null) {
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, String.valueOf(solicitude.getInterested().getProjectCost().get(0)) + "\n");
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, String.valueOf(solicitude.getInterested().getProjectCost().get(1)) + "\n");
            } else {
                p.add(new Text("No aplica").setFontSize(9.5f));
            }

            p.setFixedLeading(20);
            p.setBorder(new SolidBorder(0.75f));
            p.setMarginRight(-5);
            p.setMarginLeft(-5);
            p.setPaddingLeft(5);
            p.setRelativePosition(0, -18, 0, 0);
            generatedDoc.empujarParrafo(p);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, blueBg, 27);
            Paragraph q;

            q = generatedDoc.nuevoParrafo(new Text(espacio + espacio), titleFont, 10f);
            lineCounter = addBodyLine(q, generatedDoc, lineCounter, solicitude.getFileNumber() + "\n");
            lineCounter = addBodyLine(q, generatedDoc, lineCounter, String.valueOf(solicitude.getActNumber()) + "\n");
            lineCounter = addBodyTitleLine(q, generatedDoc, lineCounter);
            
            q.setFixedLeading(20);
            q.setBorder(new SolidBorder(0.75f));
            q.setMarginLeft(-5);
            q.setMarginRight(-5);
            q.setRelativePosition(0, -36, 0, 0);
            q.setPaddingTop(5);
            q.setPaddingLeft(5);
            generatedDoc.empujarParrafo(q);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 45);
            Paragraph r;
            r = generatedDoc.nuevoParrafo(new Text(espacio + espacio), titleFont, 10f);
            lineCounter = addBodyTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter, 7.5f);
            lineCounter = addTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addTitleLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);

            if (!solicitude.getCategoryB().getTypeOperation().equals("")) {
                lineCounter = addBodyTitleLine(r, generatedDoc, lineCounter, solicitude.getCategoryB().getRevenuesExpected().get(0));
                lineCounter = addBodyLine(r, generatedDoc, lineCounter, solicitude.getCategoryB().getRevenuesExpected().get(1));
                System.out.println("asdasdasd");
            } else {
                lineCounter = addTitleLine(r, generatedDoc, lineCounter);
                lineCounter = addBodyLine(r, generatedDoc, lineCounter);
                lineCounter = addBodyLine(r, generatedDoc, lineCounter);
                lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            }
            lineCounter = addUndelinedBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addBodyLine(r, generatedDoc, lineCounter);
            lineCounter = addTitleLine(r, generatedDoc, lineCounter);
            r.setFixedLeading(20);
            r.setBorder(new SolidBorder(0.75f));
            r.setMarginLeft(-5);
            r.setMarginRight(-5);
            r.setPaddingLeft(5);
            r.setPaddingTop(5);
            r.setRelativePosition(0, -54, 0, 0);
            generatedDoc.empujarParrafo(r);

        } catch (IOException ex) {
            System.out.println("Error de entrada y salida de datos" + espacio + ex);
        }
        generatedDoc.pasarPagina(2);
        return lineCounter;
    }

    /**
     * 
     * @param lineCounter
     * @param generatedDoc
     * @param solicitude
     * @return 
     */
    public static int drawPage2(int lineCounter, PdfWorkspace generatedDoc, RequestModel solicitude) {

        try {
            addHeader(generatedDoc, texts);
            Paragraph p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);
            
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, 8);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            setUpParagraph(p, generatedDoc, 9, 20);
            
            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 18);
            p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getName(),
                    solicitude.getProperties().get(0).getSurface() + "\n");
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getAdress().getStreet());
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getAdress().getDepartment(),
                    solicitude.getProperties().get(0).getAdress().getMunicipality(),
                    solicitude.getProperties().get(0).getAdress().getSidewalk() + "\n");
            p.add(new Text("\n"));
            
            if (!solicitude.getProperties().get(0).getRealEstateRegistration().equals("")) {
                lineCounter = addBodyLine(p, generatedDoc,
                        lineCounter, solicitude.getProperties().get(0).getRealEstateRegistration() + "\n");
                lineCounter = addBodyLine(p, generatedDoc, lineCounter);
                p.add(new Text("\n"));
            } else{
                lineCounter = addBodyLine(p, generatedDoc, lineCounter, "\n");
                p.add(new Text("\n"));
                lineCounter = addBodyLine(p, generatedDoc,
                        lineCounter, solicitude.getProperties().get(0).getCadastralIdNumber() + "\n");
                p.add(new Text("\n"));
            }
            
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            
            Table t = createTable1(generatedDoc);
            p.add(t);      
            p.add(new Text ("\n \n"));
                
            Table t2 = createTable2(generatedDoc);
            p.add(t2);
            p.add(new Text("\n \n"));
            
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            
            setUpParagraph(p, generatedDoc, 27, 10);
            
            generatedDoc.pasarPagina(3);
            
        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCounter;
    }

    public static int drawPage3(int lineCounter, PdfWorkspace generatedDoc, RequestModel solicitude) {
        try {
            
            addHeader(generatedDoc, texts);
            lineCounter = addSingleTitle(generatedDoc, lineCounter, greenBg, 9);
            
            Paragraph p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);
            
            p.add(new Text("\n"));
            lineCounter = addBodyTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            
            Table t = createTable3(generatedDoc);
            p.add(t);
            p.add(new Text("\n \n"));
        
            lineCounter = addTitleLine(p, generatedDoc, lineCounter,8);
            lineCounter = addTitleLine(p, generatedDoc, lineCounter,8);
            p.add(new Text("\n \n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter, 8);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, solicitude.getMethodUtilization() + "\n");
            p.add(new Text("\n"));
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));

            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));

            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            p.add(new Text("\n"));
   
            switch (solicitude.getCategoryC().getName()) {
                case ("i. Árboles aislados dentro de la cobertura del bosque natural"):

                    break;
                case ("ii. Árboles aislados fuera de la cobertura del bosque natural"):

                    break;
                case ("iii Tala o poda de emergencia en centros urbano"):

                    break;
                case ("iv. Obra pública o privada en centros urbanos"):

                    break;
                default:
                    break;
            }

            
            
            
            setUpParagraph(p, generatedDoc, 18, 10);
        
        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCounter;
    }
    
    private static Table createTable3(PdfWorkspace generatedDoc) throws IOException{
        
        Table table = new Table(UnitValue.createPercentArray(8)).setWidth(530).setRelativePosition(10, 0, 0, 0);
        
        Paragraph q = new Paragraph();
        generatedDoc.pushText(q, new Text("Cantidad"), titleFont, 8);
        Cell cell = new Cell (2,1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Unidad de medida*"), titleFont, 8);
        Cell cell12 = new Cell (2,1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell12);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Nombre común"), titleFont, 8);
        Cell cell13 = new Cell (2,1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell13);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Nombre científico"), titleFont, 8);
        Cell cell14 = new Cell (2,1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell14);
   
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Aplica para únicamente para manejo\n"
                + "sostenible de flora silvestre y los productos\n"
                + "forestales no maderables"), titleFont, 8);
        Cell cell15 = new Cell(1, 2).add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell15);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Veda nacional\n"
                + "o regional\n"
                + "(si aplica) **"), titleFont, 8);
        Cell cell17 = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell17);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Categoría\n"
                + "de\n"
                + "amenaza\n"
                + "(si aplica)"), titleFont, 8);
        Cell cell18 = new Cell(2, 1).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addHeaderCell(cell18);
    
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Parte aprovechada"
                + "(Raíz, Fruto, Semilla,"
                + "Flor, Corteza,"
                + "Exudado, Yema, Hojas,"
                + "Tallos, Ramas, etc.)"), titleFont, 8);
        Cell cell25 = new Cell().add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell25);
     
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Hábito"
                + "(Árbol, Arbusto,"
                + "Hierba terrestre,"
                + "Epífita, Bejuco/liana,"
                + "Hemiepífita, Palma,"
                + "etc.)"), titleFont, 8f);
        Cell cell26 = new Cell().add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell26);
        
        for (int i = 0; i < 80; i++) {
            q = new Paragraph();
            generatedDoc.pushText(q, new Text(""), titleFont, 8f);
            Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setMinHeight(10);
            table.addCell(temporal);
        }
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Cantidad \n Total"), titleFont, 8f);
        Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(greenBg);
        table.addFooterCell(temporal);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text(""), titleFont, 8f);
        Cell cellFinal = new Cell (1,7).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addFooterCell(cellFinal);

        return table;
    }

    /**
     * 
     * @param generatedDoc
     * @return
     * @throws IOException 
     */
    private static Table createTable2(PdfWorkspace generatedDoc) throws IOException{
        
        Table table = new Table(UnitValue.createPercentArray(8)).setWidth(450).setRelativePosition(50, 0, 0, 0);
        
        Paragraph q = new Paragraph();
        generatedDoc.pushText(q, new Text("Coordenadas geograficas"), titleFont, 8.5f);
        Cell cell = new Cell (1,8).add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
        table.addHeaderCell(cell);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Punto"), titleFont, 8.5f);
        Cell cell21 = new Cell(2,1).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell21).setTextAlignment(TextAlignment.CENTER);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Latitud"), titleFont, 8.5f);
        Cell cell22 = new Cell(1,3).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell22).setTextAlignment(TextAlignment.CENTER);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Longitud"), titleFont, 8.5f);
        Cell cell25 = new Cell(1,3).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell25).setTextAlignment(TextAlignment.CENTER);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Punto"), titleFont, 8.5f);
        Cell cell28 = new Cell(2, 1).add(q).setBackgroundColor(greenBg);
        table.addHeaderCell(cell28).setTextAlignment(TextAlignment.CENTER);

        String[] textFields = {"Grados", "Minutos", "Segundos", "Grados", "Minutos", "Segundos"};
        for (String textField : textFields) {
            q = new Paragraph();
            generatedDoc.pushText(q, new Text(textField), titleFont, 8.5f);
            Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(greenBg);
            table.addHeaderCell(temporal);
        }
        
        for (int i = 0; i < 96; i++) {
            q = new Paragraph();
            generatedDoc.pushText(q, new Text(""), titleFont, 8.5f);
            Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER);
            table.addCell(temporal).setMinHeight(175);
        }
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text("Origen"), titleFont, 8.5f);
        Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER).setBackgroundColor(greenBg);
        table.addFooterCell(temporal).setMinHeight(175);
        
        q = new Paragraph();
        generatedDoc.pushText(q, new Text(""), titleFont, 8.5f);
        Cell cellFinal = new Cell (1,7).add(q.setTextAlignment(TextAlignment.CENTER));
        table.addFooterCell(cellFinal).setMinHeight(175);

        return table;
    }
    
    /**
     * 
     * @param generatedDoc
     * @return 
     */
    public static Table createTable1(PdfWorkspace generatedDoc){
        
        Table table = new Table(UnitValue.createPercentArray(3)).setWidth(450).setRelativePosition(50, 0, 0, 0);
        
        try {
            Paragraph q = new Paragraph();
            generatedDoc.pushText(q, new Text("Coordenadas planas"), titleFont, 8.5f);
            Cell cell = new Cell(1,3).add(q.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            table.addHeaderCell(cell);
            
            Paragraph c = new Paragraph();
            generatedDoc.pushText(c, new Text("Punto"), titleFont, 8.5f);
            Cell cell21 = new Cell().add(c.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            Paragraph x = new Paragraph();
            generatedDoc.pushText(x, new Text("X"), titleFont, 8.5f);
            Cell cell22 = new Cell().add(x.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            Paragraph y = new Paragraph();
            generatedDoc.pushText(y, new Text("Y"), titleFont, 8.5f);
            Cell cell23 = new Cell().add(y.setTextAlignment(TextAlignment.CENTER)).setBackgroundColor(greenBg);
            
            table.addHeaderCell(cell21).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell22).setTextAlignment(TextAlignment.CENTER);
            table.addHeaderCell(cell23).setTextAlignment(TextAlignment.CENTER);

            for (int i = 0; i < 36; i++) {
                q = new Paragraph();
                generatedDoc.pushText(q, new Text(""), titleFont, 8.5f);
                Cell temporal = new Cell().add(q).setTextAlignment(TextAlignment.CENTER);
                table.addCell(temporal).setMinHeight(175);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;  
    } 
    
    /**
     *
     * @param p
     * @param generatedDoc
     * @param relativePosition
     * @param leading
     */
    public static void setUpParagraph(Paragraph p, PdfWorkspace generatedDoc, int relativePosition, int leading) {
        p.setFixedLeading(leading);
        p.setBorder(new SolidBorder(0.75f));
        p.setMarginRight(-5);
        p.setMarginLeft(-5);
        p.setPaddingLeft(5);
        p.setRelativePosition(0, 0, 0, relativePosition);
        generatedDoc.empujarParrafo(p);
    }

    /**
     * Cada línea de texto en Y, difiere en 20 coordenadas de la anterior
     *
     * @param generatedDoc
     * @param color
     */
    public static void generateCheckBoxes1(PdfWorkspace generatedDoc, Color color) {

        int y = 817;

        //first
        generatedDoc.createRectangle(color, 165, y, 18, 10);
        generatedDoc.createRectangle(color, 230, y, 18, 10);
        //second
        generatedDoc.createRectangle(color, 149, y - 40, 18, 10);
        generatedDoc.createRectangle(color, 244, y - 40, 18, 10);
        generatedDoc.createRectangle(color, 339, y - 40, 18, 10);
        //thirth
        generatedDoc.createRectangle(color, 146, y - 80, 18, 10);
        generatedDoc.createRectangle(color, 191, y - 80, 18, 10);
        generatedDoc.createRectangle(color, 236, y - 80, 18, 10);
        generatedDoc.createRectangle(color, 283, y - 80, 18, 10);
        //Fourth
        generatedDoc.createRectangle(color, 146, y - 140, 18, 10);
        generatedDoc.createRectangle(color, 191, y - 140, 18, 10);
        generatedDoc.createRectangle(color, 236, y - 140, 18, 10);
        //Fifth
        generatedDoc.createRectangle(color, 85, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 156, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 223, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 293, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 368, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 456, y - 180, 18, 10);
        //sixth
        generatedDoc.createRectangle(color, 123, y - 200, 18, 10);
        generatedDoc.createRectangle(color, 236, y - 200, 18, 10);
        generatedDoc.createRectangle(color, 286, y - 200, 18, 10);
        //Seventh
        generatedDoc.createRectangle(color, 143, y - 240, 18, 10);
        generatedDoc.createRectangle(color, 213, y - 240, 18, 10);
        generatedDoc.createRectangle(color, 276, y - 240, 18, 10);
        //Eight
        generatedDoc.createRectangle(color, 151, y - 483, 18, 10);
        generatedDoc.createRectangle(color, 207, y - 483, 18, 10);
        generatedDoc.createRectangle(color, 292, y - 483, 18, 10);
        generatedDoc.createRectangle(color, 402, y - 483, 18, 10);
        //ninth
        generatedDoc.createRectangle(color, 262, y - 503, 18, 10);
        //Tenth
        generatedDoc.createRectangle(color, 180, y - 563, 18, 10);
        //Eleventh
        generatedDoc.createRectangle(color, 292, y - 583, 18, 10);
        generatedDoc.createRectangle(color, 348, y - 583, 18, 10);
        generatedDoc.createRectangle(color, 423, y - 583, 18, 10);
        generatedDoc.createRectangle(color, 559, y - 583, 18, 10);
        //Twelft
        generatedDoc.createRectangle(color, 292, y - 623, 18, 10);
        generatedDoc.createRectangle(color, 368, y - 623, 18, 10);
        //Thirteenth
        generatedDoc.createRectangle(color, 292, y - 623, 18, 10);
        generatedDoc.createRectangle(color, 368, y - 623, 18, 10);
        //Fourtheenth
        generatedDoc.createRectangle(color, 89, y - 745, 18, 10);
        generatedDoc.createRectangle(color, 173, y - 745, 18, 10);
        generatedDoc.createRectangle(color, 249, y - 745, 18, 10);

    }

    public static int addBodyTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 10f);
            lineCounter++;
            generatedDoc.pushText(p, texts.get(lineCounter), bodyFont, 9f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    /**
     *
     * @param p
     * @param generatedDoc
     * @param lineCounter
     * @param datas
     * @return
     * @throws IOException
     */
    public static int addBodyTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, String... datas) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 10f);
            lineCounter++;
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, datas);
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    /**
     *
     * @param p
     * @param generatedDoc
     * @param lineCounter
     * @return
     * @throws IOException
     */
    public static int addTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 10f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addTitleLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, int fontSize) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), titleFont, 8f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), bodyFont, 9f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, String... datas) throws IOException {

        String temporal = "";
        for (String data : datas) {
            texts.get(lineCounter + 1).setText(data + "       ");
            temporal = temporal + texts.get(lineCounter).getText() + texts.get(lineCounter + 1).getText();
            lineCounter += 2;
        }

        generatedDoc.pushText(p, new Text(temporal), bodyFont, 9f);
        return lineCounter;
    }

    public static int addBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter, float fontSize) throws IOException {

        try {
            generatedDoc.pushText(p, texts.get(lineCounter), bodyFont, fontSize);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addUndelinedBodyLine(Paragraph p, PdfWorkspace generatedDoc, int lineCounter) throws IOException {

        try {
            generatedDoc.pushUnderlinedText(p, texts.get(lineCounter), bodyFont, 9f);
            lineCounter++;
        } catch (IOException e) {
            System.out.println("Imposible generar la linea, la fuente no es válida");
        }
        return lineCounter;
    }

    public static int addSingleTitle(PdfWorkspace generatedDoc, int i, Color color, int relativePosition) throws IOException {
        Paragraph title = generatedDoc.nuevoParrafo(new Text(espacio + espacio), "ArialNarrowBold.ttf", 10f);
        generatedDoc.pushText(title, texts.get(i), "ArialNarrowBold.ttf", 10f);
        title.setBorder(new SolidBorder(0.75f));
        title.setMarginLeft(-5);
        title.setMarginRight(-5);
        title.setPaddingLeft(5);
        i++;
        title.setBackgroundColor(color, 0.75f);
        title.setRelativePosition(0, 0, 0, relativePosition);
        generatedDoc.empujarParrafo(title);
        return i;
    }

    public static LinkedList<Text> cargarBD() throws IOException {
        String[] textoFormatos = Utils.loadFile(new File("resources\\formularioCampos.txt"));
        LinkedList<Text> textsList = new LinkedList<>();

        for (String textoFormato : textoFormatos) {
            textsList.add(new Text(textoFormato));
        }
        return textsList;
    }

    public static void addHeader(PdfWorkspace generatedDoc, LinkedList<Text> texts) throws MalformedURLException, IOException {

        Paragraph encabezado = generatedDoc.nuevoParrafo("minambiente.png", 44, 214, 30, 920);
        encabezado.setTextAlignment(TextAlignment.CENTER);
        //Interlineado
        encabezado.setFixedLeading(12);
        generatedDoc.pushText(encabezado, texts.getFirst().setRelativePosition(10, 0, 0, 0), "ArialNarrowBold.ttf", 11.5f);
        generatedDoc.pushText(encabezado, texts.get(1).setRelativePosition(10, 0, 0, 0), "ArialNarrowBold.ttf", 9.5f);
        generatedDoc.empujarImagen(encabezado, "sina.png", 41, 127, 450, 925);
        encabezado.setBorder(new SolidBorder(0.75f));
        encabezado.setMargin(-5);
        generatedDoc.empujarParrafo(encabezado);

        encabezado = generatedDoc.nuevoParrafo(texts.get(2), "ArialMT.ttf", 8.3f);
        encabezado.setBorder(new SolidBorder(0.75f));
        encabezado.setMarginLeft(-5);
        encabezado.setTextAlignment(TextAlignment.CENTER);
        encabezado.setMarginRight(-5);
        generatedDoc.empujarParrafo(encabezado);
    }
}
