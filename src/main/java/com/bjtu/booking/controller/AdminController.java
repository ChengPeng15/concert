package com.bjtu.booking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Requesting Concert list");
		}
		List<Concert> list = concertService.getConcertList();
		modelMap.addAttribute("list", list);
		view.setViewName("admin/concert_list");
		return view;
	}
	
	@RequestMapping("/getconcert")
	public ModelAndView getConcertInfo(@RequestParam(required = false , value = "id")Integer id, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Editing/Newing Concert");
		}
		
		List<Stadium> list = stadiumService.getStadiumList();
		modelMap.addAttribute("stadiums", list);

		if (null == id){
			if(1 == debug){
				System.out.println("--Newing");
			}
			modelMap.put("edit", 0);
		}

		if (null != id){
			if(1 == debug){
				System.out.println("--Editing");
				System.out.println("--ID [" + id + "]");
			}
			modelMap.put("edit", 1);
			
			Concert conct = concertService.getConcertById(id);
			modelMap.addAttribute("concert", conct);
			
			List<List<List<Ticket>>> seatmaps = new ArrayList<List<List<Ticket>>>();
			for(Area area : conct.getAreas()){
				List<List<Ticket>> seatmap = ticketService.getTicketByAreaId(area.getId());
				seatmaps.add(seatmap);
			}
			modelMap.addAttribute("seatmaps", seatmaps);
		}
		
		view.setViewName("admin/concert_edit");
		return view;
	}
	
	@RequestMapping("/addconcert")
	public ModelAndView addConcert(){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Adding Concert");
		}
		
		view.setViewName("admin/control_panel");
		return view;
	}
	
	@RequestMapping("/editconcert")
	public ModelAndView editConcert(){
		ModelAndView view = new ModelAndView();
		
		if(1 == debug){
			System.out.println("==[" + this.getClass().getName() + "]==");
			System.out.println("Editing Concert");
		}
		
		view.setViewName("admin/control_panel");
		return view;
	}
}
