package be.vdab.personeel.controllers;

import be.vdab.personeel.services.JobtitelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jobtitels")
public class JobtitelsController {
    private final JobtitelService service;

    public JobtitelsController(JobtitelService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView jobtitelsWeergeven(){
        return new ModelAndView("jobtitels", "jobtitels", service.findAll());
    }
    @GetMapping("{id}")
    public ModelAndView specifiekJobtitelWeergeven(@PathVariable long id){
        var model = jobtitelsWeergeven();
        service.findById(id).ifPresent(titel ->model.addObject("jobtitel", titel));
        return model;
    }
}
