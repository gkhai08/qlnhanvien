package com.example.ktcanhan.controller;

import com.example.ktcanhan.entity.NhanVien;
import com.example.ktcanhan.services.NhanVienService;
import com.example.ktcanhan.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/nhanVien")

public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String showAllNhanVien(Model model) {
        List<NhanVien> nhanVien = nhanVienService.getALlNhanVien();
        model.addAttribute("nhanVien",nhanVien);
        return "nhanVien/list";
    }
    @GetMapping("/add")
    public String addNhanVienForm(Model model){
        model.addAttribute("nhanVien", new NhanVien());
        model.addAttribute("phongBan", phongBanService.getAllPhongBan());
        return "nhanVien/add";
    }
    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute("nhanVien")NhanVien nhanVien){
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanVien";
    }


    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id")Long id){
        Iterator<NhanVien> iterator = nhanVienService.getALlNhanVien().iterator();
        while (iterator.hasNext()){
            NhanVien nhanVien = nhanVienService.getNhanVienById(id);
            if(nhanVien.getId() == id){
                nhanVienService.deleteNhanVien(id);
                break;
            }
        }
        return "redirect:/nhanVien";
    }





}
