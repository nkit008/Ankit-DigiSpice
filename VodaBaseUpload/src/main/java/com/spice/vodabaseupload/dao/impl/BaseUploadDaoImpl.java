package com.spice.vodabaseupload.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import javax.persistence.ParameterMode;
import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.spice.vodabaseupload.beans.BaseUploadEntity;
import com.spice.vodabaseupload.controller.LoginController;
import com.spice.vodabaseupload.dao.IBaseUploadDao;

@Repository
@Transactional
public class BaseUploadDaoImpl implements IBaseUploadDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseUploadDaoImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	LoginController login;

	@Override
	public String upload(MultipartFile base, String serviceName) {

		Session session = sessionFactory.openSession();
		LOGGER.info("In Dao implemention Uploaded Base file name is [{}] and service name is [{}]",
				base.getOriginalFilename(), serviceName);

		String fileName = LoginController.loadProp("FileDestPath");
		int batchSize = Integer.parseInt(LoginController.loadProp("hibernate.jdbc.batch_size"));

		try {
			File dir = new File(fileName);
			if (!dir.exists()) {
				if (dir.mkdir()) {
					LOGGER.info(" ::: Directory is created!");
				} else {
					LOGGER.info(" ::: Failed to create directory!");
				}
			}

			String dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String baseFilePath = dateFormat + "_" + base.getOriginalFilename().replace("'", "");

			File baseFileToCreate = new File(dir + File.separator + baseFilePath);

			System.out.println("file crearing path " + baseFileToCreate);

			try (FileOutputStream os = new FileOutputStream(baseFileToCreate)) {
				os.write(base.getBytes());
			} catch (Exception e) {
				LOGGER.info("Exception Occured in Copy Bulk File {}", e);

				return null;
			}

			FileInputStream inputStream = new FileInputStream(baseFileToCreate);
			LOGGER.info("" + baseFileToCreate.toString());
			Workbook workbook = getRelevantWorkbook(inputStream, baseFileToCreate.toString());

			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			int count = 0;

			iterator.next();

			while (iterator.hasNext()) {
				BaseUploadEntity entity = new BaseUploadEntity();
				count++;
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				if ((nextRow.getCell(0) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(1) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(2) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(3) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(4) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(5) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(6) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(7) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(8) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(9) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(10) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)
						&& (nextRow.getCell(11) == null || nextRow.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK)) {
				}

				else {

					while (cellIterator.hasNext()) {

						Cell cell = cellIterator.next();

						if (cell.getColumnIndex() == 0) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setRETAILERNUMBER(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setRETAILERNUMBER(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}

						}

						else if (cell.getColumnIndex() == 1) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setDSE_MOB_NO(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setDSE_MOB_NO(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 2) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setDIST_Number(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setDIST_Number(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 3) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setTSM_NUMBER(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setTSM_NUMBER(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 4) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setASM_NUMBER(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setASM_NUMBER(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 5) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setZM_NUMBER(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setZM_NUMBER(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 6) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setCIRCLE_TEAM(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setCIRCLE_TEAM(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 7) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setCIRCLE_TEAM1(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setCIRCLE_TEAM1(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 8) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setCIRCLE_TEAM2(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setCIRCLE_TEAM2(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 9) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setCIRCLE_TEAM3(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setCIRCLE_TEAM3(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 10) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setBrand(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setBrand(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}

						else if (cell.getColumnIndex() == 11) {
							if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
								entity.setUB_Count(cell.getStringCellValue());
							}

							else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								entity.setUB_Count(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}
					}

					session.save(entity);
					if (count % batchSize == 0) {
						LOGGER.info("Inserting " + count + " Record");
						session.flush();
						session.clear();
					}

				}

			}

			session.flush();
			session.clear();

			ProcedureCall call = session.createStoredProcedureCall("proc_vodaBaseUpload");
			call.registerParameter("result", String.class, ParameterMode.OUT);
			String output = (String) call.getOutputs().getOutputParameterValue("result");

			LOGGER.info("Result is " + output);

			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception0---------------");
			return null;
		}

		return "Successfully Uploaded !!!!!";
	}

	private static Workbook getRelevantWorkbook(FileInputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		}
		else if(excelFilePath.endsWith("xls")) 
		{
			workbook = new HSSFWorkbook(inputStream);
		}else {
			throw new IllegalArgumentException("Incorrect file format");
		}

		return workbook;
	}

}
