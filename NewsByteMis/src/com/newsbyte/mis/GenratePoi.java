package com.newsbyte.mis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class GenratePoi {
	
	private static Logger logger =Logger.getLogger(GenratePoi.class);
	
	private  void fillReport(Sheet worksheet, int startRowIndex, int startColIndex,List<MisBean> bean,XSSFCellStyle my_style,XSSFCellStyle my_style1){

		try {
			Row rowHeader=null;
			Cell cell=null;
			int rowCount = startRowIndex;	
			int colcount=startColIndex;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				cell.setCellValue(data.getDATE_TIME());
				cell.setCellStyle(my_style1);

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
			cell.setCellStyle(my_style1);
			
			startColIndex=colcount;
			float totalValue=0;
			rowCount++;

			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				
				float a=0;
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				if(data.getTOTAL_CALLS()==null)
				{
					a=0;
				}
				else
				{
				a=(Float.parseFloat(data.getTOTAL_CALLS()));
				}
				totalValue=totalValue+a;
				cell.setCellValue(a);
			
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getSUBS_USERS_CALLS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSUBS_USERS_CALLS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			

			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getNON_SUBS_USERS_CALLS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getNON_SUBS_USERS_CALLS()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getTOTAL_MOUS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTOTAL_MOUS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getSUBS_USERS_MOU()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSUBS_USERS_MOU()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			
			

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getNON_SUBS_USERS_MOU()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getNON_SUBS_USERS_MOU()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getTOTAL_PULSES()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTOTAL_PULSES()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getSUBS_USERS_PULSES()==null)
				{
					a=0;
				}
				else
				{
				a=(Float.parseFloat(data.getSUBS_USERS_PULSES()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getNON_SUBS_USERS_PULSES()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getNON_SUBS_USERS_PULSES()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getTOTAL_UNIQUE_CALLERS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getTOTAL_UNIQUE_CALLERS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getUNIQUE_SUBS_CALLERS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUNIQUE_SUBS_CALLERS()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			
			

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getUNIQUE_NON_SUBS_CALLERS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUNIQUE_NON_SUBS_CALLERS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				
				
				

				startColIndex++;
			}
			
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getUNIQUE_CALLERS_TILL_DATE()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUNIQUE_CALLERS_TILL_DATE()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCC_DAILY_PACK()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCC_DAILY_PACK()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			
			

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCC_VOLUNTARY_UNSUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCC_VOLUNTARY_UNSUBS()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				
				
				
				
				//

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			
			
			

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCC_INVOLUNTARY_UNSUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCC_INVOLUNTARY_UNSUBS()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCC_GROSS_ADDS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCC_GROSS_ADDS()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCC_DAILY_RE_PACK()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCC_DAILY_RE_PACK()));
				}
				
				totalValue=totalValue+a;
				
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getIVR_SUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getIVR_SUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCCI_SUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCCI_SUBS()));
				}

				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getOBD_SUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getOBD_SUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getSMS_SUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSMS_SUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
			
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getIBD_SUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getIBD_SUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);
				
				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getUSSD_SUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUSSD_SUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);

				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getOTHERS_SUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getOTHERS_SUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
			}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getIVR_UNSUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getIVR_UNSUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
			}
			
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;

			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCCI_UNSUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCCI_UNSUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getSMS_UNSUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getSMS_UNSUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getUSSD_UNSUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getUSSD_UNSUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getOTHERS_UNSUBS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getOTHERS_UNSUBS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getDAILY_REVENUE_CC()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getDAILY_REVENUE_CC()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getGROSS_REVENUE_LOCAL()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getGROSS_REVENUE_LOCAL()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getGROSS_REVENUE_USD()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getGROSS_REVENUE_USD()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;


			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getACTIVE_SUBSCRIBER()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getACTIVE_SUBSCRIBER()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getBILLED_SUBSCRIBERS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getBILLED_SUBSCRIBERS()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);
			
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getCALLING_SUBSCRIBERS()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getCALLING_SUBSCRIBERS()));
				}
				
				
				totalValue=totalValue+a;
				cell.setCellValue(a);

				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);

			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getAVG_CALL_UNIQUE()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getAVG_CALL_UNIQUE()));
				}
				
				totalValue=totalValue+a;
				cell.setCellValue(a);

				
				startColIndex++;
		}
			
			rowHeader = worksheet.getRow((short)rowCount);
			if(rowHeader==null)
				rowHeader= worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if(cell==null)
				cell=rowHeader.createCell(startColIndex);
			
			cell.setCellStyle(my_style);
			cell.setCellValue(totalValue);
			
			startColIndex=colcount;
			totalValue=0;
			rowCount++;
			
			for(MisBean data : bean){
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				float a=0;
				if(data.getAVG_MOU_UNIQUE()==null)
				{
					a=0;
				}
				else
				{
					a=(Float.parseFloat(data.getAVG_MOU_UNIQUE()));
				}

				
				totalValue=totalValue+a;
				cell.setCellValue(a);
				
				startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getAVG_MOU_CALL()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getAVG_MOU_CALL()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					startColIndex++;
				}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getUNIQUE_CALLER_ACTIVE()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getUNIQUE_CALLER_ACTIVE()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getSERVICE_PENETRATION()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getSERVICE_PENETRATION()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getARPU()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getARPU()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getGRACE1TO7()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getGRACE1TO7()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getGRACE8TO14()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getGRACE8TO14()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getGRACE15TO21()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getGRACE15TO21()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getGRACE22TO30()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getGRACE22TO30()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN1()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN1()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN2()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN2()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN3()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN3()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN4()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN4()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN5()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN5()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN6()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN6() ));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN7()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN7()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN8()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN8()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN9()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN9()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);

					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN10()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN10()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getMIN10ABOVE()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getMIN10ABOVE()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR0()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR0()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR1()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR1()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR2()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR2()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR3()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR3()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR4()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR4()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR5()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR5()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);

				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR6()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR6()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR7()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR7()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR8()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR8()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR9()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR9()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR10()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR10()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR11()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR11()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR12()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR12()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR13()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR13()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR14()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR14()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR15()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR15()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR16()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR16()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR17()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR17()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR18()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR18()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR19()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR19()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR20()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR20()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR21()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR21()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR22()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR22()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
				startColIndex=colcount;
				totalValue=0;
				rowCount++;
				
				
				for(MisBean data : bean){
					rowHeader = worksheet.getRow((short)rowCount);
					if(rowHeader==null)
						rowHeader= worksheet.createRow((short) rowCount);
					rowHeader.setHeight((short) 270);

					cell = rowHeader.getCell(startColIndex);
					if(cell==null)
						cell=rowHeader.createCell(startColIndex);
					
					cell.setCellStyle(my_style);
					float a=0;
					if(data.getHR23()==null)
					{
						a=0;
					}
					else
					{
						a=(Float.parseFloat(data.getHR23()));
					}
					
					totalValue=totalValue+a;
					cell.setCellValue(a);
					
					startColIndex++;
			}
				
				rowHeader = worksheet.getRow((short)rowCount);
				if(rowHeader==null)
					rowHeader= worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if(cell==null)
					cell=rowHeader.createCell(startColIndex);
				
				cell.setCellStyle(my_style);
				cell.setCellValue(totalValue);
				
		}
		
		
		catch (Exception e) {
			logger.error("Error While Genrating XLSX FIle "+e,e);
		}
	}



	public void genrateXLS(int startRowIndex, int startColIndex, List<MisBean> bean,String fromdate,String todate) {
		
		XSSFWorkbook workbook=null;
		FileOutputStream io=null;
		
		try {
			
			Properties prop=new Properties();
			InputStream is1=new FileInputStream("db.properties");
			prop.load(is1);
			
			String s_file=prop.getProperty("source");
			String d_file=prop.getProperty("destination");
			String month=setMonth(todate.substring(4, 6));
			
			File source =new File(s_file);
			File dest=new File(d_file+todate.substring(6)+"-"+month+"-"+todate.substring(0, 4)+".xlsx");
			
			Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			FileInputStream file = new FileInputStream(dest); 
			
			workbook = new XSSFWorkbook(file);
			
			System.out.println(workbook.getSheetName(0));
			XSSFSheet worksheet = workbook.getSheetAt(0);//workbook.createSheest("Offices");
			
			XSSFCellStyle my_style = workbook.createCellStyle();
			XSSFCellStyle my_style1 = workbook.createCellStyle();
			io=new FileOutputStream(dest);
			
			
			 
		    /* Create HSSFFont object from the workbook */
         XSSFFont my_font=workbook.createFont();
         XSSFFont my_font1=workbook.createFont();
         /* set the weight of the font */
         my_font1.setBold(true);
         /* attach the font to the style created earlier */
         my_style1.setFont(my_font1);
   
         
         my_style.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
         my_style.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
         my_style.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
         my_style.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
         
         my_style.setAlignment(CellStyle.ALIGN_CENTER);
         my_style1.setAlignment(CellStyle.ALIGN_CENTER);
         
         	String excel_frmdate=fromdate.substring(6).trim();
			String excel_frmmonth=setMonth(fromdate.substring(4,6));
			String excel_frmyear=fromdate.substring(0,4);
			String excel_todate=todate.substring(6).trim();
			String excel_tomonth=setMonth(todate.substring(4,6));
			String excel_toyear=todate.substring(0,4);

			
			workbook.setSheetName(0, excel_frmdate+" "+excel_frmmonth+" "+excel_frmyear+"-"+excel_todate+" "+excel_tomonth+" "+excel_toyear);
			fillReport(worksheet, startRowIndex, startColIndex, bean,my_style,my_style1);
			
			
			//Set Response Header
			

		    // Write to the output stream
			workbook.write(io);
			// Flush the stream
			io.close();
			
		} catch (Exception e) {
			logger.error("Error while executing GenrateXLS FIle"+e, e);
		}
		
		finally
		{
			logger.info("Closing connection");
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				io.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
