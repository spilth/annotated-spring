package annotatedspring.episodes;

import org.hibernate.validator.constraints.NotBlank;
import org.pegdown.PegDownProcessor;

import javax.persistence.*;

@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    private String summary;

    @Lob
    private String notes;

    private String youtubeId;

    private Integer duration;

    private String sourcecodeUrl;

    private String thumbnailUrl;

    private boolean published;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
    }

    public String getNotesHtml() {
        return new PegDownProcessor().markdownToHtml(notes);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        if (title == null) {
            this.title = null;
        } else {
            this.title = title.trim();
        }
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSourcecodeUrl() {
        return sourcecodeUrl;
    }

    public void setSourcecodeUrl(String sourcecodeUrl) {
        this.sourcecodeUrl = sourcecodeUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getSlug() {
        return title.toLowerCase()
                .replace("&", "and")
                .replace(",", "")
                .replace(":", "")
                .replace(' ', '-');
    }
}
