package com.codingdojo.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class GoldController {
	
	public int gold;
	public Random random = new Random();
	public ArrayList<String> activitiesList = new ArrayList<String>();
	public DateTimeFormatter date = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy hh:mm:ss a");
	
	@RequestMapping( value="/Gold", method=RequestMethod.GET )
	public String gold( Model model, HttpSession session, RedirectAttributes flash ) {
		
		if( session.getAttribute("gold") == null ) {
			gold = 0;
		}
		
		session.setAttribute( "gold", gold );
		
		if( gold < -50 ) {
			return "lose.jsp";
		}
		
		return "gold.jsp";
	}
	
	@RequestMapping( value="/farm", method=RequestMethod.POST )
	public String farm( HttpSession session, RedirectAttributes flash ) {
		
		int value = random.nextInt(20 - 10) + 10;
		gold += value;
		
		session.setAttribute( "color", 0 );
		activitiesList.add("You entered a farm, and earned " + value + " gold. (" + date.format(LocalDateTime.now()) + ")" );
		
		session.setAttribute( "gold", gold );
		flash.addFlashAttribute( "activitiesList", activitiesList );
		
		return "redirect:/Gold";
	}
	
	@RequestMapping( value="/cave", method=RequestMethod.POST )
	public String cave( HttpSession session, RedirectAttributes flash ) {
		
		int value = random.nextInt(10 - 5) + 5;
		gold += value;
		
		session.setAttribute( "color", 0 );
		activitiesList.add("You entered a cave, and earned " + value + " gold. (" + date.format(LocalDateTime.now()) + ")" );
		
		session.setAttribute( "gold", gold );
		flash.addFlashAttribute( "activitiesList", activitiesList );
		
		return "redirect:/Gold";
	}
	
	@RequestMapping( value="/house", method=RequestMethod.POST )
	public String house( HttpSession session, RedirectAttributes flash ) {
		
		int value = random.nextInt(5 - 2) + 2;
		gold += value;
		
		session.setAttribute( "color", 0 );
		activitiesList.add("You entered a house, and earned " + value + " gold. (" + date.format(LocalDateTime.now()) + ")" );
		
		session.setAttribute( "gold", gold );
		flash.addFlashAttribute( "activitiesList", activitiesList );
		
		return "redirect:/Gold";
	}
	
	@RequestMapping( value="/casino", method=RequestMethod.POST )
	public String casino( HttpSession session, RedirectAttributes flash ) {
		
		int value = random.nextInt(50);
		int select = random.nextInt(2);
		System.out.print(select);
		if( select == 0) {
			gold += value;
			session.setAttribute( "color", 0 );
			activitiesList.add("You entered a casino, and earned " + value + " gold. (" + date.format(LocalDateTime.now()) + ")" );
		}
		else {
			gold -= value;
			session.setAttribute( "color", 1 );
			activitiesList.add("You entered a casino, and lost " + value + " gold. Ouch!!! Sorry. (" + date.format(LocalDateTime.now()) + ")" );
		}
		
		session.setAttribute( "gold", gold );
		flash.addFlashAttribute( "activitiesList", activitiesList );
		
		return "redirect:/Gold";
	}
	
	@RequestMapping( value="/spa", method=RequestMethod.POST )
	public String spa( HttpSession session, RedirectAttributes flash ) {
		
		int value = random.nextInt(45 - 10) + 10;
		gold -= value;
		
		session.setAttribute( "color", 1 );
		activitiesList.add("You entered a spa, and lost " + value + " gold. Ouch!!! Very sorry. (" + date.format(LocalDateTime.now()) + ")" );
		
		session.setAttribute( "gold", gold );
		flash.addFlashAttribute( "activitiesList", activitiesList );
		
		return "redirect:/Gold";
	}
	
	@RequestMapping( value="/restart", method=RequestMethod.GET )
	public String restart( HttpSession session ) {
		session.removeAttribute( "gold" );
		activitiesList.clear();
		
		return "redirect:/Gold";
	}
}
