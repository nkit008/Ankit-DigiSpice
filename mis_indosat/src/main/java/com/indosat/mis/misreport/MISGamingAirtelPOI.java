package com.indosat.mis.misreport;



import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import com.indosat.mis.bean.IGamePojo;


@Component
public class MISGamingAirtelPOI {
	private static org.slf4j.Logger logger =LoggerFactory.getLogger(MISGamingAirtelPOI.class); 

	private  void fillReport(Sheet worksheet, int startRowIndex, int startColIndex,List<IGamePojo> bean,XSSFCellStyle my_style){

		try {
			Row rowHeader=null;
			Cell cell=null;
			int rowCount = startRowIndex;	
			int colcount=startColIndex;
			for(IGamePojo data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				cell.setCellValue(data.getDate_time());
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderBottom((short) 1);
				cell.getCellStyle().setBorderRight((short) 1);
				cell.getCellStyle().setBorderTop((short) 1);

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
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			startColIndex=colcount;
			float totalValue=0;
			rowCount++;
			for(IGamePojo data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				float a=0;
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
					
				if(data.getActive_base()==null)
				{
					a=0;
				}
				else
				{
				a=(Float.parseFloat(data.getActive_base()));
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
			for(IGamePojo data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_sub_req_rec()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_sub_req_rec()));
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
			for(IGamePojo data : bean){


				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_sub_req_proc()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_sub_req_proc()));
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
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				float a=0;
				if(data.getTotal_gross_add()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_gross_add()));
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
			for(IGamePojo data : bean){
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
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getNet_add()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getNet_add()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getGross_adds_revenue()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getGross_adds_revenue()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getRenewal_revenue()==null)
				{
					a=0;
				}
				else
				{
				a=(Float.parseFloat(data.getRenewal_revenue()));
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
			for(IGamePojo data : bean){
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
			
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSub_req_rec_2200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_req_rec_2200()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_sub_2200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_sub_2200()));
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
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSub_req_rec_5500()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_req_rec_5500()));
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
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_sub_5500()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_sub_5500()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSub_req_rec_11000()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSub_req_rec_11000()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_sub_11000()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_sub_11000()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_new_users()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_new_users()));
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
			
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getUsers_paid_sms()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUsers_paid_sms()));
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
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_users_sms()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_users_sms()));
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
			

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getUsers_paid_ussd()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUsers_paid_ussd()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				float a=0;
				if(data.getTotal_users_ussd()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_users_ussd()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_ren_2200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_ren_2200()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_ren_5500()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_ren_5500()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_ren_11000()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_ren_11000()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);
				
				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_ren_2200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_ren_2200()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_ren_5500()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_ren_5500()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getSucc_ren_11000()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSucc_ren_11000()));
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

			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getFail_ren_2200()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getFail_ren_2200()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getFail_ren_5500()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getFail_ren_5500()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getFail_ren_11000()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getFail_ren_11000()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_ren_user()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_ren_user()));
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
			
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getTotal_retry_attmpt()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTotal_retry_attmpt()));
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
			
			for(IGamePojo data : bean){
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
			
			for(IGamePojo data : bean){
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
			
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getVoluntary_deactivations()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getVoluntary_deactivations()));
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
			
			for(IGamePojo data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				if(data.getInvoluntary_deactivations()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getInvoluntary_deactivations()));
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
			
			for(IGamePojo data : bean){
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
			
			for(IGamePojo data : bean){
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
			
			for(IGamePojo data : bean){
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



	public  void genrateXLS(InputStream is, int startRowIndex, int startColIndex, HttpServletResponse response, List<IGamePojo> bean,String fromdate,String todate,String service_name) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			
			DataFormat df = workbook.createDataFormat();

			Sheet worksheet = workbook.getSheetAt(0);//workbook.createSheest("Offices");
			
			XSSFCellStyle my_style = workbook.createCellStyle();
			
			 
		    /* Create HSSFFont object from the workbook */
         XSSFFont my_font=workbook.createFont();
         /* set the weight of the font */
         my_font.setBold(true);
         /* attach the font to the style created earlier */
         my_style.setFont(my_font);
         
			CellStyle cs=workbook.createCellStyle();
			
			String header = worksheet.getRow(0).getCell(0).getStringCellValue();
			String excel_frmdate=fromdate.substring(5).substring(3);
			String excel_frmmonth=setMonth(fromdate.substring(5,7));
			String excel_frmyear=fromdate.substring(2,4);
			String excel_todate=todate.substring(5).substring(3);
			String excel_tomonth=setMonth(todate.substring(5,7));
			String excel_toyear=todate.substring(2,4);

			workbook.setSheetName(0, excel_frmdate+" "+excel_frmmonth+" "+excel_frmyear+"-"+excel_todate+" "+excel_tomonth+" "+excel_toyear);
			fillReport(worksheet, startRowIndex, startColIndex, bean,my_style);
			
			
			//Set Response Header
			String month=setMonth(todate.substring(5, 7));

		      response.setHeader("Content-Disposition", "inline; filename=iGameMIS_"+todate.substring(8)+"-"+month+"-"+
		      todate.substring(0, 4)+".xls");
			response.setContentType("application/vnd.ms-excel");
			ServletOutputStream outputStream = response.getOutputStream();
			// Write to the output stream
			worksheet.getWorkbook().write(outputStream);
			// Flush the stream
			outputStream.flush();
			outputStream.close();
			is.close();
			
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