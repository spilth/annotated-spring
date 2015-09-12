package annotatedspring.episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EpisodesAdminController {
    @Autowired
    private EpisodesService episodesService;

    @RequestMapping("/admin")
    public String adminIndex(Model model) {
        model.addAttribute("episodes", episodesService.published());

        return "admin/index";
    }

    @RequestMapping(value = "/admin/episodes/new", method = RequestMethod.GET)
    public String episodesNew(Model model) {
        model.addAttribute("episode", new Episode());

        return "admin/episodes/new";
    }

    @RequestMapping(value = "/admin/episodes", method = RequestMethod.POST)
    public String episodeCreate(@Valid Episode episode, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/episodes/new";
        } else {
            episode = episodesService.create(episode);
            return "redirect:/episodes/" + episode.getId();
        }
    }

    @RequestMapping(value = "/admin/episodes/{episodeId}/edit", method = RequestMethod.GET)
    public String episodeEdit(@PathVariable("episodeId") Integer episodeId, Model model) {
        model.addAttribute("episode", episodesService.find(episodeId));

        return "admin/episodes/edit";
    }

    @RequestMapping(value = "/admin/episodes/{episodeId}", method = RequestMethod.PUT)
    public String episodeUpdate(@PathVariable("episodeId") Integer episodeId, @Valid Episode episode, BindingResult result, Model model) {
        episode.setId(episodeId);

        if (result.hasErrors()) {
            model.addAttribute("episode", episode);
            return "admin/episodes/edit";
        } else {
            episodesService.update(episode);
            return "redirect:/episodes/" + episode.getId();
        }
    }
}