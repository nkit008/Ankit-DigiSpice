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

import com.digispice.cci.zambia.entity.ZamtelGamesMISEntity;

@Component
public class ZemtalGamesPOI {

	private static Logger logger = LoggerFactory.getLogger(ZemtalGamesPOI.class);

	private void fillReport(Sheet worksheet, int startRowIndex, int startColIndex, List<ZamtelGamesMISEntity> bean,
			XSSFCellStyle my_style) {

		try {
			DecimalFormat df = new DecimalFormat("#.####");
			df.setRoundingMode(RoundingMode.CEILING);

			Row rowHeader = null;
			Cell cell = null;
			int rowCount = startRowIndex;
			int colcount = startColIndex;

			for (ZamtelGamesMISEntity data : bean) {

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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				float a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (String.valueOf(data.getTotalBase()) == null) {
					a = 0;
				} else {
					a = data.getTotalBase();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getActiveBase()) == null) {
					a = 0;
				} else {
					a = data.getActiveBase();
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

			for (ZamtelGamesMISEntity data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalSubscriptionRequestsReceived()) == null) {
					a = 0;
				} else {
					a = data.getTotalSubscriptionRequestsReceived();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (String.valueOf(data.getTotalSecondConsentReceived()) == null) {
					a = 0;
				} else {
					a = data.getTotalSecondConsentReceived();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalRequestProcessWAP()) == null) {
					a = 0;
				} else {
					a = data.getTotalRequestProcessWAP();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalRequestProcessSMS()) == null) {
					a = 0;
				} else {
					a = data.getTotalRequestProcessSMS();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalRequestProcessUSSD()) == null) {
					a = 0;
				} else {
					a = data.getTotalRequestProcessUSSD();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalSubscriptionRequestsProcessed()) == null) {
					a = 0;
				} else {
					a = data.getTotalSubscriptionRequestsProcessed();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalGrossAdds()) == null) {
					a = 0;
				} else {
					a = data.getTotalGrossAdds();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getVoluntaryChurn()) == null) {
					a = 0;
				} else {
					a = data.getVoluntaryChurn();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getWapMode()) == null) {
					a = 0;
				} else {
					a = data.getWapMode();
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
			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getSmsMode()) == null) {
					a = 0;
				} else {
					a = data.getSmsMode();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getUssdMode()) == null) {
					a = 0;
				} else {
					a = data.getUssdMode();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getInvoluntaryChurn()) == null) {
					a = 0;
				} else {
					a = data.getInvoluntaryChurn();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalChurn()) == null) {
					a = 0;
				} else {
					a = data.getTotalChurn();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getNetAdds()) == null) {
					a = 0;
				} else {
					a = data.getNetAdds();
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
			rowCount++;

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalRevenueInZK()) == null) {
					a = 0;
				} else {
					a = data.getTotalRevenueInZK();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getSubscriptionRevenue()) == null) {
					a = 0;
				} else {
					a = data.getSubscriptionRevenue();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getResubscriptionRevenue()) == null) {
					a = 0;
				} else {
					a = data.getResubscriptionRevenue();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				float a = 0;
				if (String.valueOf(data.getSubRevenueFromSMS()) == null) {
					a = 0;
				} else {
					a = data.getSubRevenueFromSMS();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getSubRevenueFromWAP()) == null) {
					a = 0;
				} else {
					a = data.getSubRevenueFromWAP();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getSubRevenueFromUSSD()) == null) {
					a = 0;
				} else {
					a = data.getSubRevenueFromUSSD();
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
			rowCount++;

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalPageViews()) == null) {
					a = 0;
				} else {
					a = data.getTotalPageViews();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalVisits()) == null) {
					a = 0;
				} else {
					a = data.getTotalVisits();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getUniqueVisitors()) == null) {
					a = 0;
				} else {
					a = data.getUniqueVisitors();
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
			rowCount++;

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getDailySubscription()) == null) {
					a = 0;
				} else {
					a = data.getDailySubscription();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getWeeklySubscription()) == null) {
					a = 0;
				} else {
					a = data.getWeeklySubscription();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getMonthlySubscription()) == null) {
					a = 0;
				} else {
					a = data.getMonthlySubscription();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getDailyReSubscription()) == null) {
					a = 0;
				} else {
					a = data.getDailyReSubscription();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getWeeklyReSubscription()) == null) {
					a = 0;
				} else {
					a = data.getWeeklyReSubscription();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getMonthlyReSubscription()) == null) {
					a = 0;
				} else {
					a = data.getMonthlyReSubscription();
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
			rowCount++;

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalCategoryWiseDownloadRequest()) == null) {
					a = 0;
				} else {
					a = data.getTotalCategoryWiseDownloadRequest();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getAndroidGamesRequest()) == null) {
					a = 0;
				} else {
					a = data.getAndroidGamesRequest();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getHTML5GamesRequest()) == null) {
					a = 0;
				} else {
					a = data.getHTML5GamesRequest();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getTotalCategoryWiseDownloadSuccess()) == null) {
					a = 0;
				} else {
					a = data.getTotalCategoryWiseDownloadSuccess();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getAndroidGamesSuccess()) == null) {
					a = 0;
				} else {
					a = data.getAndroidGamesSuccess();
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

			for (ZamtelGamesMISEntity data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				float a = 0;
				if (String.valueOf(data.getHtml5GamesSuccess()) == null) {
					a = 0;
				} else {
					a = data.getHtml5GamesSuccess();
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

	public void genrateZemtalGamesXLS(InputStream is, int startRowIndex, int startColIndex,
			HttpServletResponse response, List<ZamtelGamesMISEntity> bean, String fromdate, String todate) {
		XSSFWorkbook workbook = null;
		try {

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
			String excel_tomonth = setMonth(todate.substring(5,7));
			String excel_toyear = todate.substring(0, 4);

			response.setHeader("Content-Disposition", "inline; filename=MIS_Zemtal_Games_"+excel_todate+"_"+excel_tomonth+"_"
			+excel_toyear+".xlsx");
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