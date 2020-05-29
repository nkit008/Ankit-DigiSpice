package com.spice.reminderservice.poi;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.spice.reminderservice.bean.ReminderServiceBean;


@Component
public class MisReminderServicePoi {
	private static org.slf4j.Logger logger =LoggerFactory.getLogger(MisReminderServicePoi.class); 

	private  void fillReport(Sheet worksheet, int startRowIndex, int startColIndex,List<ReminderServiceBean> bean,CellStyle style, DataFormat format){

		try {
			Row rowHeader=null;
			Cell cell=null;
			int rowCount = startRowIndex;	
			int colcount=startColIndex;

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				cell.setCellValue(data.getDate());
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
			cell.setCellValue("Total");
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);
			//cell.getCellStyle().setBorderRight((short) 1);
			startColIndex=colcount;
			long totalValue=0;
			float totalValue1=0;
			rowCount++;
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_hits();
				cell.setCellValue(data.getTotal_hits());
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
			totalValue1=0;
			rowCount++;
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getHits_live_call();
				cell.setCellValue(data.getHits_live_call());
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
			totalValue1=0;
			rowCount++;
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getHits_nonlive_call();
				cell.setCellValue(data.getHits_nonlive_call());
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
			totalValue1=0;
			rowCount++;
			
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_session();
				cell.setCellValue(data.getTotal_session());
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
			
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getSession_live_call();
				cell.setCellValue(data.getSession_live_call());
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
			
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getSession_nonlive_call();
				cell.setCellValue(data.getSession_nonlive_call());
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
			
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_uniq_call();
				cell.setCellValue(data.getTotal_uniq_call());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUniq_live_call();
				cell.setCellValue(data.getUniq_live_call());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUniq_nonlive_call();
				cell.setCellValue(data.getUniq_nonlive_call());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUniq_call_mtd();
				cell.setCellValue(data.getUniq_call_mtd());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUniq_live_call_mtd();
				cell.setCellValue(data.getUniq_live_call_mtd());
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
			rowCount++;
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getObd_sub_req_10();
				cell.setCellValue(data.getObd_sub_req_10());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getObd_sub_req_5();
				cell.setCellValue(data.getObd_sub_req_5());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getObd_sub_req_2();
				cell.setCellValue(data.getObd_sub_req_2());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getObd_succ_sub_10();
				cell.setCellValue(data.getObd_succ_sub_10());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getObd_succ_sub_5();
				cell.setCellValue(data.getObd_succ_sub_5());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getObd_succ_sub_2();
				cell.setCellValue(data.getObd_succ_sub_2());
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
			rowCount++;
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUssd_sub_req_10();
				cell.setCellValue(data.getUssd_sub_req_10());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUssd_sub_req_5();
				cell.setCellValue(data.getUssd_sub_req_5());
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
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUssd_sub_req_2();
				cell.setCellValue(data.getUssd_sub_req_2());
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
			
			
			/*sds*/
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUssd_succ_sub_10();
				cell.setCellValue(data.getUssd_succ_sub_10());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUssd_succ_sub_5();
				cell.setCellValue(data.getUssd_succ_sub_5());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUssd_succ_sub_2();
				cell.setCellValue(data.getUssd_succ_sub_2());
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
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_retry_10();
				cell.setCellValue(data.getTotal_sub_retry_10());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_retry_5();
				cell.setCellValue(data.getTotal_sub_retry_5());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_retry_2();
				cell.setCellValue(data.getTotal_sub_retry_2());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_retry_succ_10();
				cell.setCellValue(data.getTotal_retry_succ_10());
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
			


			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_retry_succ_5();
				cell.setCellValue(data.getTotal_retry_succ_5());
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
			
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_retry_succ_2();
				cell.setCellValue(data.getTotal_retry_succ_2());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_retry_succ();
				cell.setCellValue(data.getTotal_retry_succ());
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
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_req_10();
				cell.setCellValue(data.getTotal_sub_req_10());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_req_5();
				cell.setCellValue(data.getTotal_sub_req_5());
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
			
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_req_2();
				cell.setCellValue(data.getTotal_sub_req_2());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_succ_10();
				cell.setCellValue(data.getTotal_sub_succ_10());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_succ_5();
				cell.setCellValue(data.getTotal_sub_succ_5());
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
			
	
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_succ_2();
				cell.setCellValue(data.getTotal_sub_succ_2());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_succ();
				cell.setCellValue(data.getTotal_sub_succ());
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
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenew_req_10();
				cell.setCellValue(data.getRenew_req_10());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenew_req_5();
				cell.setCellValue(data.getRenew_req_5());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenew_req_2();
				cell.setCellValue(data.getRenew_req_2());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenew_succ_10();
				cell.setCellValue(data.getRenew_succ_10());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenew_succ_5();
				cell.setCellValue(data.getRenew_succ_5());
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
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenew_succ_2();
				cell.setCellValue(data.getRenew_succ_2());
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
			rowCount++;
			
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getCci_churn()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getCci_churn());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getUssd_churn()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getUssd_churn());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getOthers_churn()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getOthers_churn());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			
			/*sds*/
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getVoluntary_churn()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getVoluntary_churn());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getInvoluntary_churn()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getInvoluntary_churn());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getTotal_churn()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getTotal_churn());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_reminder();
				cell.setCellValue(data.getTotal_reminder());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getUniq_reminder();
				cell.setCellValue(data.getUniq_reminder());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getNo_of_reminder_set();
				cell.setCellValue(data.getNo_of_reminder_set());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getNo_of_greetings_send_to_user();
				cell.setCellValue(data.getNo_of_greetings_send_to_user());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getReminder_per_user();
				cell.setCellValue(data.getReminder_per_user());
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
			totalValue1=0;
			rowCount++;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getSub_revenue_10();
				cell.setCellValue(data.getSub_revenue_10());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getSub_revenue_5();
				cell.setCellValue(data.getSub_revenue_5());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getSub_revenue_2();
				cell.setCellValue(data.getSub_revenue_2());
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
			totalValue1=0;
			rowCount++;
			


			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_sub_revenue();
				cell.setCellValue(data.getTotal_sub_revenue());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenewal_revenue_10();
				cell.setCellValue(data.getRenewal_revenue_10());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenewal_revenue_5();
				cell.setCellValue(data.getRenewal_revenue_5());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getRenewal_revenue_2();
				cell.setCellValue(data.getRenewal_revenue_2());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_renewal_revenue();
				cell.setCellValue(data.getTotal_renewal_revenue());
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
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				totalValue=totalValue+data.getTotal_revenue();
				cell.setCellValue(data.getTotal_revenue());
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
			totalValue1=0;
			rowCount++;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getNet_addition()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getNet_addition());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			
			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getActive_base()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getActive_base());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);


			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			
			/*sds*/
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getGrace_base()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getGrace_base());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			
			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			


			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getRetry_base()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getRetry_base());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			rowCount++;
			


			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getArpu()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getArpu());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);
				
				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				
				a=(Float.parseFloat(data.getHits_per_uniq_user()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getHits_per_uniq_user());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getHits_per_uniq_live_user()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getHits_per_uniq_live_user());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				float a=0;
				a=(Float.parseFloat(data.getSession_per_uniq_user()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getSession_per_uniq_user());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

			startColIndex=colcount;
			totalValue=0;
			totalValue1=0;
			rowCount++;
			

			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				float a=0;
				a=(Float.parseFloat(data.getSession_per_uniq_live_user()));
				totalValue1=totalValue1+a;
				cell.setCellValue(data.getSession_per_uniq_live_user());
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
			cell.setCellValue(totalValue1);
			cell.getCellStyle().setBorderBottom((short) 1);
			cell.getCellStyle().setBorderTop((short) 1);
			cell.getCellStyle().setBorderRight((short) 1);
			cell.getCellStyle().setBorderLeft((short) 1);

/*			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(ReminderServiceBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				int a=0;
				a=(Integer.parseInt(data.getSession_per_call()));
				totalValue=totalValue+a;
				cell.setCellValue(data.getSession_per_call());
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
			cell.getCellStyle().setBorderLeft((short) 1);*/
		} 
		catch (Exception e) {
			logger.error("Error While Genrating XLSX FIle "+e,e);
		}
	}



	public  void genrateXLS(InputStream is, int startRowIndex, int startColIndex, HttpServletResponse response, List<ReminderServiceBean> bean,String fromdate,String todate) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);

			Sheet worksheet = workbook.getSheetAt(0);//workbook.createSheet("Offices");
			String header = worksheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println(fromdate);
			String excel_frmdate=fromdate.substring(5).substring(3);
			String excel_frmmonth=setMonth(fromdate.substring(5,7));
			String excel_frmyear=fromdate.substring(2,4);
			String excel_todate=todate.substring(5).substring(3);
			String excel_tomonth=setMonth(todate.substring(5,7));
			String excel_toyear=todate.substring(2,4);
			CellStyle style;
			style=workbook.createCellStyle();
			DataFormat format = workbook.createDataFormat();
			
			workbook.setSheetName(0, excel_frmdate+" "+excel_frmmonth+" "+excel_frmyear+"-"+excel_todate+" "+excel_tomonth+" "+excel_toyear);
			fillReport(worksheet, startRowIndex, startColIndex, bean,style,format);
			//Set Response Header
			ServletOutputStream outputStream = response.getOutputStream();
			response.reset();
			
			response.setHeader("Content-Disposition", "inline; filename=" + "Mis_ReminderService.xlsx");
			// Write to the output stream
			response.setContentType("application/vnd.ms-excel");
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