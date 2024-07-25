package org.newapp.demo3.Controller;
import jakarta.validation.Valid;
import org.newapp.demo3.DTO.ClubDTO;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/club")
    public String showAllClubs(Model model){
        List<ClubDTO> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "club_list";
    }
    @GetMapping("/club/add")
    public String addClub(Model model){
        Club club = new Club();
        model.addAttribute("club",club);
        return "add_Club";
    }
    @PostMapping("/club/add")
    public String SaveClub(@Valid @ModelAttribute("club") Club club ,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("club",club);
            return "add_Club";
        }
        clubService.Save(club);
        return "redirect:/club";
    }
    @GetMapping("/club/{ClubId}/edit")
    public String EditClub(@PathVariable("ClubId") int ClubId , Model model){
        ClubDTO club = clubService.findById(ClubId);
        model.addAttribute("club",club);
        return "club_edit";
    }
    @PostMapping("/club/{ClubId}/edit")
    public String EditClub(@PathVariable int ClubId , @Valid @ModelAttribute("club") ClubDTO club, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "club_edit";
        }
        club.setId(ClubId);
        clubService.Update(club);
        return "redirect:/club";
    }
    @GetMapping("/club/{ClubId}")
    public String getDetails(@PathVariable int ClubId, Model model){
        ClubDTO clubDTO = clubService.findById(ClubId);
        model.addAttribute("club",clubDTO);
        return "club_details";
    }

}
