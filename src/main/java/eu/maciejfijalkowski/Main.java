package eu.maciejfijalkowski;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import eu.maciejfijalkowski.Model.Model;
import eu.maciejfijalkowski.Reader.XlsReader;
import org.apache.poi.ss.usermodel.Row;

public class Main {

    public static void main(String[] args) throws IOException {

        XlsReader xlsReader = new XlsReader("dane.xls");
//        xlsReader.soutReader(xlsReader.hssfWorkbookIterator(0));
        Iterator<Row> iterator = xlsReader.hssfWorkbookIterator(0);
        List <Model> list = xlsReader.listReader(iterator);

        for (Model model : list){
            System.out.println(model.toString());
        }

    }

}
