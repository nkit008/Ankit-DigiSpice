package com.spice.misreport;



import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import com.spice.bean.MisGamingAirtel;
import com.spice.bean.MisGamingAirtel;


@Component
public class MISGamingAirtelPOI {
	private static org.slf4j.Logger logger =LoggerFactory.getLogger(MISGamingAirtelPOI.class); 

	private  void fillReport(Sheet worksheet, int startRowIndex, int startColIndex,List<MisGamingAirtel> bean){

		try {
			Row rowHeader=null;
			Cell cell=null;
			int rowCount = startRowIndex;	
			int colcount=startColIndex;
			for(MisGamingAirtel data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				cell.setCellValue(data.getDate_time());
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}

			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue("Total");
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			//cell.getCellStyle().setBorderRight((short) 1);
			startColIndex=colcount;
			float totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				float a=0;
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
					
				if(data.getSub_req_200()==null)
				{
					a=0;
				}
				else
				{
				a=(Float.parseFloat(data.getSub_req_200()));
				}
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSub_succ_200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_succ_200()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSub_req_700()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_req_700()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				float a=0;
				if(data.getSub_succ_700()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_succ_700()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSub_req_2800()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_req_2800()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSub_succ_2800()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_succ_2800()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_new_user()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_new_user()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSms_user()==null)
				{
					a=0;
				}
				else
				{
				a=(Float.parseFloat(data.getSms_user()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_sms_user()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_sms_user()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getUssd_user()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUssd_user()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_ussd_user()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_ussd_user()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getVoluntary_churn()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getVoluntary_churn()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getInvoluntary_churn()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getInvoluntary_churn()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSms_churn()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSms_churn()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getUssd_churn()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUssd_churn()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_churn()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_churn()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			rowCount++;
			
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_renewal_200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_renewal_200()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_renewal_700()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_renewal_700()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_renewal_2800()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_renewal_2800()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				float a=0;
				if(data.getSucc_renewal_200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_renewal_200()));
				}

				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_renewal_700()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_renewal_700()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_renewal_2800()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_renewal_2800()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getFail_renewal_200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getFail_renewal_200()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);
				
				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getFail_renewal_700()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getFail_renewal_700()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getFail_renewal_2800()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getFail_renewal_2800()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_succ_renewal_users()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_succ_renewal_users()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);

				startColIndex++;
			}
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_sub_revenue()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_sub_revenue()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);			
		
		
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_resub_revenue()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_resub_revenue()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getGrand_total()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getGrand_total()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
		
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_retry_req()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_retry_req()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_retry_succ()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_retry_succ()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_retry_fail()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_retry_fail()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getPpu_req()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getPpu_req()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getPpu_succ()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getPpu_succ()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getPpu_fail()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getPpu_fail()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getDownload_req()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getDownload_req()));
				}
				
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getDownload_succ()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getDownload_succ()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getDownload_fail()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getDownload_fail()));
				}

				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			rowCount++;

			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getPage_view()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getPage_view()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getUnique_visitor()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUnique_visitor()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisGamingAirtel data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_visitor()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_visitor()));
				}
				
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderLeft((short) 1);
				//cell.getCellStyle().setBorderRight((short) 1);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			
		
		
		}
		
		
		
		catch (Exception e) {
			logger.error("Error While Genrating XLSX FIle "+e,e);
		}
	}



	public  void genrateXLS(InputStream is, int startRowIndex, int startColIndex, HttpServletResponse response, List<MisGamingAirtel> bean,String fromdate,String todate,String service_name) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			
			DataFormat df = workbook.createDataFormat();

			Sheet worksheet = workbook.getSheetAt(0);//workbook.createSheest("Offices");
			
			CellStyle cs=workbook.createCellStyle();
			
			String header = worksheet.getRow(0).getCell(0).getStringCellValue();
			String excel_frmdate=fromdate.substring(5).substring(3);
			String excel_frmmonth=setMonth(fromdate.substring(5,7));
			String excel_frmyear=fromdate.substring(2,4);
			String excel_todate=todate.substring(5).substring(3);
			String excel_tomonth=setMonth(todate.substring(5,7));
			String excel_toyear=todate.substring(2,4);

			workbook.setSheetName(0, excel_frmdate+" "+excel_frmmonth+" "+excel_frmyear+"-"+excel_todate+" "+excel_tomonth+" "+excel_toyear);
			fillReport(worksheet, startRowIndex, startColIndex, bean);
			
			//Set Response Header
			response.setHeader("Content-Disposition", "inline; filename="+service_name+"_MIS_Airtel.xlsx");
			response.setContentType("application/vnd.ms-excel");
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			worksheet.getWorkbook().write(outputStream);
			// Flush the stream
			outputStream.flush();
		} catch (Exception e) {
			logger.error("Error while executing GenrateXLS FIle"+e, e);
		}
	}
	
	
	
	public String setMonth(String month)
	{
		if(month.equals("01"))
		{
			month="Jan";
			return month;
		}
		else if(month.equals("02"))
		{
			month="Feb";
			return month;
		}
		
		else if(month.equals("03"))
		{
			month="Mar";
			return month;
		}
		else if(month.equals("04"))
		{
			month="Apr";
			return month;
		}
		else if(month.equals("05"))
		{
			month="May";
			return month;
		}
		else if(month.equals("06"))
		{
			month="Jun";
			return month;
		}
		else if(month.equals("07"))
		{
			month="Jul";
			return month;
		}
		else if(month.equals("08"))
		{
			month="Aug";
			return month;
		}
		else if(month.equals("09"))
		{
			month="Sept";
			return month;
		}
		else if(month.equals("10"))
		{
			month="Oct";
			return month;
		}
		else if(month.equals("11"))
		{
			month="Nov";
			return month;
		}
		else
		{
			month="Dec";
			return month;
		}
	}
}