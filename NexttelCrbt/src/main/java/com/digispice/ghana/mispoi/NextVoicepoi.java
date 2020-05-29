package com.digispice.ghana.mispoi;

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

import com.digispice.ghana.bean.NextVoiceMISEntity;

@Component
public class NextVoicepoi {

	private static Logger logger = LoggerFactory.getLogger(NextVoicepoi.class);

	private void fillReport(Sheet worksheet, int startRowIndex, int startColIndex, List<NextVoiceMISEntity> bean,
			XSSFCellStyle my_style) {

		try {
			DecimalFormat df = new DecimalFormat("#.####");
			df.setRoundingMode(RoundingMode.CEILING);

			Row rowHeader = null;
			Cell cell = null;
			int rowCount = startRowIndex;
			int colcount = startColIndex;
			String lastdate = null;
			int date = 0;
			int count = 0;
			int num = 0;
			for (NextVoiceMISEntity data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(data.getDate());
				lastdate = data.getDate();
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderBottom(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderRight(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderTop(BorderStyle.MEDIUM);

				startColIndex++;
			}

			date = Integer.parseInt(lastdate.substring(lastdate.lastIndexOf("-") + 1, lastdate.length()));

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				num = i;
				count = 0;
				while (num > 0) {
					num = num / 10;
					count = count + 1;
				}
				if (count > 1) {
					cell.setCellValue(lastdate.substring(0, 8) + "" + i);
				} else {
					cell.setCellValue(lastdate.substring(0, 8) + "0" + i);
				}
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderBottom(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderRight(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderTop(BorderStyle.MEDIUM);
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
			cell.getCellStyle().setBorderLeft(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderBottom(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderRight(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderTop(BorderStyle.MEDIUM);
			startColIndex = colcount;
			float totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				float a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getTotal_calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_calls()));
				}
				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribed_User_Calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribed_User_Calls()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);

				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNon_Subscribed_User_Calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNon_Subscribed_User_Calls()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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

			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (data.getTotal_MOU() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_MOU()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribed_User_MOU() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribed_User_MOU()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNon_Subscribed_User_MOU() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNon_Subscribed_User_MOU()));
				}

				totalValue = totalValue + a;

				cell.setCellValue(a);

				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_Pulses() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_Pulses()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribed_User_Pulses() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribed_User_Pulses()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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

			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNon_Subscribed_User_Pulses() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNon_Subscribed_User_Pulses()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_Unique_Callers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_Unique_Callers()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnique_subscribed_callers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnique_subscribed_callers()));
				}

				totalValue = totalValue + a;

				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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

