package com.shamsi.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.shamsi.flightreservation.entities.Reservation;

@Component 

public class PDFGenerator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGenerator.class);
	
	public void generateItinerary(Reservation reservation, String filePath ) {
		LOGGER.info("Inside generateItinerary()");
		Document document = new Document();
	try {
		PdfWriter.getInstance(document, new FileOutputStream(filePath));
		document.open();
		document.add(generateTable(reservation));
		document.close();
	} catch (FileNotFoundException | DocumentException e) {
		LOGGER.error("Error Inside generateItinerary() :"+e);
	}
	}
	
	private PdfPTable generateTable(Reservation reservation) {
		LOGGER.info("Inside generateTable()");
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		cell=new PdfPCell(new Phrase("Flight Itinenary"));
		cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
		cell.setColspan(2);
		table.addCell(cell);
		
		cell=new PdfPCell(new Phrase("Flight Details"));
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Airlines");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("Departure City");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Date of Departure");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Departure Time");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		cell=new PdfPCell(new Phrase("Passenger Details"));
		cell.setBackgroundColor(BaseColor.GRAY);
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First Name");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getPassenger().getFirstName());
		
		table.addCell("Last Name");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getPassenger().getLastName());
		
		table.addCell("Email");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getPassenger().getEmail());
		
		table.addCell("Phone");
		cell.setBackgroundColor(BaseColor.WHITE);
		table.addCell(reservation.getPassenger().getPhone());
		LOGGER.info("the table is created successfully");
		
		return table;
	}
	
	
}
