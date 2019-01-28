package ru.free4all.familyguy.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "cmmnts")
public class Comment {

    /**
     * Comment id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Author id.
     */
    @Column(name = "authorID")
    private Long authorID;

    /**
     * Date of creation.
     */
    @Column(name = "creation_date")
    private Timestamp creationDate;

    /**
     * Text of comment.
     */
    @Column(name = "value")
    @Length(max = 2048)
    private String value;

    @Column(name = "author_name")
    private String authorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
