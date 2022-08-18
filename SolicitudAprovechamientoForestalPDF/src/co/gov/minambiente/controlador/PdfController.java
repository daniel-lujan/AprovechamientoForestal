/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.minambiente.controlador;

import co.gov.minambiente.modelo.CategoryAModel;
import co.gov.minambiente.modelo.CategoryBModel;
import co.gov.minambiente.modelo.CategoryCModel;
import co.gov.minambiente.modelo.CategoryDModel;
import co.gov.minambiente.modelo.CategoryModel;
import co.gov.minambiente.modelo.RequestModel;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import static com.itextpdf.kernel.pdf.PdfName.Page;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
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
    public static Color blueBg = new DeviceRgb(152, 228, 235);

    public static void fillDocument(PdfWorkspace generatedDoc, RequestModel solicitude) throws MalformedURLException, IOException {

        int lineCounter = drawPage1(generatedDoc, solicitude);
        lineCounter = drawPage2(lineCounter, generatedDoc, solicitude);
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
            //q.setMarginLeft(-5);
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
            //r.setMarginLeft(-5);
            r.setMarginRight(-5);
            r.setPaddingLeft(5);
            r.setPaddingTop(5);
            r.setRelativePosition(0, -54, 0, 0);
            generatedDoc.empujarParrafo(r);

        } catch (IOException ex) {
            System.out.println("Error de entrada y salida de datos" + espacio + ex);
        }
        generatedDoc.pasarPagina(1);
        return lineCounter;
    }

    public static int drawPage2(int lineCounter, PdfWorkspace generatedDoc, RequestModel solicitude) {

        try {
            addHeader(generatedDoc, texts);
            Paragraph p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);

            lineCounter = addTitleLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter, 8);
            lineCounter = addBodyLine(p, generatedDoc, lineCounter);
            setUpParagraph(p, generatedDoc, 9);

            lineCounter = addSingleTitle(generatedDoc, lineCounter, grayBg, 18);
            p = generatedDoc.nuevoParrafo(new Text(""), titleFont, lineCounter);
            lineCounter = addTitleLine(p, generatedDoc, lineCounter);

            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getName(),
                    solicitude.getProperties().get(0).getSurface() + "\n");
            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getAdress().getStreet());

            lineCounter = addBodyLine(p, generatedDoc, lineCounter);

            lineCounter = addBodyLine(p, generatedDoc, lineCounter,
                    solicitude.getProperties().get(0).getAdress().getDepartment(),
                    solicitude.getProperties().get(0).getAdress().getMunicipality(),
                    solicitude.getProperties().get(0).getAdress().getSidewalk() + "\n");

           /* if (!solicitude.getProperties().get(0).getRealEstateRegistration().equals(null)) {
                lineCounter = addBodyLine(p, generatedDoc,
                        lineCounter, solicitude.getProperties().get(0).getRealEstateRegistration() + "\n");
            } else {
                lineCounter += 2;
                lineCounter = addBodyLine(p, generatedDoc,
                        lineCounter, solicitude.getProperties().get(0).getCadastralIdNumber() + "\n");
            }
           // lineCounter = addTitleLine(p,generatedDoc,lineCounter,8);
*/
            setUpParagraph(p, generatedDoc, 27);

        } catch (IOException ex) {
            Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lineCounter;
    }

    /**
     *
     * @param p
     * @param generatedDoc
     * @param relativePosition
     */
    public static void setUpParagraph(Paragraph p, PdfWorkspace generatedDoc, int relativePosition) {
        p.setFixedLeading(20);
        p.setBorder(new SolidBorder(0.75f));
        p.setMarginRight(-5);
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
    public static void generateCheckBoxes(PdfWorkspace generatedDoc, Color color) {

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
        generatedDoc.createRectangle(color, 88, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 159, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 226, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 296, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 371, y - 180, 18, 10);
        generatedDoc.createRectangle(color, 459, y - 180, 18, 10);
        //sixth
        generatedDoc.createRectangle(color, 126, y - 200, 18, 10);
        generatedDoc.createRectangle(color, 239, y - 200, 18, 10);
        generatedDoc.createRectangle(color, 289, y - 200, 18, 10);
        //Seventh
        generatedDoc.createRectangle(color, 146, y - 240, 18, 10);
        generatedDoc.createRectangle(color, 216, y - 240, 18, 10);
        generatedDoc.createRectangle(color, 279, y - 240, 18, 10);
        //Eight
        generatedDoc.createRectangle(color, 157, y - 483, 18, 10);
        generatedDoc.createRectangle(color, 210, y - 483, 18, 10);
        generatedDoc.createRectangle(color, 295, y - 483, 18, 10);
        generatedDoc.createRectangle(color, 405, y - 483, 18, 10);
        //ninth
        generatedDoc.createRectangle(color, 265, y - 503, 18, 10);
        //Tenth
        generatedDoc.createRectangle(color, 183, y - 563, 18, 10);
        //Eleventh
        generatedDoc.createRectangle(color, 295, y - 583, 18, 10);
        generatedDoc.createRectangle(color, 351, y - 583, 18, 10);
        generatedDoc.createRectangle(color, 426, y - 583, 18, 10);
        generatedDoc.createRectangle(color, 562, y - 583, 18, 10);
        //Twelft
        generatedDoc.createRectangle(color, 295, y - 623, 18, 10);
        generatedDoc.createRectangle(color, 371, y - 623, 18, 10);
        //Thirteenth
        generatedDoc.createRectangle(color, 295, y - 623, 18, 10);
        generatedDoc.createRectangle(color, 371, y - 623, 18, 10);
        //Fourtheenth
        generatedDoc.createRectangle(color, 94, y - 745, 18, 10);
        generatedDoc.createRectangle(color, 176, y - 745, 18, 10);
        generatedDoc.createRectangle(color, 252, y - 745, 18, 10);

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
        //title.setMarginLeft(-5);
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
