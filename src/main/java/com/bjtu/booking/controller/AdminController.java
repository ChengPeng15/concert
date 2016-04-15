package com.bjtu.booking.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bjtu.booking.bean.Area;
import com.bjtu.booking.bean.Concert;
import com.bjtu.booking.bean.Stadium;
import com.bjtu.booking.bean.Ticket;
import com.bjtu.booking.foo.Foo;
import com.bjtu.booking.service.ConcertService;
import com.bjtu.booking.service.StadiumService;
import com.bjtu.booking.service.TicketService;

/**
 * Admin Controller
 * 
 * @author SHAO
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	/**
	 * Enable console output if set 1
	 */
	private int debug = 1;

	/**
	 * All things needed behind controller
	 */
	Foo foo = new Foo();

	@Resource
	private StadiumService stadiumService;

	@Resource
	private ConcertService concertService;

	@Resource
	private TicketService ticketService;

	/**
	 * Method to get concert list, no limitation now
	 */

	@RequestMapping("/concertslist")
	public ModelAndView getConcertList(ModelMap modelMap) {
		ModelAndView view = new ModelAndView();

		if (1 == debug) {
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Concert list");
		}
		List<Concert> list = concertService.getConcertList();
		modelMap.addAttribute("list", list);
		view.setViewName("admin/concert_list");
		return view;
	}

	@RequestMapping("/getconcert")
	public ModelAndView getConcertInfo(@RequestParam(required = false, value = "id") Integer id, ModelMap modelMap) {
		ModelAndView view = new ModelAndView();

		if (1 == debug) {
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Editing/Newing Concert");
		}

		List<Stadium> list = stadiumService.getStadiumList();
		modelMap.addAttribute("stadiums", list);

		if (null == id) {
			if (1 == debug) {
				System.out.println("--Newing");
			}
			modelMap.put("edit", 0);
		}

		if (null != id) {
			if (1 == debug) {
				System.out.println("--Editing");
				System.out.println("--ID [" + id + "]");
			}
			modelMap.put("edit", 1);

			Concert conct = concertService.getConcertById(id);
			modelMap.addAttribute("concert", conct);

			List<List<List<Ticket>>> seatmaps = new ArrayList<List<List<Ticket>>>();
			for (Area area : conct.getAreas()) {
				List<List<Ticket>> seatmap = ticketService.getTicketByAreaId(area.getId());
				seatmaps.add(seatmap);
			}
			modelMap.addAttribute("seatmaps", seatmaps);
		}

		view.setViewName("admin/concert_edit");
		return view;
	}

	@RequestMapping("/addconcert")
	public ModelAndView addConcert(@RequestParam("poster") MultipartFile poster,
			@RequestParam("seatmap") MultipartFile seatmap, @RequestParam("title") String title,
			@RequestParam("stadiumid") int stadiumId, @RequestParam("intro") String intro,
			@RequestParam("open") Timestamp open, @RequestParam("end") Timestamp end) {
		ModelAndView view = new ModelAndView();

		if (1 == debug) {
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Adding Concert");
			System.out.println("--title [" + title + "]");
			System.out.println("--intro [" + intro + "]");
			System.out.println("--stadId [" + stadiumId + "]");
			System.out.println("--open [" + open + "]");
			System.out.println("--end [" + end + "]");
			System.out.println("--seat [" + seatmap.getOriginalFilename() + "]");
			System.out.println("--poster [" + poster.getOriginalFilename() + "]");
		}

		Concert conct = new Concert();
		conct.setTitle(title);
		conct.setIntro(intro);
		conct.setStadiumId(stadiumId);
		conct.setOpen(open);
		conct.setEnd(end);
		try {
			InputStream pio = poster.getInputStream();
			InputStream sio = seatmap.getInputStream();
			concertService.addConcert(conct, sio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		view.setViewName("admin/control_panel");
		return view;
	}

	@RequestMapping("/editconcert")
	public ModelAndView editConcert(@RequestParam(value = "poster", required = false) MultipartFile poster,
			@RequestParam("title") String title, @RequestParam("stadiumid") int stadiumId,
			@RequestParam("intro") String intro, @RequestParam("open") Timestamp open,
			@RequestParam("end") Timestamp end) {
		ModelAndView view = new ModelAndView();

		if (1 == debug) {
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Editing Concert");
			System.out.println("--title [" + title + "]");
			System.out.println("--intro [" + intro + "]");
			System.out.println("--stadId [" + stadiumId + "]");
			System.out.println("--open [" + open + "]");
			System.out.println("--end [" + end + "]");
			System.out.println("--poster [" + poster.getOriginalFilename() + "]");
		}
		
		Concert conct = new Concert();
		conct.setTitle(title);
		conct.setIntro(intro);
		conct.setStadiumId(stadiumId);
		conct.setOpen(open);
		conct.setEnd(end);

		if (null != poster){
			try {
				InputStream pio = poster.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		view.setViewName("admin/control_panel");
		return view;
	}
}
