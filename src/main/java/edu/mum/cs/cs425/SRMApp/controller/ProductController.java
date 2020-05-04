package edu.mum.cs.cs425.SRMApp.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import edu.mum.cs.cs425.SRMApp.model.Product;
import edu.mum.cs.cs425.SRMApp.model.Supplier;
import edu.mum.cs.cs425.SRMApp.service.IProductService;
import edu.mum.cs.cs425.SRMApp.service.ISupplierService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;
	
	@Autowired
	private ISupplierService supplierService;
	
	@RequestMapping(value="/products/list", method=RequestMethod.GET)
	public ModelAndView products() {
		ModelAndView mav = new ModelAndView();
		List<Product> products = productService.findAll();
		mav.addObject("products", products);		
		mav.setViewName("product/list");
		return mav;
	}
	
	@RequestMapping(value="/products/new", method = RequestMethod.GET)
	public String productRegistrationForm(Model model){			
		model.addAttribute("product", new Product());
		List<Supplier> suppliers = supplierService.findAll();
		model.addAttribute("suppliers", suppliers);
		return "product/new";
	}
	
	@RequestMapping(value = "/products/new", method = RequestMethod.POST)
	public String registerNewProduct(@Valid @ModelAttribute("product") Product product, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "product/new";
		}
		product = productService.save(product);
		return "redirect:/products/list";
	}
	
	@RequestMapping(value="products/edit/{id}", method = RequestMethod.GET)
    public String editProductForm(Model model, @PathVariable("id") Long id){         
	    Product product = productService.findById(id);
        model.addAttribute("product", product);
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "product/edit";
    }
	
	@RequestMapping(value = "/products/edit", method = RequestMethod.POST)
    public String editProductForm(@Valid @ModelAttribute("product") Product product, 
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "product/edit";
        }
        product = productService.save(product);
        return "redirect:/products/list";
    }
	
	@RequestMapping(value="products/delete/{id}", method = RequestMethod.GET)
    public String deleteProductForm(Model model, @PathVariable("id") Long id){         
        productService.delete(id);
        return "redirect:/products/list";
    }
	
}