			startColIndex = colcount;
			totalValue = 0;
			rowCount++;
			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnique_Non_Subscribed_callers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnique_Non_Subscribed_callers()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_Pack() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_Pack()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_Pack() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_Pack()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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

			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMontly_Pack() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMontly_Pack()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getYearly_Pack() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getYearly_Pack()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getVoluntary_Un_subscription() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getVoluntary_Un_subscription()));
				}

				totalValue = totalValue + a;

				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getInVoluntary_Un_subscription() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getInVoluntary_Un_subscription()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getGross_Adds() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getGross_Adds()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (data.getSub_IVR() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_IVR()));
				}
				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_CCI() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_CCI()));
				}
				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_OBD() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_OBD()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_SMS() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_SMS()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_IBD() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_IBD()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_USSD() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_USSD()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_Others() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_Others()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_Renewal() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_Renewal()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_Renewal_Pack() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_Renewal_Pack()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMontly_Renewal_Pack() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMontly_Renewal_Pack()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getYearly_Renewal_Pack() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getYearly_Renewal_Pack()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_IVR() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_IVR()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_CCI() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_CCI()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_SMS() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_SMS()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_Others() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_Others()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNew_songs_Attempted() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNew_songs_Attempted()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNew_songs_Submitted() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNew_songs_Submitted()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTo_On_Net_Customer() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTo_On_Net_Customer()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTo_Off_Net_Customer() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTo_Off_Net_Customer()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDedication_Total() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDedication_Total()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNo_of_Voting_SMS() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNo_of_Voting_SMS()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnique_Users_Recorded_Songs() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnique_Users_Recorded_Songs()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_Daily_Pack_Revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_Daily_Pack_Revenue()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_Weekly_Pack_Revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_Weekly_Pack_Revenue()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_Monthly_Pack_Revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_Monthly_Pack_Revenue()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_Yearly_Pack_Revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_Yearly_Pack_Revenue()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getGross_Revenue_in_XAF() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getGross_Revenue_in_XAF()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getGross_Revenue_in_USD() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getGross_Revenue_in_USD()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActive_Subscribers_in_the_System() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActive_Subscribers_in_the_System()));
					a = Float.parseFloat(String.format("%.4f", a));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getBilled_Subscribers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getBilled_Subscribers()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getCalling_Subscribers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getCalling_Subscribers()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_Subscriber_Call_Unique_Caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_Subscriber_Call_Unique_Caller()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_Subscriber_MOU_Unique_Caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_Subscriber_MOU_Unique_Caller()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_Subscriber_MOU_Calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_Subscriber_MOU_Calls()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_Dedication_Unique_Caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_Dedication_Unique_Caller()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnique_Caller_Active_Subscribers_in_the_System() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnique_Caller_Active_Subscribers_in_the_System()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getService_Penetration() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getService_Penetration()));
					a = Float.parseFloat(String.format("%.4f", a));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getARPU() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getARPU()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_moved_from_Active_to_Grace() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_moved_from_Active_to_Grace()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_moved_from_Grace_to_Active() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_moved_from_Grace_to_Active()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_in_1_7_days_Grace_with_service() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_in_1_7_days_Grace_with_service()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_in_8_14_days_retry() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_in_8_14_days_retry()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_in_15_21_Days_retry() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_in_15_21_Days_retry()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_in_22_30_days_retry() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_in_22_30_days_retry()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins0_1() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins0_1()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins1_2() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins1_2()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins2_3() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins2_3()));
					a = Float.parseFloat(String.format("%.4f", a));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins3_4() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins3_4()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins4_5() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins4_5()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins5_6() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins5_6()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins6_7() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins6_7()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins7_8() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins7_8()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins8_9() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins8_9()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins9_10() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins9_10()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (NextVoiceMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins10_Above() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins10_Above()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(a);
				startColIndex++;
			}

			for (int i = date + 1; i <= 31; i++) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(0);
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
		}

		catch (Exception e) {
			logger.error("Error While Genrating XLSX FIle " + e, e);
		}
	}

	public void genrateNextVoiceXLS(InputStream is, int startRowIndex, int startColIndex, HttpServletResponse response,
			List<NextVoiceMISEntity> bean, String fromdate, String todate,String mode) {
		XSSFWorkbook workbook = null;
		try {

			workbook = new XSSFWorkbook(is);

			// DataFormat df = workbook.createDataFormat();

			Sheet worksheet = workbook.getSheetAt(0);// workbook.createSheest("Offices");

			XSSFCellStyle my_style = workbook.createCellStyle();

			/* Create HSSFFont object from the workbook */
			XSSFFont my_font = workbook.createFont();
			/* set the weight of the font */
			my_font.setBold(true);
			/* attach the font to the style created earlier */
			my_style.setFont(my_font);

			workbook.setSheetName(0, "MIS-CRBT-CAMEROON-neXtVoice");
			fillReport(worksheet, startRowIndex, startColIndex, bean, my_style);

			// Set Response Header
			String month = setMonth(todate.substring(5, 7));

			// Set Response Header
			if(mode.equalsIgnoreCase("automailer"))
			response.setHeader("Content-Disposition", "inline; filename=MIS_Nexttel_neXtVoice_" + todate.substring(8) + "-"
					+ month + "-" + todate.substring(0, 4) + ".xlsx");
			
			else
				response.setHeader("Content-Disposition", "inline; filename=MIS_Nexttel_neXtVoice.xlsx");
				
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
					// TODO Auto-generated catch block
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