package com.bjtu.booking.foo;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Workbook workbook = Workbook.getWorkbook(new File("D:\\seatmap-2.xls"));
			int sheetCount = workbook.getNumberOfSheets();
			for(int i = 0; i < sheetCount; i++){
				Sheet sheet = workbook.getSheet(i);
				System.out.println("-------------------" + sheet.getName() + "-----------------------");
				int rowNum = sheet.getRows();
				int colNum = sheet.getColumns();
				System.out.println(rowNum + "=========" + colNum);
				for(int r = 0; r < rowNum; r++) {
					for(int c = 0; c < colNum; c++){
						Cell cell = sheet.getCell(c, r);
						if("".equals(cell.getContents().trim())){
							System.out.print("0-0=NULL\t");
						}else{
							System.out.print((r+1) + "-" + (c+1) + "=" + cell.getContents() + "\t");
						}
					}
					System.out.println();
				}
				System.out.println("------------------------------------------------------------------");
			}
			workbook.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
