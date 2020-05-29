package com.spice.expertmgmtbsnl.daoImpl;

import java.io.IOException;

import java.io.InputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.spice.expertmgmtbsnl.model.HourlyReportModel;

@Component
public class HourlyMisDataExcel {

	private static final Logger LOGGER = Logger.getLogger(HourlyMisDataExcel.class);

	private void fillReport(Sheet worksheet, int startRowIndex, int startColIndex, List<HourlyReportModel> bean,
			XSSFCellStyle my_style) {

		try {
			DecimalFormat df = new DecimalFormat("#.####");
			df.setRoundingMode(RoundingMode.CEILING);

			Row rowHeader = null;
			Cell cell = null;
			int rowCount = startRowIndex;
			for (HourlyReportModel data : bean) {

				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);
				String a = "";
				a = data.getMIS_DATE();
				cell.setCellValue(a);
				cell.setCellStyle(my_style);
				cell.getCellStyle().setBorderLeft(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderBottom(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderRight(BorderStyle.MEDIUM);
				cell.getCellStyle().setBorderTop(BorderStyle.MEDIUM);

				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				String a = "";
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getCircle() == null) {
					a = "NA";
				} else {
					a = data.getCircle();
				}

				cell.setCellValue(a);

				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				String a = "";
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getAgent_location() == null) {
					a = "NA";
				} else {
					a = data.getAgent_location();
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getMIS_HOUR() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getMIS_HOUR());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getChat_ids() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getChat_ids());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				String a = "";
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getLogin_logout() == null) {
					a = "NA";
				} else {
					a = data.getLogin_logout();
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				double a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getAni() == null) {
					a = 0;
				} else {
					a = Double.parseDouble(data.getAni());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				String a = "";
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getVendor() == null) {
					a = "NA";
				} else {
					a = data.getVendor();
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				String a = "";
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getLocation() == null) {
					a = "NA";
				} else {
					a = data.getLocation();
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				String a = "";
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getStatus() == null) {
					a = "NA";
				} else {
					a = data.getStatus();
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				String a = "";
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getCategory() == null) {
					a = "NA";
				} else {
					a = data.getCategory();
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getTotal_Calls() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getTotal_Calls());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getSucc_Calls() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getSucc_Calls());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getFail_calls() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getFail_calls());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getMous() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getMous());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getOrg_cancel_call_less_20sec() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getOrg_cancel_call_less_20sec());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getOrg_cancel_call_gret_20sec() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getOrg_cancel_call_gret_20sec());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getNo_answer() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getNo_answer());
				}

				cell.setCellValue(a);
				rowCount++;
			}

			startColIndex++;
			rowCount = 1;

			for (HourlyReportModel data : bean) {
				rowHeader = worksheet.getRow((short) rowCount);
				if (rowHeader == null)
					rowHeader = worksheet.createRow((short) rowCount);
				rowHeader.setHeight((short) 270);

				cell = rowHeader.getCell(startColIndex);
				int a = 0;
				if (cell == null)
					cell = rowHeader.createCell(startColIndex);

				if (data.getSwitch_off() == null) {
					a = 0;
				} else {
					a = Integer.parseInt(data.getSwitch_off());
				}

				cell.setCellValue(a);
				rowCount++;
			}

		} catch (Exception e) {
			LOGGER.error("Error While Genrating XLSX FIle ", e);
		}
	}

	public void genrateXLS(InputStream is, int startRowIndex, int startColIndex, HttpServletResponse response,
			List<HourlyReportModel> bean, String fromdate, String todate) {
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

			// CellStyle cs=workbook.createCellStyle();

			/*
			 * String excel_frmdate=fromdate.substring(5).substring(3); String
			 * excel_frmmonth=setMonth(fromdate.substring(5,7)); String
			 * excel_frmyear=fromdate.substring(2,4); String
			 * excel_todate=todate.substring(5).substring(3); String
			 * excel_tomonth=setMonth(todate.substring(5,7)); String
			 * excel_toyear=todate.substring(2,4);
			 */

			workbook.setSheetName(0, "MIS-CRBT-NEXT-CAMEROON");
			fillReport(worksheet, startRowIndex, startColIndex, bean, my_style);

			// Set Response Header
			response.setHeader("Content-Disposition", "inline; filename=Hourly_MOD_MIS.xls");
			response.setContentType("application/vnd.ms-excel");
			// response.

			ServletOutputStream outputStream = response.getOutputStream();

			// Write to the output stream
			worksheet.getWorkbook().write(outputStream);
			// Flush the stream
			outputStream.flush();
		} catch (Exception e) {
			LOGGER.info("Error while executing GenrateXLS FIle ", e);
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