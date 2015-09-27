package annotatedspring.episodes;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import org.junit.Test;


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
    public void setEpisodeTitle_trimsLeadingTrailingWhitespace() {
        Episode episode = new Episode();
        episode.setTitle(" no leading nor trailing spaces ");

        assertThat(episode.getTitle(), is(equalTo("no leading nor trailing spaces")));
    }
    
    @Test
    public void getNotesHtml_enablesMarkdownTables() {
        Episode episode = new Episode();
        String notes = "| Name| Value|\r\n"
                + "| ---- | ----- |\r\n"
                + "| Hello| World!|\r\n"
                + "| Another| Row|\r\n";
        
        episode.setNotes(notes);
        
        assertThat(episode.getNotesHtml(), containsString("<table class=\"table\">"));
    }
}