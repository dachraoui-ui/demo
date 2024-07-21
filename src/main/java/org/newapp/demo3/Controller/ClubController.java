package org.newapp.demo3.Controller;
import org.newapp.demo3.DTO.ClubDTO;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/club")
    public String showAllClubs(Model model){
        List<Club> clubs = clubService.findAllClubs();
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
    public String SaveClub(@ModelAttribute("club") Club club){
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
    public String EditClub(@PathVariable int ClubId , @ModelAttribute ClubDTO club){
        club.setId(ClubId);
        clubService.Update(club);
        return "redirect:/club";
    }

}
