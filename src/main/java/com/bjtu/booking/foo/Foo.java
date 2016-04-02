package com.bjtu.booking.foo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjtu.booking.bean.Concert;

/**
 * All methods here are purely rubbish but references, need replace by some real thing.
 * @author SHAO
 *
 */
public class Foo {

	// Concert
	public List<Concert> getConcertList (){
		List<Concert> list = new ArrayList<Concert>();
		
		for (int i = 1; i < 4; i++) {
			Concert conct = new Concert();
			conct.setId(i);
			conct.setTitle("Concert " + i);
			conct.setOpen(new Timestamp((new Date()).getTime()));
			conct.setEnd(new Timestamp((new Date()).getTime()));
			conct.setStadiumId(i);
			conct.setStadiumName("Stadium " + i);
			conct.setTotal(100);
			conct.setSold((int)(Math.random()*100 + 1));
			list.add(conct);
		}
		
		return list;
	}
	
}
