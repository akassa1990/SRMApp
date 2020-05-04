package edu.mum.cs.cs425.SRMApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.SRMApp.model.Supplier;
import edu.mum.cs.cs425.SRMApp.service.ISupplierService;

@Controller
public class SupplierController {

	@Autowired
	private ISupplierService supplierService;
	
	@RequestMapping(value="/suppliers/list", method=RequestMethod.GET)
	public ModelAndView Suppliers() {
		ModelAndView mav = new ModelAndView();
		List<Supplier> suppliers = supplierService.findAll();
		mav.addObject("suppliers", suppliers);
		mav.setViewName("supplier/list");
		return mav;
	}
	
	@RequestMapping(value="/suppliers/new", method = RequestMethod.GET)
	public String supplierRegistrationForm(Model model){			
		model.addAttribute("supplier", new Supplier());
		return "supplier/new";
	}
	
	@RequestMapping(value = "/suppliers/new", method = RequestMethod.POST)
	public String registerNewSupplier(@Valid @ModelAttribute("supplier") Supplier supplier, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "supplier/new";
		}
		supplier = supplierService.save(supplier);
		return "redirect:/suppliers/list";
	}
	
}
