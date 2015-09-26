package annotatedspring.episodes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class EpisodeTest{

    @Test
    public void slug_generatesSeoPath() {
        Episode episode = new Episode();
        episode.setTitle("Episode Title");

        assertThat(episode.getSlug(), is(equalTo("episode-title")));
    }

    @Test
    public void slug_withSpecialCharacters_generatesSeoPath() {
        Episode episode = new Episode();
        episode.setTitle("Web Application Layouts: Freemarker, WebJars & Bootstrap");

        assertThat(episode.getSlug(), is(equalTo("web-application-layouts-freemarker-webjars-and-bootstrap")));
    }

    @Test
    public void trim_episode_title() {
        Episode episode = new Episode();
        episode.setTitle(" no leading nor trailing spaces ");

        assertThat(episode.getTitle(), is(equalTo("no leading nor trailing spaces")));
    }
}