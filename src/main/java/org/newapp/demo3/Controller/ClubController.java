package org.newapp.demo3.Controller;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/admin")
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

}
