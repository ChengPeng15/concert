package com.bjtu.booking.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bjtu.booking.bean.Area;
import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.dao.inf.IAreaDAO;
import com.bjtu.booking.dao.inf.IConcertDAO;
import com.bjtu.booking.dao.inf.ITicketDAO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Service
public class ConcertService {
	
	@Resource
	private IConcertDAO concertDAO;
	
	@Resource
	private IAreaDAO areaDAO;
	
	@Resource
	private ITicketDAO ticketDAO;
	
	public List<Concert> getConcertList(){
		List<Concert> list = concertDAO.getConcertList(new Date());
		return list;
	}
	
	public List<Concert> getLatest3Concert(){
		return concertDAO.getLatest3Concert(new Date());
	}
	
	public Concert getConcertById(int id){
		return concertDAO.getConcertById(id);
	}
	
	public boolean addConcert(Concert concert, InputStream is) {
		List<Area> areas = new ArrayList<Area>();
		Workbook workbook = null;
		int totalSeat = 0;
		try {
			workbook = Workbook.getWorkbook(is);
			int sheetCount = workbook.getNumberOfSheets();
			for(int i = 0; i < sheetCount; i++){
				Sheet sheet = workbook.getSheet(i);
				Area area = new Area();
				area.setTickets(new ArrayList<Ticket>());
				areas.add(area);
				area.setName(sheet.getName());
				int areaTotalSeat = 0;
				int rowNum = sheet.getRows();
				int colNum = sheet.getColumns();
				for(int y = 0; y < rowNum; y++) {
					for(int x = 0; x < colNum; x++){
						Ticket ticket = new Ticket();
						area.getTickets().add(ticket);
						ticket.setXvalue(x + 1);
						ticket.setYValue(y + 1);
						ticket.setCode(ticket.getYValue() + "-" + ticket.getXValue());
						Cell cell = sheet.getCell(x, y);
						if(null == cell || "".equals(cell.getContents().trim())){
							ticket.setStatus(-1);
						} else {
							areaTotalSeat++;
							double price = Double.parseDouble(cell.getContents());
							ticket.setPrice(price);
							ticket.setStatus(0);
						}
					}
				}
				totalSeat = totalSeat + areaTotalSeat;
				area.setTotal(areaTotalSeat);
			}
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			if(null != workbook) {
				workbook.close();
			}
		}
		concert.setTotal(totalSeat);
		concertDAO.addConcert(concert);
		for(Area area : areas) {
			area.setConcertId(concert.getId());
			areaDAO.addArea(area);
			for (Ticket t : area.getTickets()) {
				t.setAreaId(area.getId());
				ticketDAO.addTickets(t);
			}
		}
		return true;
	}
}
