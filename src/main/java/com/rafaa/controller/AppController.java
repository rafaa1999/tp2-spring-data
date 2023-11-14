package com.rafaa.controller;

import com.rafaa.dao.IDepartment;
import com.rafaa.dao.IMaterial;
import com.rafaa.model.Department;
import com.rafaa.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class AppController {
   @Autowired
   public IDepartment department;
   @Autowired
   public IMaterial material;
   @GetMapping("/saveSomeRecords")
   public String saveSomeElements(){

        Department department_one = Department.builder().title("GCR").build();
        Department department_two = Department.builder().title("GM").build();
        Department department_three = Department.builder().title("GCV").build();
        Department department_four = Department.builder().title("GCP").build();
        department.save(department_one);
        department.save(department_two);
        department.save(department_three);
        department.save(department_four);

        Material material_one = Material.builder()
                .title("Java")
                .type("Dev")
                .num_series(6924)
                .qte(2)
                .state("Functional")
                .department(department_one)
                .build();
        Material material_two = Material.builder()
                .title("C")
                .type("Dev")
                .num_series(8209)
                .qte(1)
                .state("Functional")
                .department(department_one)
                .build();
        material.save(material_one);
        material.save(material_two);

        return "test";
    }
   @GetMapping("/departments")
   public String getAllDepartment(Model model){
       List<Department> departments = department.findAll();
       model.addAttribute("departments", departments);
       return "departments";
   }
   @GetMapping("/department/{id}")
   public String getListOfMaterialsByDepartmentId(@PathVariable("id") Integer id,Model model){
           Optional<Department> dep = department.findById(id);
           Department department_specific = null;
           if(dep.isPresent()){
               department_specific = dep.get();
           }
           System.out.println("this is the right department that we want to use : " + dep);
           // department calls a list of materials and materials call a department and so on
           // problem in toString method that we're gonna solve it
           List<Material> materials = dep.get().getMaterials();
           model.addAttribute("dep",department_specific);
           model.addAttribute("materials",materials);
           return "materials";
   }

  @GetMapping("/deleteMaterial/{id}")
  public String deleteMaterialById(@PathVariable("id") Integer id){
       Optional<Material> mat = material.findById(id);
       int id_dep = 0;
       if(mat.isPresent()){
          id_dep = mat.get().getDepartment().getId();
       }
      System.out.println("this is the id department : " + id_dep);
       material.deleteById(id);
//       return "redirect:/api/department/getOne/${id_dep}";
       return "redirect:/api/department/" + id_dep;
  }

 @GetMapping("/formMaterial")
 public String materialForm(@ModelAttribute("material") Material mat, Model model){
     List<String> states = Arrays.asList("Functional","Non_Functional");
     List<String> types = Arrays.asList("Dev","Network","Cloud","Devops","Big Data");
     List<Department> departments = department.findAll();
     model.addAttribute("states", states);
     model.addAttribute("types", types);
     model.addAttribute("departments", departments);
     return "material-form";
 }

@PostMapping("/addMaterial")
public String addMaterial(@ModelAttribute("material") Material mat){
    System.out.println(mat);
    material.save(mat);
    return "redirect:/api/departments";
}

}
