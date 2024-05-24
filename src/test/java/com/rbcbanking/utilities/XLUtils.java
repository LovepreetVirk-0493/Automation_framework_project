package com.rbcbanking.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class XLUtils {
    public static FileInputStream FI;
    public static FileOutputStream FO;
    public static XSSFWorkbook WB;
    public static XSSFSheet WS;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlfile,String xlsheet) throws IOException
    {
       FI = new FileInputStream(xlfile);
       WB = new XSSFWorkbook(FI);
       WS = WB.getSheet(xlsheet);
       int rowcount = WS.getLastRowNum();
       WB.close();
       FI.close();
       return rowcount;
    }

    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
    {
        FI = new FileInputStream(xlfile);
        WB = new XSSFWorkbook(FI);
        WS = WB.getSheet(xlsheet);
        row = WS.getRow(rownum);
        int cellcount = row.getLastCellNum();
        WB.close();
        FI.close();
        return cellcount;
    }

    public static String getCellData(String xlfile,String xlsheet, int rownum, int colnum) throws IOException
    {
        FI = new FileInputStream(xlfile);
        WB = new XSSFWorkbook(FI);
        WS = WB.getSheet(xlsheet);
        row = WS.getRow(rownum);
        cell = row.getCell(colnum);
        String Data;
        try
        {
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            Data = "";
        }
        WB.close();
        FI.close();
        return Data;
    }

    public static void setCellData(String xlfile, String xlsheet, int rownum,int colnum, String Data) throws IOException {
        FI = new FileInputStream(xlfile);
        WB = new XSSFWorkbook(FI);
        WS = WB.getSheet(xlsheet);
        row = WS.getRow(rownum);
        cell = row.createCell(colnum);
        cell.setCellValue(Data);

        FO = new FileOutputStream(xlfile);
        WB.write(FO);
        WB.close();
        FI.close();
        FO.close();

    }

}
