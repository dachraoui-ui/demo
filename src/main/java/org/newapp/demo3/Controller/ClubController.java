package org.newapp.demo3.Controller;
import org.newapp.demo3.Model.Club;
import org.newapp.demo3.Service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        List<Club> clubs = clubService.findAllClubs();
        if (clubs == null || clubs.isEmpty()) {
            System.out.println("No clubs found");
        } else {
            clubs.forEach(club -> System.out.println("Found club: " + club.getId() + " - " + club.getName()));
        }
        model.addAttribute("clubs", clubs);
        return "club_list";
    }
}
