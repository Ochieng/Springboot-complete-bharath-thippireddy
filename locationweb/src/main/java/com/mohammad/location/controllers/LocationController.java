package com.mohammad.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mohammad.location.entities.Location;
import com.mohammad.location.repos.LocationRepository;
import com.mohammad.location.service.LocationService;
import com.mohammad.location.util.EmailUtil;
import com.mohammad.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	private LocationService service;
	
	@Autowired
	private LocationRepository repository;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private ReportUtil reportUtil;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String message = "Location saved with id : "+locationSaved.getId();
		modelMap.addAttribute("message", message);
		emailUtil.sendEmail("mohammaitworld@gmail.com", "Location Saved", "Location Saved successfully and about to return a response");
		
		return "createLocation";
	}
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap) {
		//Location location = service.getLocationById(id); 
		Location location =new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		//emailUtil.sendEmail("mohammaitworld@gmail.com", "Location Deleted", "Location deleted successfully and about to return a response");
		return "displayLocations";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("location", locations);
		//emailUtil.sendEmail("mohammaitworld@gmail.com", "Location updated", "Location updated successfully and about to return a response");
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		
		String path = servletContext.getRealPath("/");
		List<Object[]> data = repository.findTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	}
}












