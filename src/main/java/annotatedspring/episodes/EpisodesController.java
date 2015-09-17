package annotatedspring.episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EpisodesController {
    @Autowired
    private EpisodesService episodesService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String episodeIndex(Model model) {
        model.addAttribute("episodes", episodesService.published());

        return "episodes/index";
    }

    @RequestMapping(value = "/episodes/{episodeId}/**", method = RequestMethod.GET)
    public String episodeShow(@PathVariable("episodeId") Integer episodeId, Model model) {
        Episode episode = episodesService.find(episodeId);

        model.addAttribute("episode", episode);
        model.addAttribute("url", "http://www.annotatedspring.com/episodes/" + episode.getId() + "/" + episode.getSlug());

        return "episodes/show";
    }
}