package com.example.gymmanagementlist.Controller;

import com.example.gymmanagementlist.Domain.Gym;
import com.example.gymmanagementlist.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GymController {
    @Autowired
    GymService gymService;

        @GetMapping("/GymHomepage")
        public String homePage(Model model){
            model.addAttribute("gym",gymService.getAllGym());
            return "home";

        }
        @GetMapping("/ShowGymForm")
        public String showGymForm(Model model){
            Gym gym= new Gym();
            model.addAttribute("gym",gym);
            model.addAttribute("nextPage","New Gym");
            return "New_Gym";

        }

        @PostMapping("/saveGym")
        public String saveGym(@ModelAttribute("gym") Gym gym, RedirectAttributes redirectAttributes){
            gymService.saveGym(gym);
            redirectAttributes.addFlashAttribute("message", "Approved");
            redirectAttributes.addFlashAttribute("color", "success");

            return "redirect:/GymHomepage";
        }
        @GetMapping("/updateGymRecord/{id}")
        public String showEditForm(@PathVariable("id") Integer Id, Model model, RedirectAttributes redirectAttributes) {
            try {
                Gym gym = gymService.getGymById(Id);
                model.addAttribute("gym", gym);
                model.addAttribute("pageTitle", "Edit Gym Id:" + Id);
                return "updateGymRecord";

            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", e.getMessage());
                redirectAttributes.addFlashAttribute("color", "danger");

                return "redirect:/GymHomepage";
            }
        }
        @PostMapping("/updateGymRecord")
        public String updateGymRecord(@ModelAttribute("gym") Gym gym, RedirectAttributes redirectAttributes){
            try {
                gymService.saveGym(gym);
                redirectAttributes.addFlashAttribute("message", "Gym updated successfully");
                redirectAttributes.addFlashAttribute("color", "success");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", "Error updating gym: " + e.getMessage());
            }
            return "redirect:/GymHomepage";
        }
        @GetMapping("deleteGym/{id}")
        public String deleteGym(@PathVariable long id, RedirectAttributes redirectAttributes) {
            try {
                gymService.deleteGym(id);
                redirectAttributes.addFlashAttribute("message", "Deleted successfully");
                redirectAttributes.addFlashAttribute("color", "success");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("message", e.getMessage());
                redirectAttributes.addFlashAttribute("color", "danger");
            }

            return "redirect:/GymHomepage";
        }
    }
