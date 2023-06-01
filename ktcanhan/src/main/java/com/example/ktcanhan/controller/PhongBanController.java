package com.example.ktcanhan.controller;

import com.example.ktcanhan.entity.PhongBan;
import com.example.ktcanhan.services.PhongBanService;
import com.example.ktcanhan.entity.PhongBan;
import com.example.ktcanhan.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/phongBan")

public class PhongBanController {

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllPhongBans(Model model) {
        List<PhongBan> phongBans = phongBanService.getAllPhongBan();
        model.addAttribute("phongBan", phongBans);
        return "phongBan/list";
    }

    @GetMapping("/add")
    public String addPhongBanForm(Model model){
        model.addAttribute("phongBan", new PhongBan());
        return "phongBan/add";
    }
    @PostMapping("/add")
    public String addPhongBan(@ModelAttribute("phongBan") PhongBan phongBan){
        phongBanService.addPhongBan(phongBan);
        return "redirect:/phongBan";
    }

    @GetMapping("/edit/{id}")
    public String editPhongBanForm(@PathVariable("id") Long id, Model model) {
        Optional<PhongBan> editPhongBan = phongBanService.getAllPhongBan().stream()
                .filter(phongBan -> phongBan.getId().equals(id))
                .findFirst();
        if (editPhongBan.isPresent()) {
            model.addAttribute("phongBan", editPhongBan.get());
            return "phongBan/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editPhongBan(PhongBan phongBan) {
        phongBanService.updatedPhongBan(phongBan);
        return "redirect:/phongBan";
    }

    @GetMapping("/delete/{id}")
    public String deletePhongBan(@PathVariable("id")Long id){
        Iterator<PhongBan> iterator = phongBanService.getAllPhongBan().iterator();
        while (iterator.hasNext()){
            PhongBan phongBan = phongBanService.getPhongBanById(id);
            if(phongBan.getId() == id){
                phongBanService.deletePhongBan(id);
                break;
            }
        }
        return "redirect:/phongBan";
    }
}
