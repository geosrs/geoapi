/* ====================================================================
 * The ImageMatters LLC Software License, Version 1.1
 *
 * Copyright (c) 1999-2004 ImageMatters LLC.  All rights reserved.
 *
 * ====================================================================
 * 
 * $Log$
 * Revision 1.1  2005/03/03 11:54:42  desruisseaux
 * Added Stephane's interfaces proposal for GridCoverage
 *
 * Revision 1.1  2005/02/28 15:56:10  stephanef
 * Move from ctp package to owsx
 *
 * Revision 1.1  2005/02/28 15:51:38  stephanef
 * Initial revision
 *
 */
package com.owsx.temporal;

/**
 * Values for relative temporal position based on the 13 temporal relationships
 * identified by Allen (1993).
 * 
 * @author Stephane Fellah
 * @since Feb 28, 2005
 * @version $Revision$
 */
public enum TemporalRelativePosition {
    Before,
    After,
    Begins,
    Ends,
    During,
    Equals,
    Contains,
    Overlaps,
    Meets,
    OverlappedBy,
    MetBy,
    BegunBy,
    EndedBy
}