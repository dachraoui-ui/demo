package org.newapp.demo3.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.newapp.demo3.Model.Player;
import org.newapp.demo3.Service.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@NoArgsConstructor
@Controller
public class PlayerController {
    private ClubService clubService;
    @GetMapping("/player/{clubId}/add")
    public String addPlayer(@PathVariable("clubId") int clubId, Model model){
        Player player = new Player();
        model.addAttribute("clubId",clubId);
        model.addAttribute("Player",player);
        return "create_player";
    }

}
