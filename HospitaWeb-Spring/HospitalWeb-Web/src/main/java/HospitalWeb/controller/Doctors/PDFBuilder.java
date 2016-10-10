/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.controller.Doctors;
import HospitalWeb.domain.Prescriptiondeteil;
import HospitalWeb.domain.Reception;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author Жека
 */
public class PDFBuilder extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container

        List<Prescriptiondeteil> prescriptionDeteil = 
                (List<Prescriptiondeteil>) model.get("prescriptionDeteil");
        Reception reception = prescriptionDeteil.get(0).
                getIdprescription().getIdreception();
        doc.add(new Paragraph("Номер пациента: " + 
                reception.getIdCard().getNumber()));
        doc.add(new Paragraph("Лечащий врач: " + 
                reception.getIdUsers().getName() + " " +
                reception.getIdUsers().getSnme()));
        doc.add(new Paragraph("Список выписаных препаратов"));
         
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {3.0f, 2.0f, 2.0f});
        table.setSpacingBefore(10);
         
        // define font for table header row
        Font font = FontFactory.getFont("c:\\Windows\\Fonts\\tahoma.ttf","cp1251",true);
        
        font.setColor(BaseColor.WHITE);
         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(3);
         
        // write table header
        cell.setPhrase(new Phrase("Название", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Описание", font));
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Употребление", font));
        table.addCell(cell);
         cell.setBackgroundColor(BaseColor.WHITE);
         font.setColor(BaseColor.BLACK);
         ///write table row data
        for (Prescriptiondeteil prescription: prescriptionDeteil) {
            cell.setPhrase(new Phrase(
                    prescription.getIdmedication().getTradename(), 
                    font));
            table.addCell(cell);
             cell.setPhrase(new Phrase(
                    prescription.getIdmedication().getConditionsofsupply(), 
                    font));
            table.addCell(cell);
             cell.setPhrase(new Phrase(
                    prescription.getIndicationsforuse(), 
                    font));
            table.addCell(cell);
//            table.addCell(prescription.getIdmedication().getTradename());
//            table.addCell(prescription.getIdmedication().getConditionsofsupply());
//            table.addCell(prescription.getIndicationsforuse());
        }
         
        doc.add(table);
        doc.close();
         
    }
 
}
