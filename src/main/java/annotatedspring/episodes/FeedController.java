package annotatedspring.episodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

/**
 * Spring controller to handle RSS feed requests. 
 * 
 * @author Bruno Lellis
 *
 */
@Controller
public class FeedController {

    @Autowired
    private RssFeedView rssView;
    
    @RequestMapping(value = "/feed")
    public AbstractRssFeedView getFeed() {
        return rssView;
    }

}
