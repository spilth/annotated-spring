package annotatedspring.episodes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;

@Component
public class RssFeedView extends AbstractRssFeedView {

    private EpisodesService episodeService;

    @Value("${site.url}")
    private String url;

    @Value("${feed.title}")
    private String title;
    
    @Value("${feed.description}")
    private String description;

    @Autowired
    public RssFeedView(EpisodesService episodeService) {
        this.episodeService = episodeService;
    }

    @Override
    protected Channel newFeed() {
        Channel channel = new Channel("rss_2.0");
        channel.setLink(url);
        channel.setTitle(title);
        channel.setDescription(description);
        channel.setPubDate(new Date()); // using now because we don't know when
                                        // the last episode was published.
        return channel;
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<Item> items = new ArrayList<>();

        System.out.println("mostRecent: " + episodeService.mostRecent());
        System.out.println("-----");
        System.out.println("latest: " + episodeService.latestEpisodes());
        System.out.println("-----");

        Item item = new Item();
        item.setLink("/episodes/4");
        item.setTitle("CRUD Web App: Part 1 - Create & Read");
        item.setDescription(createDescription(
                "We're going to build a simple note taking web app that lets us create, view, list and edit notes written using the popular Markdown syntax."));
        item.setPubDate(new Date());
        items.add(item);
        return items;
    }

    private Description createDescription(String text) {
        Description description = new Description();
        description.setType(Content.TEXT);
        description.setValue(text);
        return description;
    }

}
