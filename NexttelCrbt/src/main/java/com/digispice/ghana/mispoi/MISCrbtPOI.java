package com.digispice.ghana.mispoi;

import java.io.IOException;

import java.io.InputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import com.digispice.ghana.bean.CrbtMisBean;

@Component
public class MISCrbtPOI {
	private static Logger logger = LoggerFactory.getLogger(MISCrbtPOI.class);

	private void fillReport(Sheet worksheet, int startRowIndex, int startColIndex, List<CrbtMisBean> bean,
			HSSFCellStyle my_style) {

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
			for (CrbtMisBean data : bean) {

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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				float a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getTotal_calls_ivr() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_calls_ivr()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_user_calls_ivr() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_user_calls_ivr()));
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

			for (CrbtMisBean data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNon_sub_user_calls_ivr() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNon_sub_user_calls_ivr()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (data.getTotal_hits_ussd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_hits_ussd()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_user_hits_ussd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_user_hits_ussd()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNonsub_user_hits_ussd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNonsub_user_hits_ussd()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_hits_sms() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_hits_sms()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_user_hits_sms() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_user_hits_sms()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNonsub_user_hits_sms() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNonsub_user_hits_sms()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_unique_callers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_unique_callers()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnique_sub_callers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnique_sub_callers()));
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
			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnique_nonsub_callers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnique_nonsub_callers()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getP2p_call() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getP2p_call()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getCorp_tone_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getCorp_tone_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getFree_user_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getFree_user_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_download_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_download_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (data.getTotal_tone_sub_attampt_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_attampt_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_sub_fail_new_download() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_fail_new_download()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_tone_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_tone_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_tone_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_tone_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_tone_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_tone_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getCorp_tone_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getCorp_tone_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_download_tone_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_download_tone_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_sub_attampt_tone_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_attampt_tone_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_sub_fail_tone_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_fail_tone_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getCorp_tone_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getCorp_tone_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getFree_user_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getFree_user_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_download_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_download_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_sub_attampt_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_attampt_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_sub_fail_new_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_fail_new_sub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_sub_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_sub_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_sub_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_sub_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_sub_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_sub_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getCorp_sub_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getCorp_sub_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_download_sub_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_download_sub_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_sub_attampt_sub_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_attampt_sub_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_tone_sub_fail_sub_renew() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_tone_sub_fail_sub_renew()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_ivr() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_ivr()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_cci() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_cci()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_obd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_obd()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_sms() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_sms()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_copy() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_copy()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_gift() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_gift()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_wap() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_wap()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_ussd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_ussd()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSub_mode_others() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSub_mode_others()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getVoluntary_unsub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getVoluntary_unsub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getInvoluntary_unsub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getInvoluntary_unsub()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getGross_adds() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getGross_adds()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_mode_ivr() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_mode_ivr()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_mode_ussd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_mode_ussd()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_mode_web() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_mode_web()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_mode_cci() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_mode_cci()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_mode_sms() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_mode_sms()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsub_mode_others() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsub_mode_others()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_name_tone_req() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_name_tone_req()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAlready_avail() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAlready_avail()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNot_avail() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNot_avail()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_req_recived() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_req_recived()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAccepted() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAccepted()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getRejected() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getRejected()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_tone_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_tone_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_tone_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_tone_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_tone_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_tone_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_sub_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_sub_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_sub_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_sub_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_sub_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_sub_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_packwise_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_packwise_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_packwise_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_packwise_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_packwise_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_packwise_revenue()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_revenue_local() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_revenue_local()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_revenue_usd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_revenue_usd()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActive_subscriber_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActive_subscriber_sub()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActive_subscriber_tone() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActive_subscriber_tone()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNew_tone() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNew_tone()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNew_tone_low_bal() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNew_tone_low_bal()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getGrace() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getGrace()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getRenewal_low_bal_sub() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getRenewal_low_bal_sub()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getRenewal_low_bal_tone() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getRenewal_low_bal_tone()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getBilled_subscriber() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getBilled_subscriber()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_base() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_base()));
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNo_of_tone_subscriber() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNo_of_tone_subscriber()));
				}

				totalValue = totalValue + a;
				cell.setCellValue(df.format(a));
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
			cell.setCellValue(df.format(totalValue));
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUsers_without_tone() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUsers_without_tone()));
				}

				totalValue = a;
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

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getService_pentration() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getService_pentration()));
				}

				totalValue = a;
				cell.setCellValue(df.format(a));
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
			cell.setCellValue(df.format(totalValue));
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderBottom(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderRight(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderTop(BorderStyle.MEDIUM);
			startColIndex = colcount;
			totalValue = 0;
			rowCount++;

			for (CrbtMisBean data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getArpu() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getArpu()));
				}

				totalValue = a;
				cell.setCellValue(df.format(a));
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
			cell.setCellValue(df.format(totalValue));
			cell.setCellStyle(my_style);
			cell.getCellStyle().setBorderLeft(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderBottom(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderRight(BorderStyle.MEDIUM);
			cell.getCellStyle().setBorderTop(BorderStyle.MEDIUM);

		}

		catch (Exception e) {
			logger.error("Error While Genrating XLSX FIle " + e, e);
		}
	}

	public void genrateXLS(InputStream is, int startRowIndex, int startColIndex, HttpServletResponse response,
			List<CrbtMisBean> bean, String fromdate, String todate,String mode) {
		HSSFWorkbook workbook = null;
		try {

			workbook = new HSSFWorkbook(is);

			Sheet worksheet = workbook.getSheetAt(0);

			HSSFCellStyle my_style = workbook.createCellStyle();

			/* Create HSSFFont object from the workbook */
			HSSFFont my_font = workbook.createFont();
			/* set the weight of the font */
			my_font.setBold(true);
			/* attach the font to the style created earlier */
			my_style.setFont(my_font);

			workbook.setSheetName(0, "MIS-CRBT-CAMEROON-neXtTunes");
			fillReport(worksheet, startRowIndex, startColIndex, bean, my_style);

			String month = setMonth(todate.substring(5, 7));

			// Set Response Header
			if(mode.equalsIgnoreCase("automailer"))
				response.setHeader("Content-Disposition", "inline; filename=MIS_Nexttel_neXtTunes_" + todate.substring(8) + "-"
					+ month + "-" + todate.substring(0, 4) + ".xls");
			
			else
				response.setHeader("Content-Disposition", "inline; filename=MIS_Nexttel_neXtTunes.xls");
				
			
			// response
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