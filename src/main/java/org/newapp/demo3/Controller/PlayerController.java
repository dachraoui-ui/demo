package org.newapp.demo3.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.newapp.demo3.DTO.PlayerDto;
import org.newapp.demo3.Model.Player;
import org.newapp.demo3.Service.ClubService;
import org.newapp.demo3.Service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Controller
public class PlayerController {
    private PlayerService playerService;
    @GetMapping("/player")
    public String showPlayer(Model model){
        List<PlayerDto> players = playerService.findallPlayer();
        model.addAttribute("players",players);
        return "player_list";
    }
    @GetMapping("/player/{clubId}/add")
    public String addPlayer(@PathVariable("clubId") int clubId, Model model){
        Player player = new Player();
        model.addAttribute("clubId",clubId);
        model.addAttribute("Player",player);
        return "create_player";
    }
    @PostMapping("/player/{clubId}/add")
    public String addPlayer(@Valid @PathVariable("clubId") int clubId, @ModelAttribute("player") PlayerDto playerDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("playerDto",playerDto);
            return "create_player";
        }
        playerService.createPlayer(clubId, playerDto);
        return "redirect:/player";
    }

}
