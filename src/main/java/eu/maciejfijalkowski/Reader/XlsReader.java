package eu.maciejfijalkowski.Reader;

import eu.maciejfijalkowski.Model.Model;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsReader {

    private FileInputStream fileXLS;

    public XlsReader() {
    }

    public XlsReader(String fileName) {
        File excelFile = new File(fileName);
        try {
             fileXLS = new FileInputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FileInputStream getFileXLS() {
        return fileXLS;
    }

    public void setFileXLS(FileInputStream fileXLS) {
        this.fileXLS = fileXLS;
    }

    public Iterator<Row> xssfWorkbookIterator (int sheetNumber){
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(this.fileXLS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        return sheet.iterator();
    }

    public Iterator<Row> hssfWorkbookIterator (int sheetNumber){
        HSSFWorkbook workbook = null;
        try {
            workbook = new HSSFWorkbook(this.fileXLS);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HSSFSheet sheet = workbook.getSheetAt(sheetNumber);
        return sheet.iterator();
    }

    public void soutReader (Iterator<Row> iterator){
        while(iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.print(cell.toString() + ";");
            }
            System.out.println();
        }
    }

    public List<Model> listReader (Iterator<Row> iterator){

        List<Model> arrayList = new ArrayList();

        while(iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Model model = new Model();
                Cell cell = cellIterator.next();
                model.setUserId(cell.getStringCellValue());

                cell = cellIterator.next();
                model.setUser(cell.getStringCellValue());

                cell = cellIterator.next();
                model.setExploatationAccountNumber(cell.getStringCellValue());

                cell = cellIterator.next();
                model.setRenovationAccountNumber(cell.getStringCellValue());

                arrayList.add(model);
            }
        }
        return arrayList;
    }
}
