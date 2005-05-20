/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2005 Open GIS Consortium, Inc.
 ** All Rights Reserved. http://www.opengis.org/legal/
 **
 *************************************************************************************************/
package org.opengis.feature.display;

// J2SE direct dependencies
import java.awt.Container;
import java.util.Properties;

// OpenGIS direct dependencies
import org.opengis.feature.display.canvas.FeatureCanvas;


/**
 * The <code>FeatureDisplayFactory</code> class/interface...
 * 
 * @author Jesse Crossley (SYS Technologies)
 * @since GeoAPI 1.1
 */
public interface FeatureDisplayFactory {
    /**
     * @revisit DOCUMENT ME.
     */
    FeatureDisplayCapabilities getCapabilities();
    
    /**
     * @revisit DOCUMENT ME.
     */
    FeatureCanvas createFeatureCanvas(Properties properties, Container container);
    
    /**
     * @revisit DOCUMENT ME.
     */
    FeatureCanvas createFeatureCanvas(Properties properties);
}