package annotatedspring.episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EpisodesController {
    @Autowired
    private EpisodesService episodesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String episodeIndex(Model model) {
        model.addAttribute("episodes", episodesService.published());

        return "episodes/index";
    }

    @RequestMapping(value = "/episodes/new", method = RequestMethod.GET)
    public String episodesNew(Model model) {
        model.addAttribute("episode", new Episode());

        return "episodes/new";
    }

    @RequestMapping(value = "/episodes", method = RequestMethod.POST)
    public String episodeCreate(@Valid Episode episode) {
        episodesService.create(episode);

        return "redirect:/";
    }

    @RequestMapping(value = "/episodes/{episodeId}", method = RequestMethod.GET)
    public String episodeShow(@PathVariable("episodeId") Integer episodeId, Model model) {
        model.addAttribute("episode", episodesService.find(episodeId));

        return "episodes/show";
    }

    @RequestMapping(value = "/episodes/{episodeId}/edit", method = RequestMethod.GET)
    public String episodeEdit(@PathVariable("episodeId") Integer episodeId, Model model) {
        model.addAttribute("episode", episodesService.find(episodeId));

        return "episodes/edit";
    }

    @RequestMapping(value = "/episodes/{episodeId}", method = RequestMethod.POST)
    public String episodeUpdate(@Valid Episode episode, @PathVariable("episodeId") Integer episodeId) {
        episode.setId(episodeId);

        episodesService.update(episode);

        return "redirect:/";
    }

}
