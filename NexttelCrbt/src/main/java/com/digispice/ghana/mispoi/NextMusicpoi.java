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

import com.digispice.ghana.bean.NextMusicMISEntity;

@Component
public class NextMusicpoi {

	private static Logger logger = LoggerFactory.getLogger(NextMusicpoi.class);

	private void fillReport(Sheet worksheet, int startRowIndex, int startColIndex, List<NextMusicMISEntity> bean,
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
			for (NextMusicMISEntity data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				cell.setCellValue(data.getDate_time());
				lastdate = data.getDate_time();
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

			for (NextMusicMISEntity data : bean) {
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribed_user_calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribed_user_calls()));
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

			for (NextMusicMISEntity data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNon_subscribed_user_calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNon_subscribed_user_calls()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (data.getTotal_mou() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_mou()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribed_user_mou() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribed_user_mou()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNon_subscribed_user_mou() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNon_subscribed_user_mou()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getTotal_pulses() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getTotal_pulses()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribed_user_pulses() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribed_user_pulses()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getNon_subscribed_user_pulses() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getNon_subscribed_user_pulses()));
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

			for (NextMusicMISEntity data : bean) {
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

			for (NextMusicMISEntity data : bean) {
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
			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnique_non_subscribed_callers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnique_non_subscribed_callers()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_subscriptions_requests_rececived() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_subscriptions_requests_rececived()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_subscriptions_requests_rececived() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_subscriptions_requests_rececived()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_subscriptions_requests_rececived() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_subscriptions_requests_rececived()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_subscriptions_successfull() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_subscriptions_successfull()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_subscriptions_successfull() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_subscriptions_successfull()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_subscriptions_successfull() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_subscriptions_successfull()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getVoluntary_unsubscription() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getVoluntary_unsubscription()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (data.getInvoluntary_unsubscription() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getInvoluntary_unsubscription()));
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

			for (NextMusicMISEntity data : bean) {
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getRe_monthly_subscriptions() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getRe_monthly_subscriptions()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getRe_weekly_subscriptions() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getRe_weekly_subscriptions()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getRe_daily_subscriptions() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getRe_daily_subscriptions()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscription_ivr() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscription_ivr()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscription_cci() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscription_cci()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscription_obd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscription_obd()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscription_sms() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscription_sms()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscription_tnb() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscription_tnb()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscription_ussd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscription_ussd()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscription_others() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscription_others()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsubscription_ivr() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsubscription_ivr()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsubscription_cci() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsubscription_cci()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsubscription_sms() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsubscription_sms()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsubscription_app() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsubscription_app()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getUnsubscription_others() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getUnsubscription_others()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getRequested_songs() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getRequested_songs()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSuccessfull_billed_songs() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSuccessfull_billed_songs()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getBrowsing_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getBrowsing_revenue()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMonthly_subscription_revnue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMonthly_subscription_revnue()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getWeekly_subscription_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getWeekly_subscription_revenue()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getDaily_subscription_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getDaily_subscription_revenue()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSong_download_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSong_download_revenue()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getGross_revenue() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getGross_revenue()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getGross_revenue_usd() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getGross_revenue_usd()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSystem_active_subscribers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSystem_active_subscribers()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getBilled_subscribers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getBilled_subscribers()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getCalling_subscribers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getCalling_subscribers()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActiveBase_0_10() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActiveBase_0_10()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActiveBase_11_30() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActiveBase_11_30()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActiveBase_31_60() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActiveBase_31_60()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActiveBase_61_90() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActiveBase_61_90()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getActiveBase_above90() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getActiveBase_above90()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_non_subscriber_call_per_unique_caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_non_subscriber_call_per_unique_caller()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_non_subscriber_mou_per_unique_caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_non_subscriber_mou_per_unique_caller()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_non_subscriber_mou_per_calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_non_subscriber_mou_per_calls()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_subscriber_call_per_unique_caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_subscriber_call_per_unique_caller()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_subscriber_mou_per_unique_caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_subscriber_mou_per_unique_caller()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_subscriber_mou_per_calls() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_subscriber_mou_per_calls()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getAverage_dedication_mou_per_unique_caller() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getAverage_dedication_mou_per_unique_caller()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSystem_unique_caller_per_active_subscribers() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSystem_unique_caller_per_active_subscribers()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getService_penetration() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getService_penetration()));
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

			for (NextMusicMISEntity data : bean) {
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_moved_from_active_to_grace() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_moved_from_active_to_grace()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_moved_from_grace_to_active() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_moved_from_grace_to_active()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_in_1_7_days_grace_with_service() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_in_1_7_days_grace_with_service()));
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

			for (NextMusicMISEntity data : bean) {
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getSubscribers_in_15_21_days_retry() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getSubscribers_in_15_21_days_retry()));
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

			for (NextMusicMISEntity data : bean) {
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_0_1() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_0_1()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_1_2() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_1_2()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_2_3() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_2_3()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_3_4() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_3_4()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_4_5() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_4_5()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_5_6() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_5_6()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_6_7() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_6_7()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_7_8() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_7_8()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_8_9() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_8_9()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_9_10() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_9_10()));
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

			for (NextMusicMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (data.getMins_above10() == null) {
					a = 0;
				} else {
					a = (Float.parseFloat(data.getMins_above10()));
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
		}

		catch (Exception e) {
			logger.error("Error While Genrating XLSX FIle " + e, e);
		}
	}

	public void genrateNextMusicXLS(InputStream is, int startRowIndex, int startColIndex, HttpServletResponse response,
			List<NextMusicMISEntity> bean, String fromdate, String todate,String mode) {
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

			workbook.setSheetName(0, "MIS-CRBT-CAMEROON-neXtMusic");
			fillReport(worksheet, startRowIndex, startColIndex, bean, my_style);

			String month = setMonth(todate.substring(5, 7));

			// Set Response Header
			if(mode.equalsIgnoreCase("automailer"))
				response.setHeader("Content-Disposition", "inline; filename=MIS_Nexttel_neXtMusic_" + todate.substring(8) + "-"
					+ month + "-" + todate.substring(0, 4) + ".xlsx");
			else
				response.setHeader("Content-Disposition", "inline; filename=MIS_Nexttel_neXtMusic.xlsx");

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