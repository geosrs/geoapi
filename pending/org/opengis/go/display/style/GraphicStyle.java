/**************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.go.display.style;

import org.opengis.go.display.style.GraphicStyleListener;
import org.opengis.util.Cloneable;

/**
 * Serves as the base interface for the collection of drawing attributes that are
 * applied to a {@link org.opengis.go.display.primitive.Graphic}.  Subclasses provide
 * attributes for specifying SLD-based line symbolizer, polygon symbolizer, point
 * symbolizer, text symbolizer.  Attributes common to all types of geometry,
 * related to viewability, editability, and highlighting, are contained in
 * <code>Graphic</code>.
 *
 * @version $Revision$, $Date$
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 */
public interface GraphicStyle extends Cloneable {

    /**
     * Registers the given object as a listener to receive events when the
     * properties of this style have changed.
     */
    public void addGraphicStyleListener(GraphicStyleListener listener);

    /**
     * For a listener that was previously added using the
     * <code>addGraphicStyleListener</code> method, this method de-registers
     * it so that it will no longer receive events when the properties of this
     * style have changed.
     */
    public void removeGraphicStyleListener(GraphicStyleListener listener);

    /**
     * Returns the given implementation-specific hint for the given name.
     *
     * @param hintName The hint key.
     * @return the hint object associated with the hint name.
     *
     * @revisit Why not <code>getRenderingHint</code> for consistency
     *          with current J2SE usage? Then, the key type should
     *          be a {@link java.awt.RenderingHint.Key} type.
     */
    public Object getImplHint(String hintName);

    /**
     * Sets the given implementation-specific hint for the given name.
     *
     * @param hintname The hint key.
     * @param hint The hint.
     *
     * @revisit Why not <code>setRenderingHint</code> for consistency
     *          with current J2SE usage? Then, the key type should
     *          be a {@link java.awt.RenderingHint.Key} type.
     */
    public void setImplHint(String hintname, Object hint);

    /**
     * Sets the properties of this <code>GraphicStyle</code> from the
     * properties of the specified <code>GraphicStyle</code>.  May throw an execption
     * if the given object is not the same type as this one.
     *
     * @param style the <code>GraphicStyle</code> used to set this
     *        <code>GraphicStyle</code> properties.
     */
    public void setPropertiesFrom(GraphicStyle style);

    /**
     * Method inherited from the <code>Cloneable</code> interface, included here
     * for public access.
     *
     * @return Returns a shallow copy of this object.  This means that all of
     *   the subordinate objects referenced by this object will also be
     *   referenced by the result.  These objects include the values for
     *   <code>implHint</code>s, etc.
     */
    public Object clone();
}