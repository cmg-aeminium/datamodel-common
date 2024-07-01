/**
 * Copyright (c) 2020 Carlos Gonçalves (https://www.linkedin.com/in/carlosmogoncalves/)
 * Likely open-source, so copy at will, bugs will be yours as well.
 */
package pt.cmg.aeminium.datamodel.common.dao.localisation;

import jakarta.ejb.Stateless;
import pt.cmg.aeminium.datamodel.common.dao.JPACrudDAO;
import pt.cmg.aeminium.datamodel.common.entities.localisation.TextContent;

/**
 * @author Carlos Gonçalves
 */
@Stateless
public class TextContentDAO extends JPACrudDAO<TextContent> {

    public TextContentDAO() {
        super(TextContent.class);
    }

}
