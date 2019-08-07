package relatorio;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PrinterName;

import auxiliar.Dut;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.print.JRPrinterAWT;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {
	
	public void geraRelatorio(List<Dut> lista) throws JRException {
		InputStream fonte = Relatorio.class.getResourceAsStream("/report/report1.jrxml");
		JasperReport report = JasperCompileManager.compileReport(fonte);
		
		JasperPrint print = JasperFillManager.fillReport(report, null , new JRBeanCollectionDataSource(lista));
		
	
		
		//JasperViewer.viewReport(print,false);	
		
		
		JasperViewer viewer = new JasperViewer( print , false );
		viewer.show();
		
		
		/*/ xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx testeando impressora direto xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		
		String impressoraSelecionada = "Brother MFC-L6900DW series";
		
		PrintService[] servicos = PrintServiceLookup.lookupPrintServices(null, null);
		PrintService psSelected = null;
		for(PrintService ps : servicos) {
			if(ps.getName().equals(impressoraSelecionada)) {
				psSelected = ps;
				break;
			}
		}
		if(psSelected!= null) {
			PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
			PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
			printServiceAttributeSet.add(new PrinterName(impressoraSelecionada, null));
			printRequestAttributeSet.add(new Copies(1));
			JRPrintServiceExporter exporter = new JRPrintServiceExporter();
			exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, psSelected);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, 	printRequestAttributeSet);
			exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,  printServiceAttributeSet);
			exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,  Boolean.FALSE);
			exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
			exporter.exportReport();
		}*/
		/* +++++++++++++++++++++++++++++++++++++++++++++++++++ testandoo novo metodo +++++++++++++++++++++++++
		
		
		private void printDirectlyToPrinter(String printerName,JasperPrint jasperPrint)
		{	
			try {
				//Lista todas impressoras até encontrar a enviada por parametro
				PrintService serviceFound = null;
				PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
				for(PrintService service:services){
					if(service.getName().trim().equals(printerName.trim()))
						serviceFound = service;
				}
				
				if (serviceFound == null)
					throw new NegocioException("Impressora não encontrada !");
				
				JRExporter exporter = new JRPrintServiceExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, serviceFound.getAttributes());
				exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
				exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
				exporter.exportReport();
				
				//JasperPrintManager.printPage(jasperPrint, 0, false);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}

}
