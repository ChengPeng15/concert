package concert.bean;

import java.io.Serializable;
import java.util.List;

public class Area implements Serializable {
	private static final long serialVersionUID = 1L;
//	

	private int id;
	private int concertId;
	private String concertName; // for front end use
	private String name;
	private int total;
	private int sold;
	private List<Ticket> tickets; // for front end use

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConcertId() {
		return concertId;
	}

	public void setConcertId(int concertId) {
		this.concertId = concertId;
	}

	public String getConcertName() {
		return concertName;
	}

	public void setConcertName(String concertName) {
		this.concertName = concertName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
