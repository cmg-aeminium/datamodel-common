/**
 * Copyright (c) 2024 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.aeminium.datamodel.common.entities.localisation;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "textcontents")
@NamedQuery(name = TextContent.QUERY_FIND_IN_IDS, query = "SELECT t FROM TextContent t WHERE t.id IN :ids")
public class TextContent implements Serializable {

    /**
     * Auto-generated by IDE
     */
    private static final long serialVersionUID = 5690374537979644997L;

    public static final String QUERY_FIND_IN_IDS = "TextContent.findInIds";

    @Id
    @SequenceGenerator(
        sequenceName = "textcontents_id_seq",
        allocationSize = 1,
        initialValue = 1,
        name = "TEXTCONTENTS_SEQUENCE")
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "TEXTCONTENTS_SEQUENCE")
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column
    private String textValue;

    public TextContent() {
    }

    public TextContent(Language language, String textValue) {
        super();
        this.language = language;
        this.textValue = textValue;
    }

    public static TextContent createEmptyTextContent() {
        TextContent instance = new TextContent();
        instance.setLanguage(Language.DEFAULT_LANGUAGE);
        instance.setTextValue("???");
        return instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, textValue);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TextContent other = (TextContent) obj;
        return Objects.equals(id, other.id) && language == other.language && Objects.equals(textValue, other.textValue);
    }

}
