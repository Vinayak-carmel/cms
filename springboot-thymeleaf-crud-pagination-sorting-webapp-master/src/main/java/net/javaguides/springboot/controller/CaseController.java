package net.javaguides.springboot.controller;

import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.model.CaseEntity;
import net.javaguides.springboot.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.service.CaseService;

@Controller
public class CaseController {

    @Autowired
    private CaseService caseService;

    @Autowired
    private CaseRepository caseRepository;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "firstPartyName", "asc", model);
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        CaseEntity aCaseEntity = new CaseEntity();
        model.addAttribute("case", aCaseEntity);
        return "new_case";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        List<CaseEntity> searchedResult = ResponseEntity.ok(caseService.searchCases(query)).getBody();
        model.addAttribute("query", searchedResult);
        return "index";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") CaseEntity aCaseEntity) {
        // save employee to database
        caseService.saveEmployee(aCaseEntity);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {

        // get employee from the service
        CaseEntity aCaseEntity = caseService.getEmployeeById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("caseObject", aCaseEntity);
        return "update_case";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id) {
        this.caseService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/viewCase/{id}")
    public String viewCase(@PathVariable(value = "id") String id, Model model) {
        CaseEntity aCaseEntity = caseService.getEmployeeById(id);
        model.addAttribute("case", aCaseEntity);
        return "view_case";
    }


    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<CaseEntity> page = caseService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<CaseEntity> listCaseEntities = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("query", listCaseEntities);
        return "index";
    }
}
