package com.digispice.cci.zambia.mispoi;

import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.digispice.cci.zambia.entity.ZamtelBeatsMISEntity;
import com.digispice.cci.zambia.entity.ZamtelBeatsMISEntity;

@Component
public class ZemtalBeatsPOI {

	private static Logger logger = LoggerFactory.getLogger(ZemtalBeatsPOI.class);

	private void fillReport(Sheet worksheet, int startRowIndex, int startColIndex, List<ZamtelBeatsMISEntity> bean,
			XSSFCellStyle my_style) {

		try {
			
			System.out.println("Size of List<ZamtelBeatsMISEntity> is "+bean.size());
			DecimalFormat df = new DecimalFormat("#.####");
			df.setRoundingMode(RoundingMode.CEILING);

			Row rowHeader = null;
			Cell cell = null;
			int rowCount = startRowIndex;
			int colcount = startColIndex;

			for (ZamtelBeatsMISEntity data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(data.getsDate());

				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);

				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue("Total");
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			float totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (String.valueOf(data.getNON_SUB_VISITOR()) == null) {
					a = 0;
				} else {
					a = data.getNON_SUB_VISITOR();
				}
				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_VISITOR()) == null) {
					a = 0;
				} else {
					a = data.getSUB_VISITOR();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			
			
			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (String.valueOf(data.getTOTAL_VISITOR()) == null) {
					a = 0;
				} else {
					a = data.getTOTAL_VISITOR();
				}
				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNON_SUB_UNIQ_VISITOR()) == null) {
					a = 0;
				} else {
					a = data.getNON_SUB_UNIQ_VISITOR();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);

			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				int a = 0;
				if (String.valueOf(data.getSUB_UNIQ_VISITOR()) == null) {
					a = 0;
				} else {
					a = data.getSUB_UNIQ_VISITOR();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			
			
			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				int a = 0;
				if (String.valueOf(data.getUNIQ_VISITOR()) == null) {
					a = 0;
				} else {
					a = data.getUNIQ_VISITOR();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			
			

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_REG()) == null) {
					a = 0;
				} else {
					a = data.getNEW_REG();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_USER_MIN()) == null) {
					a = 0;
				} else {
					a = data.getSUB_USER_MIN();
				}

				totalValue = totalValue + a;

				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);

				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMONTHLY_SUB_MUSIC()) == null) {
					a = 0;
				} else {
					a = data.getMONTHLY_SUB_MUSIC();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getWEEKLY_SUB_MUSIC()) == null) {
					a = 0;
				} else {
					a = data.getWEEKLY_SUB_MUSIC();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);

			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getDAILY_SUB_MUSIC()) == null) {
					a = 0;
				} else {
					a = data.getDAILY_SUB_MUSIC();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getFREE_TRIAL_MUSIC()) == null) {
					a = 0;
				} else {
					a = data.getFREE_TRIAL_MUSIC();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMONTHLY_SUB_KARAOKE()) == null) {
					a = 0;
				} else {
					a = data.getMONTHLY_SUB_KARAOKE();
				}

				totalValue = totalValue + a;

				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);

			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			
			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getWEEKLY_SUB_KARAOKE()) == null) {
					a = 0;
				} else {
					a = data.getWEEKLY_SUB_KARAOKE();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			
			
			
			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getDAILY_SUB_KARAOKE()) == null) {
					a = 0;
				} else {
					a = data.getDAILY_SUB_KARAOKE();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getFREE_TRIAL_KARAOKE()) == null) {
					a = 0;
				} else {
					a = data.getFREE_TRIAL_KARAOKE();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMONTHLY_SUB_BUNDLE()) == null) {
					a = 0;
				} else {
					a = data.getMONTHLY_SUB_BUNDLE();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getWEEKLY_SUB_BUNDLE()) == null) {
					a = 0;
				} else {
					a = data.getWEEKLY_SUB_BUNDLE();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getDAILY_SUB_BUNDLE()) == null) {
					a = 0;
				} else {
					a = data.getDAILY_SUB_BUNDLE();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getFREE_TRIAL_BUNDLE()) == null) {
					a = 0;
				} else {
					a = data.getFREE_TRIAL_BUNDLE();
				}

				totalValue = totalValue + a;

				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_IVR()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_IVR();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_SMS()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_SMS();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				int a = 0;
				if (String.valueOf(data.getSUB_MODE_WEB()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_WEB();
				}
				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_TPARTY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_TPARTY();
				}
				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_USSD()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_USSD();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_ANDROID()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_ANDROID();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_IPHONE()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_IPHONE();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_APP()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_APP();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MODE_OTHERS()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MODE_OTHERS();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_MUSIC_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_MUSIC_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_MUSIC_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_MUSIC_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_MUSIC_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_MUSIC_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_KARAOKE_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_KARAOKE_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_KARAOKE_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_KARAOKE_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_KARAOKE_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_KARAOKE_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			
			
			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_BUNDLE_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_BUNDLE_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_BUNDLE_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_BUNDLE_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getNEW_SUB_BUNDLE_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getNEW_SUB_BUNDLE_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MUSIC_FAIL_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MUSIC_FAIL_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MUSIC_FAIL_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MUSIC_FAIL_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_MUSIC_FAIL_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_MUSIC_FAIL_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_KARAOKE_FAIL_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_KARAOKE_FAIL_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_KARAOKE_FAIL_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_KARAOKE_FAIL_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_KARAOKE_FAIL_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_KARAOKE_FAIL_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_BUNDLE_FAIL_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_BUNDLE_FAIL_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_BUNDLE_FAIL_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_BUNDLE_FAIL_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getSUB_BUNDLE_FAIL_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getSUB_BUNDLE_FAIL_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getVOL_CHURN()) == null) {
					a = 0;
				} else {
					a = data.getVOL_CHURN();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getINVOL_CHURN()) == null) {
					a = 0;
				} else {
					a = data.getINVOL_CHURN();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_MUSIC_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_MUSIC_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_MUSIC_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_MUSIC_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_MUSIC_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_MUSIC_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_KARAOKE_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_KARAOKE_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_KARAOKE_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_KARAOKE_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_KARAOKE_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_KARAOKE_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_BUNDLE_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_BUNDLE_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_BUNDLE_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_BUNDLE_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getRESUB_BUNDLE_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getRESUB_BUNDLE_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMUSIC_REV_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getMUSIC_REV_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMUSIC_REV_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getMUSIC_REV_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMUSIC_REV_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getMUSIC_REV_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMUSIC_REV_LOCAL()) == null) {
					a = 0;
				} else {
					a = data.getMUSIC_REV_LOCAL();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getMUSIC_REV_USD()) == null) {
					a = 0;
				} else {
					a = data.getMUSIC_REV_USD();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getKARAOKE_REV_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getKARAOKE_REV_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getKARAOKE_REV_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getKARAOKE_REV_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getKARAOKE_REV_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getKARAOKE_REV_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getKARAOKE_REV_LOCAL()) == null) {
					a = 0;
				} else {
					a = data.getKARAOKE_REV_LOCAL();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getKARAOKE_REV_USD()) == null) {
					a = 0;
				} else {
					a = data.getKARAOKE_REV_USD();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getBUNDLE_REV_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getBUNDLE_REV_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getBUNDLE_REV_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getBUNDLE_REV_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getBUNDLE_REV_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getBUNDLE_REV_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getBUNDLE_REV_LOCAL()) == null) {
					a = 0;
				} else {
					a = data.getBUNDLE_REV_LOCAL();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getBUNDLE_REV_USD()) == null) {
					a = 0;
				} else {
					a = data.getBUNDLE_REV_USD();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getTOTAL_REV_LOCAL()) == null) {
					a = 0;
				} else {
					a = data.getTOTAL_REV_LOCAL();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getTOTAL_REV_USD()) == null) {
					a = 0;
				} else {
					a = data.getTOTAL_REV_USD();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getACTIVE_SUB_MONTHLY()) == null) {
					a = 0;
				} else {
					a = data.getACTIVE_SUB_MONTHLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getACTIVE_SUB_WEEKLY()) == null) {
					a = 0;
				} else {
					a = data.getACTIVE_SUB_WEEKLY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getACTIVE_SUB_DAILY()) == null) {
					a = 0;
				} else {
					a = data.getACTIVE_SUB_DAILY();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getACTIVE_SUB_TOTAL()) == null) {
					a = 0;
				} else {
					a = data.getACTIVE_SUB_TOTAL();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getGRACE_1TO7()) == null) {
					a = 0;
				} else {
					a = data.getGRACE_1TO7();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getGRACE_8TO14()) == null) {
					a = 0;
				} else {
					a = data.getGRACE_8TO14();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getGRACE_15TO29()) == null) {
					a = 0;
				} else {
					a = data.getGRACE_15TO29();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getGRACE_30TO44()) == null) {
					a = 0;
				} else {
					a = data.getGRACE_30TO44();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getGRACE_45TO60()) == null) {
					a = 0;
				} else {
					a = data.getGRACE_45TO60();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (ZamtelBeatsMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				int a = 0;
				if (String.valueOf(data.getGRACE_ABOVE60()) == null) {
					a = 0;
				} else {
					a = data.getGRACE_ABOVE60();
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
				cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
				cell.getCellStyle().setBorderRight(BorderStyle.THIN);
				cell.getCellStyle().setBorderTop(BorderStyle.THIN);
				startColIndex++;
			}

			rowHeader = worksheet.getRow((short) rowCount);
			if (rowHeader == null)
				rowHeader = worksheet.createRow((short) rowCount);
			rowHeader.setHeight((short) 270);

			cell = rowHeader.getCell(startColIndex);
			if (cell == null)
				cell = rowHeader.createCell(startColIndex);
			cell.setCellValue(totalValue);
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.THIN);
			cell.getCellStyle().setBorderBottom(BorderStyle.THIN);
			cell.getCellStyle().setBorderRight(BorderStyle.THIN);
			cell.getCellStyle().setBorderTop(BorderStyle.THIN);

		} catch (Exception e) {
			logger.error("Error While Genrating XLSX FIle " + e, e);
		}
	}

	public void genrateZemtalBeatsXLS(InputStream is, int startRowIndex, int startColIndex,
			HttpServletResponse response, List<ZamtelBeatsMISEntity> bean, String fromdate, String todate) {
		XSSFWorkbook workbook = null;
		try {
			
			System.out.println("Size of List<ZamtelBeatsMISEntity> is "+bean.size());

			workbook = new XSSFWorkbook(is);

			Sheet worksheet = workbook.getSheetAt(0);

			XSSFCellStyle my_style = workbook.createCellStyle();

			/* Create HSSFFont object from the workbook */
			XSSFFont my_font = workbook.createFont();

			/* attach the font to the style created earlier */
			my_style.setFont(my_font);

			fillReport(worksheet, startRowIndex, startColIndex, bean, my_style);

			// Set Response Header
			String excel_todate = todate.substring(8).trim();
			String excel_tomonth = setMonth(todate.substring(5, 7));
			String excel_toyear = todate.substring(0, 4);

			response.setHeader("Content-Disposition", "inline; filename=MIS_Zemtal_Beatz_" + excel_todate + "_"
					+ excel_tomonth + "_" + excel_toyear + ".xlsx");
			response.setContentType("application/vnd.ms-excel");

			ServletOutputStream outputStream = response.getOutputStream();

			// Write to the output stream
			worksheet.getWorkbook().write(outputStream);
			// Flush the stream
			outputStream.flush();
		} catch (Exception e) {
			logger.error("Error while executing GenrateXLS FIle" + e, e);
		}

		finally {
			if (workbook != null) {
				try {
					workbook.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String setMonth(String month) {
		if (month.equals("01")) {
			month = "Jan";
			return month;
		} else if (month.equals("02")) {
			month = "Feb";
			return month;
		}

		else if (month.equals("03")) {
			month = "Mar";
			return month;
		} else if (month.equals("04")) {
			month = "Apr";
			return month;
		} else if (month.equals("05")) {
			month = "May";
			return month;
		} else if (month.equals("06")) {
			month = "Jun";
			return month;
		} else if (month.equals("07")) {
			month = "Jul";
			return month;
		} else if (month.equals("08")) {
			month = "Aug";
			return month;
		} else if (month.equals("09")) {
			month = "Sept";
			return month;
		} else if (month.equals("10")) {
			month = "Oct";
			return month;
		} else if (month.equals("11")) {
			month = "Nov";
			return month;
		} else {
			month = "Dec";
			return month;
		}
	}
}