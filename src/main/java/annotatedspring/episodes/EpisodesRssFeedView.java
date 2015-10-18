package annotatedspring.episodes;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Content;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Guid;
import com.rometools.rome.feed.rss.Item;

@Component
public class EpisodesRssFeedView extends AbstractRssFeedView {

    private EpisodesService episodeService;

    private String url;
    private String episodesUri;
    private String title;
    private String description;
    private Date publishedDate = new Date();

    @Autowired
    public EpisodesRssFeedView(EpisodesService episodeService) {
        this.episodeService = episodeService;
    }

    @Override
    protected Channel newFeed() {
        Channel channel = new Channel("rss_2.0");
        channel.setLink(url);
        channel.setTitle(title);
        channel.setDescription(description);
        // TODO using now because we don't know when the last episode was published.
        channel.setPubDate(publishedDate);
        return channel;
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        return episodeService.latestEpisodes()
                .stream()
                .map(this::createItem)
                .collect(Collectors.toList());
    }

    private Item createItem(Episode episode) {
        Item item = new Item();
        item.setLink(getEpisodeUrl(episode));
        item.setTitle(episode.getTitle());
        item.setGuid(createGuid(episode));
        item.setDescription(createDescription(episode));
        item.setContent(createContent(episode));
        // item.setPubDate(new Date());
        return item;
    }

    private Content createContent(Episode episode) {
        Content content = new Content();
        content.setType("text/html");
        String html = "<p>" + episode.getSummary() + "</p>";
        html += "<iframe src=\"https://www.youtube.com/embed/" + episode.getYoutubeId()
                + "?vq=hd720\" frameborder=\"0\" allowfullscreen></iframe>";
        content.setValue(html);
        return content;
    }

    private Guid createGuid(Episode episode) {
        Guid guid = new Guid();
        guid.setPermaLink(true);
        guid.setValue(getEpisodeUrl(episode));
        return guid;
    }

    private String getEpisodeUrl(Episode episode) {
        return this.url + this.episodesUri + episode.getId();
    }

    private Description createDescription(Episode episode) {
        Description description = new Description();
        description.setType(Content.TEXT);
        description.setValue(episode.getSummary());
        return description;
    }

    @Value("${feed.title}")
    public void setTitle(String title) {
        this.title = title;
    }

    @Value("${feed.description}")
    public void setDescription(String description) {
        this.description = description;
    }

    @Value("${site.url}")
    public void setUrl(String url) {
        this.url = url;
    }

    @Value("${site.uri.episodes}")
    public void setEpisodesUri(String episodesUri) {
        this.episodesUri = episodesUri;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

}