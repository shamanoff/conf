package conf.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Session.
 */
@Entity
@Table(name = "session")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Lob
    @Column(name = "description", nullable = false)
    private byte[] description;

    @Column(name = "description_content_type", nullable = false)
    private String descriptionContentType;


    @NotNull
    @Column(name = "start_date_time", nullable = false)
    private LocalDate startDateTime;

    @NotNull
    @Column(name = "end_date_time", nullable = false)
    private LocalDate endDateTime;

    @ManyToMany(mappedBy = "sessions")
    @JsonIgnore
    private Set<Speaker> speakers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Session title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getDescription() {
        return description;
    }

    public Session description(byte[] description) {
        this.description = description;
        return this;
    }

    public void setDescription(byte[] description) {
        this.description = description;
    }

    public String getDescriptionContentType() {
        return descriptionContentType;
    }

    public Session descriptionContentType(String descriptionContentType) {
        this.descriptionContentType = descriptionContentType;
        return this;
    }

    public void setDescriptionContentType(String descriptionContentType) {
        this.descriptionContentType = descriptionContentType;
    }

    public LocalDate getStartDateTime() {
        return startDateTime;
    }

    public Session startDateTime(LocalDate startDateTime) {
        this.startDateTime = startDateTime;
        return this;
    }

    public void setStartDateTime(LocalDate startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDate getEndDateTime() {
        return endDateTime;
    }

    public Session endDateTime(LocalDate endDateTime) {
        this.endDateTime = endDateTime;
        return this;
    }

    public void setEndDateTime(LocalDate endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Set<Speaker> getSpeakers() {
        return speakers;
    }

    public Session speakers(Set<Speaker> speakers) {
        this.speakers = speakers;
        return this;
    }

    public Session addSpeaker(Speaker speaker) {
        this.speakers.add(speaker);
        speaker.getSessions().add(this);
        return this;
    }

    public Session removeSpeaker(Speaker speaker) {
        this.speakers.remove(speaker);
        speaker.getSessions().remove(this);
        return this;
    }

    public void setSpeakers(Set<Speaker> speakers) {
        this.speakers = speakers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Session session = (Session) o;
        if (session.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), session.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Session{" +
            "id=" + getId() +
            ", title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'" +
            ", descriptionContentType='" + descriptionContentType + "'" +
            ", startDateTime='" + getStartDateTime() + "'" +
            ", endDateTime='" + getEndDateTime() + "'" +
            "}";
    }
}
