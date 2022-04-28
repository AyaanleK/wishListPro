package com.kea.projectwishlist.controller;

import com.kea.projectwishlist.model.Wishes;
import com.kea.projectwishlist.repository.WisheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WisheAppController {

  @Autowired
  private WisheRepository eRepo;

  @GetMapping({"/","/home"})
  public String index(){

    return "home";
  }

  @GetMapping({"/showListWishes","/list"})
  public ModelAndView fairVoir(){

    ModelAndView fvoir = new ModelAndView("list-wishes");
    List<Wishes> list = eRepo.findAll();

    fvoir.addObject("wishe", list);

    return fvoir;
  }

  @GetMapping("/addWishesForm")
  public ModelAndView addEmployeeForm(){

    ModelAndView fvoir = new ModelAndView("add-wishes-form");
    Wishes newWishe = new Wishes();

    fvoir.addObject("wishe", newWishe);

    return fvoir;
  }

  @PostMapping("/saveWishes")
  public String saveEmployee(@ModelAttribute Wishes wishes){
    eRepo.save(wishes);

    return "redirect:/list";
  }

  @GetMapping("/showUpdateForm")
  public ModelAndView showUpdateForm(@RequestParam Long wisheID){

    ModelAndView fvoir = new ModelAndView("add-wishes-form");
    Wishes wishe = eRepo.findById(wisheID).get();

    fvoir.addObject("wishe", wishe);

    return fvoir;
  }

  @GetMapping("/deleteWishesForm")
  public String deleteEmployee(@RequestParam Long wisheID){

    eRepo.deleteById(wisheID);

    return "redirect:/list";

  }

}
