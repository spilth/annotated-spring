package annotatedspring.episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring controller to handle RSS feed requests. 
 * 
 * @author Bruno Lellis
 *
 */
@Controller
public class EpisodesFeedController {

    @Autowired
    private EpisodesRssFeedView rssView;
    
    @RequestMapping(value = "/feed")
    public EpisodesRssFeedView getFeed() {
        return rssView;
    }

}
