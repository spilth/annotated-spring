package annotatedspring.episodes;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import annotatedspring.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Application.class })
@WebAppConfiguration
public class EpisodesRssFeedViewTest {

    @InjectMocks
    private EpisodesRssFeedView episodesRssFeedView;

    @Mock
    private EpisodesService episodeService;

    @Value("${feed.description}")
    private String description;

    @Value("${feed.title}")
    private String title;

    @Value("${site.url}")
    private String url;

    @Value("${site.uri.episodes}")
    private String episodesUri;

    private List<Episode> latestEpisodes;

    private Episode episode;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        episodesRssFeedView.setDescription(description);
        episodesRssFeedView.setTitle(title);
        episodesRssFeedView.setUrl(url);
        episodesRssFeedView.setEpisodesUri(episodesUri);
        episodesRssFeedView.setPublishedDate(new Timestamp(1444446000000L));

        episode = new Episode();
        episode.setId(1);
        episode.setSummary("Annotated Spring is a series of screencasts about Spring and inspired by RailsCasts.");
        episode.setTitle("Annotated Spring");
        episode.setYoutubeId("7cOVaxlxA5k");

        latestEpisodes = Arrays.asList(episode);
    }

    @Test
    public void all_returnsAllEpisodes() throws Exception {
        when(episodeService.latestEpisodes()).thenReturn(latestEpisodes);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        Map<String, String> model = new LinkedHashMap<String, String>();

        episodesRssFeedView.render(model, request, response);

        verify(episodeService, times(1)).latestEpisodes();

        assertEquals("Invalid content-type", "application/rss+xml", response.getContentType());
        
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<rss xmlns:content=\"http://purl.org/rss/1.0/modules/content/\" version=\"2.0\">" +
                "<channel>" +
            "<title>Annotated Spring</title>" +
            "<link>http://www.annotatedspring.com</link>" +
            "<description>Spring Screencasts</description>" +
            "<pubDate>Sat, 10 Oct 2015 03:00:00 GMT</pubDate>" +
            "<item>" +
              "<title>Annotated Spring</title>" +
              "<link>http://www.annotatedspring.com/episodes/1</link>" +
              "<description>Annotated Spring is a series of screencasts about Spring and inspired by RailsCasts.</description>" +
              "<content:encoded>&lt;p&gt;Annotated Spring is a series of screencasts about Spring and inspired by RailsCasts.&lt;/p&gt;&lt;iframe src=\"https://www.youtube.com/embed/7cOVaxlxA5k?vq=hd720\" frameborder=\"0\" allowfullscreen&gt;&lt;/iframe&gt;</content:encoded>" +
              "<guid>http://www.annotatedspring.com/episodes/1</guid>" +
            "</item>" +
          "</channel>" +
        "</rss>";
        assertXMLEqual(expected, response.getContentAsString());
        
    }

}