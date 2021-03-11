package be.vdab.personeel.controllers;

import be.vdab.personeel.forms.OpslagForm;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("werknemers")
public class WerknemerController {
    private final WerknemerService service;

    public WerknemerController(WerknemerService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView topVanHierarchieWeergeven(){
        var modelAndView= new ModelAndView("werknemer");
        service.findByChef(null).ifPresent(chef -> modelAndView.addObject("werknemer", chef));
        return modelAndView;
    }
    @GetMapping("{id}")
    public ModelAndView medewerkerWeergeven(@PathVariable long id){
        var modelAndView= new ModelAndView("werknemer");
        service.findById(id).ifPresent(werknemer -> modelAndView.addObject("werknemer", werknemer));
        return modelAndView;
    }
    @GetMapping("{id}/opslag")
    public ModelAndView opslagVoorWerknemerAanbieden(@PathVariable long id){
        var modelAndView= new ModelAndView("opslag");
        modelAndView.addObject(new OpslagForm(id, null));
        service.findById(id).ifPresent(werknemer -> modelAndView.addObject("werknemer", werknemer));
        return modelAndView;
    }
    @PostMapping
    public String opslagGevenAanWerknemer(@Valid OpslagForm form, Errors errors, RedirectAttributes redirect){
        var id = form.getWerknemerid();
        if (errors.hasErrors()){
            return "werknemers/"+id+"/opslag";
        }
        var opslag = form.getOpslag();
        service.opslagGeven(id, opslag);
        redirect.addAttribute("opslag", opslag);
        return "redirect:/werknemers/"+id;
    }
}
