package com.bionic.edu.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bionic.edu.proc.*;

@Controller
@RequestMapping("/merchants")
public class MerchantController {
	List<Merchant> list = null;
	@Inject
	MerchantService service;

	@RequestMapping(value = "/listOfMerchants", method = RequestMethod.GET)
	public String showList(ModelMap model) {
		list = service.findAll();
		model.addAttribute("merchantList", list);
		return "listOfMerchants";
	}

	@RequestMapping(value = "/newMerchant", method = RequestMethod.GET)
	public String newMerchant(ModelMap model) {
		model.addAttribute("merchant", new Merchant());
		return "newMerchant";
	}

	@RequestMapping(value = "/addMerchant", method = RequestMethod.POST)
	public String addMerchant(@Valid @ModelAttribute("merchant") Merchant merchant, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "newMerchant";
		}
		service.save(merchant);
		if (list == null)
			list = service.findAll();
		else
			list.add(merchant);
		model.addAttribute("merchantList", list);
		return "listOfMerchants";
	}
	@RequestMapping(value = "/{merchantId}", method = 	RequestMethod.GET)
	public String editMerchant(@PathVariable String merchantId, 	      ModelMap model) {
	     int id = Integer.valueOf(merchantId);
	     Merchant merchant = service.findById(id);
	     model.addAttribute("merchant", merchant);
	     return "newMerchant";
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
	     SimpleDateFormat dateFormat = new 	SimpleDateFormat("dd.MM.yyyy");
	     dataBinder.registerCustomEditor(Date.class, new 	CustomDateEditor(dateFormat, true));
	}


}
