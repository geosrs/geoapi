/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.sld;

// OpenGIS direct dependencies
import org.opengis.filter.expression.Expression;

// Annotations
import org.opengis.annotation.XmlElement;


/**
 * Indicate that one of a few predefined shapes will be drawn at the points of the geometry.
 *
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version <A HREF="http://www.opengis.org/docs/02-070.pdf">Implementation specification 1.0</A>
 * @since GeoAPI 1.1
 */
@XmlElement("Mark")
public interface Mark extends ExternalGraphicOrMark {
    /**
     * Returns the expression whose value will indicate the symbol to draw.
     * At least the following values must be accepted: "square", "circle",
     * "triangle", "star", "cross", or "x".  If null, the default is "square".
     */
    @XmlElement("WellKnownName")
    Expression getWellKnownName();

    /**
     * Sets the expression whose value will indicate the symbol to draw.
     * See {@link #getWellKnownName} for details.
     */
    @XmlElement("WellKnownName")
    void setWellKnownName(Expression name);

    /**
     * Returns the object that indicates how the mark should be filled.
     * Null means no fill.
     */
    @XmlElement("Fill")
    Fill getFill();

    /**
     * Sets the object that indicates how the mark should be filled.
     * See {@link #getFill} for details.
     */
    @XmlElement("Fill")
    void setFill(Fill f);

    /**
     * Returns the object that indicates how the edges of the mark will be
     * drawn.  Null means that the edges will not be drawn at all.
     */
    @XmlElement("Stroke")
    Stroke getStroke();

    /**
     * Sets the object that indicates how the edges of the mark will be drawn.
     * See {@link #getStroke} for details.
     */
    @XmlElement("Stroke")
    void setStroke(Stroke s);
}
