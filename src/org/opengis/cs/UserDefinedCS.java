/*
 * Copyright (C) 2003 Open GIS Consortium, Inc. All Rights Reserved. http://www.opengis.org/Legal/
 */
package org.opengis.cs;


/**
 * A two- or three-dimensional coordinate system that consists of any combination of coordinate
 * axes not covered by any other Coordinate System type. An example is a multilinear coordinate
 * system which contains one coordinate axis that may have any 1-D shape which has no intersections
 * with itself. This non-straight axis is supplemented by one or two straight axes to complete a 2
 * or 3 dimensional coordinate system. The non-straight axis is typically incrementally straight or
 * curved. A <code>UserDefinedCS</code> shall have two or three
 * {@linkplain #getAxis axis associations}.
 *
 * @author <A HREF="http://www.opengis.org">OpenGIS&reg; consortium</A>
 * @version 2.0
 */
public interface UserDefinedCS extends CoordinateSystem {
}
