/*$************************************************************************************************
 **
 ** $Id$
 **
 ** $Source$
 **
 ** Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 **
 *************************************************************************************************/
package org.opengis.crs.datum;

// J2SE extensions
import javax.units.Unit;

// OpenGIS direct dependencies
import org.opengis.crs.Info;


/**
 * A prime meridian defines the origin from which longitude values are determined.
 * The {@link #getName name} initial value is "Greenwich", and that value shall be
 * used when the {@linkplain #getGreenwichLongitude greenwich longitude} value is
 * zero.
 *
 * @UML abstract CD_PrimeMeridian
 * @author ISO 19111
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version 2.0
 */
public interface PrimeMeridian extends Info {
    /**
     * Longitude of the prime meridian measured from the Greenwich meridian, positive eastward.
     * The <code>greenwichLongitude</code> initial value is zero, and that value shall be used
     * when the {@linkplain #getName meridian name} value is "Greenwich".
     *
     * @return The prime meridian Greenwich longitude, in {@linkplain #getAngularUnit angular unit}.
     * @unitof Length
     * @UML conditional greenwichLongitude
     */
    public double getGreenwichLongitude();

    /**
     * Returns the angular unit of the {@linkplain #getGreenwichLongitude Greenwich longitude}.
     */
    public Unit getAngularUnit();
}
