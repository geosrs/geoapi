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
import org.opengis.crs.AuthorityFactory;
import org.opengis.crs.FactoryException;
import org.opengis.crs.NoSuchAuthorityCodeException;

/**
 * Creates {@linkplain Datum datum} objects using authority codes. External authorities are used to
 * manage definitions of objects used in this interface. The definitions of these objects are
 * referenced using code strings. A commonly used authority is <A HREF="http://www.epsg.org">EPSG</A>,
 * which is also used in the <A HREF="http://www.remotesensing.org/geotiff/geotiff.html">GeoTIFF</A>
 * standard.
 *
 * @UML abstract CS_CoordinateSystemAuthorityFactory in 1.0 specification
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version 1.0
 */
public interface DatumAuthorityFactory extends AuthorityFactory {
    /**
     * Returns an arbitrary {@linkplain Datum datum} from a code. If the datum type is know at
     * compile time, it is recommended to invoke the most precise method instead of this one
     * (for example <code>&nbsp;{@linkplain #createGeodeticDatum createGeodeticDatum}(code)&nbsp;</code>
     * instead of <code>&nbsp;createDatum(code)&nbsp;</code> if the caller know he is asking for a
     * {@linkplain GeodeticDatum geodetic datum}).
     *
     * @param  code Value allocated by authority.
     * @throws NoSuchAuthorityCodeException if the specified <code>code</code> was not found.
     * @throws FactoryException if the object creation failed for some other reason.
     *
     * @see #createGeodeticDatum
     * @see #createVerticalDatum
     * @see #createTemporalDatum
     */
    Datum createDatum(String code) throws FactoryException;

    /**
     * Creates a {@linkplain VerticalDatum vertical datum} from a code.
     *
     * @param  code Value allocated by authority.
     * @throws NoSuchAuthorityCodeException if the specified <code>code</code> was not found.
     * @throws FactoryException if the object creation failed for some other reason.
     *
     * @UML operation createVerticalDatum in 1.0 specification
     * @see org.opengis.crs.crs.CRSAuthorityFactory#createVerticalCRS
     */
    VerticalDatum createVerticalDatum(String code) throws FactoryException;

    /**
     * Creates a {@linkplain TemporalDatum temporal datum} from a code.
     *
     * @param  code Value allocated by authority.
     * @throws NoSuchAuthorityCodeException if the specified <code>code</code> was not found.
     * @throws FactoryException if the object creation failed for some other reason.
     *
     * @see org.opengis.crs.crs.CRSAuthorityFactory#createTemporalCRS
     */
    TemporalDatum createTemporalDatum(String code) throws FactoryException;

    /**
     * Returns a {@linkplain GeodeticDatum geodetic datum} from a code.
     *
     * @param  code Value allocated by authority.
     * @throws NoSuchAuthorityCodeException if the specified <code>code</code> was not found.
     * @throws FactoryException if the object creation failed for some other reason.
     *
     * @UML operation createHorizontalDatum in 1.0 specification
     * @see #createEllipsoid
     * @see #createPrimeMeridian
     * @see org.opengis.crs.crs.CRSAuthorityFactory#createGeographicCRS
     * @see org.opengis.crs.crs.CRSAuthorityFactory#createProjectedCRS
     */
    GeodeticDatum createGeodeticDatum(String code) throws FactoryException;

    /**
     * Returns an {@linkplain Ellipsoid ellipsoid} from a code.
     *
     * @param  code Value allocated by authority.
     * @throws NoSuchAuthorityCodeException if the specified <code>code</code> was not found.
     * @throws FactoryException if the object creation failed for some other reason.
     *
     * @UML operation createEllipsoid in 1.0 specification
     * @see #createGeodeticDatum
     */
    Ellipsoid createEllipsoid(String code) throws FactoryException;

    /**
     * Returns a {@linkplain PrimeMeridian prime meridian} from a code.
     *
     * @param  code Value allocated by authority.
     * @throws NoSuchAuthorityCodeException if the specified <code>code</code> was not found.
     * @throws FactoryException if the object creation failed for some other reason.
     *
     * @UML operation createPrimeMeridian in 1.0 specification
     * @see #createGeodeticDatum
     */
    PrimeMeridian createPrimeMeridian(String code) throws FactoryException;

    /**
     * Returns an {@linkplain Unit unit} from a code.
     *
     * @param  code Value allocated by authority.
     * @throws NoSuchAuthorityCodeException if the specified <code>code</code> was not found.
     * @throws FactoryException if the object creation failed for some other reason.
     *
     * @UML operation createLinearUnit createAngularUnit in 1.0 specification
     * @revisit We should probably move this method into a <code>CSAuthorityFactory</code>.
     */
    Unit createUnit(String code) throws FactoryException;

    /**
     * Gets the Geoid code from a WKT name. 
     * In the OGC definition of WKT horizontal datums, the geoid is
     * referenced by a quoted string, which is used as a key value.  This
     * method converts the key value string into a code recognized by this
     * authority.
     *
     * @param wkt Name of geoid defined by OGC (e.g. "European_Datum_1950").
     *
     * @UML operation geoidFromWKTName in 1.0 specification
     * @see #createGeodeticDatum
     *
     * @revisit WKT are not yet specified in this 2.0 version of interfaces.
     *          Does the OGC names still the same?
     */
    String geoidFromWKTName(String wkt);

    /**
     * Gets the WKT name of a Geoid. 
     * In the OGC definition of WKT horizontal datums, the geoid is
     * referenced by a quoted string, which is used as a key value.
     * This method gets the OGC WKT key value from a geoid code.
     *
     * @param geoid Code value for geoid allocated by authority.
     *
     * @UML operation wktGeoidName in 1.0 specification
     * @see #createGeodeticDatum
     *
     * @revisit WKT are not yet specified in this 2.0 version of interfaces.
     *          Does the OGC names still the same?
     */
    String wktGeoidName(String geoid);
}
