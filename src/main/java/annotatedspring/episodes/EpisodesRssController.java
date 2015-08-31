package annotatedspring.episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EpisodesRssController {
    @Autowired
    private EpisodesService episodesService;

    @Autowired
    private EpisodeFeedGenerator episodeFeedGenerator;

    @RequestMapping(value = "/rss", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    public EpisodeFeed episodeIndex(Model model) {
        return episodeFeedGenerator.generate(episodesService.published());
    }
}
