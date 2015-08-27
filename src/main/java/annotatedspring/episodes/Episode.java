package annotatedspring.episodes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Episode {
    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String summary;

    private String notes;

    private String youtubeId;

    private Integer duration;

    private String sourcecodeUrl;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
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

}
