package pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;


public class FillPdf {



    public static void llenarPdf( EmployeeDataPdf employeeDataPdf ) throws IOException, DocumentException {

        // Abrir el PDF plantilla
        PdfReader reader = new PdfReader("C:\\Users\\desan\\OneDrive\\Documentos\\CartaCampos.pdf");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:\\Users\\desan\\OneDrive\\Documentos\\CartaResponsiva"+employeeDataPdf.getNombreEmpleado()+".pdf"));

        // Obtener el diccionario de campos del PDF
        AcroFields fields = stamper.getAcroFields();


        // Rellenar los campos
        fields.setField("Correo", employeeDataPdf.getCorreo());
        fields.setField("Nombre del empleado", employeeDataPdf.getNombreEmpleado());
        fields.setField("Numero de Empleado", employeeDataPdf.getNumeroEmpleado());
        fields.setField("Departamento", employeeDataPdf.getDepartamento());
        fields.setField("Descripcion del equipo", employeeDataPdf.getDescEquipo());
        fields.setField("Modelo del equipo", employeeDataPdf.getModelEquipo());
        fields.setField("Activo del equipo", employeeDataPdf.getActivoEquipo());
        fields.setField("Numero de serie", employeeDataPdf.getNumSerie());
        fields.setField("Etiqueta del equipo", employeeDataPdf.getEtiquetaEquipo());


        // Cerrar stamper y reader
        stamper.close();
        reader.close();

        // Volver a abrir PDF de salida
        PdfReader reader2 = new PdfReader("C:\\Users\\desan\\OneDrive\\Documentos\\CartaResponsiva"+employeeDataPdf.getNombreEmpleado()+".pdf");
        PdfStamper stamper2 = new PdfStamper(reader2, new FileOutputStream("C:\\Users\\desan\\OneDrive\\Documentos\\CartaResponsivaRellenadaAplanada.pdf"));



        // Aplanar campos
        stamper2.setFormFlattening(true);

        // Cerrar stamper y reader
        stamper2.close();
        reader2.close();

        System.out.println("¡PDF generado con campos aplanados!");

    }



}

