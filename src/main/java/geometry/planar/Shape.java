/*
 *  Copyright (C) 2014  Alfons Wirtz  
 *   website www.freerouting.net
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License at <http://www.gnu.org/licenses/> 
 *   for more details.
 *
 * Shape.java
 *
 * Created on 14. November 2002, 12:35
 */

package geometry.planar;

/**
 * Interface describing functionality for connected 2-dimensional shapes in the plane.
 * A Shape object is expected to be simply connected, that means, it may not contain holes.
 *
 * @author  Alfons Wirtz
 * @version $Id: $Id
 */
public interface Shape extends Area
{
    
    /**
     * Returns the length of the border of this shape.
     * If the shape is unbounded, Integer.MAX_VALUE is returned.
     *
     * @return a double.
     */
    double circumference();
    
    /**
     * Returns the content of the area of the shape.
     * If the shape is unbounded, Double.MAX_VALUE is returned.
     *
     * @return a double.
     */
    double area();
    
    /**
     * Returns the gravity point of this shape
     *
     * @return a {@link geometry.planar.FloatPoint} object.
     */
    FloatPoint centre_of_gravity();
    
    /**
     * Returns true, if p_point is not contained in the inside or the
     * boundary of the shape
     *
     * @param p_point a {@link geometry.planar.Point} object.
     * @return a boolean.
     */
    boolean is_outside(Point p_point);
    
    /**
     * Returns true, if p_point is contained in this shape,
     * but not on the border.
     *
     * @param p_point a {@link geometry.planar.Point} object.
     * @return a boolean.
     */
    boolean contains_inside(Point p_point);
    
    /**
     * Returns true, if p_point lies exact on the boundary of the shape
     *
     * @param p_point a {@link geometry.planar.Point} object.
     * @return a boolean.
     */
    boolean contains_on_border(Point p_point);
    
    /**
     * Returns the distance between p_point and its nearest point
     * on the shape. 0, if p_point is contained in this shape
     *
     * @param p_point a {@link geometry.planar.FloatPoint} object.
     * @return a double.
     */
    double distance(FloatPoint p_point);
    
    /**
     * Return a bounding TileShape of this shape.
     *
     * @return a {@link geometry.planar.TileShape} object.
     */
    TileShape bounding_tile();
    
    /**
     * Returns the bounding RegularTileShape with the fixed directions p_dirs
     *
     * @param p_dirs a {@link geometry.planar.ShapeBoundingDirections} object.
     * @return a {@link geometry.planar.RegularTileShape} object.
     */
    RegularTileShape bounding_shape(ShapeBoundingDirections p_dirs);
    
    /**
     * Returns the distance between p_point and its nearest point
     * on the border of the shape.
     *
     * @param p_point a {@link geometry.planar.FloatPoint} object.
     * @return a double.
     */
    double border_distance(FloatPoint p_point);
    
    /**
     * Returns the smallest distance from the centre of gravity to the border
     * of the shape.
     *
     * @return a double.
     */
    double smallest_radius();
    
    /**
     * Returns the offset shape of this shape by offseting the
     * boundary by p_distance to the outside.
     * The result instsnce may be of a different class than this instance.
     * (For example an enlarged IntBox is an IntOctagon).
     *
     * @param p_offset a double.
     * @return a {@link geometry.planar.Shape} object.
     */
    Shape enlarge(double p_offset);
    
    /**
     * checks, if the this shape and p_other have an nonempty intersection.
     *
     * @param p_other a {@link geometry.planar.Shape} object.
     * @return a boolean.
     */
    boolean intersects(Shape p_other);
    
    /**
     * Cuts out the parts of p_polyline in the interiour of this shape
     * and returns a list of the remaining pieces of p_polyline.
     * Pieces completely contained in the border of this shape
     * are not returned.
     *
     * @param p_polyline a {@link geometry.planar.Polyline} object.
     * @return an array of {@link geometry.planar.Polyline} objects.
     */
    Polyline []  cutout(Polyline p_polyline);
    
    /**
     * Auxiliary function to implement the same function with parameter
     * type Shape.
     *
     * @param p_other a {@link geometry.planar.IntBox} object.
     * @return a boolean.
     */
    boolean intersects(IntBox p_other);
    /**
     * Auxiliary function to implement the same function with parameter
     * type Shape.
     *
     * @param p_other a {@link geometry.planar.IntOctagon} object.
     * @return a boolean.
     */
    boolean intersects(IntOctagon p_other);
    /**
     * Auxiliary function to implement the same function with parameter
     * type Shape.
     *
     * @param p_other a {@link geometry.planar.Simplex} object.
     * @return a boolean.
     */
    boolean intersects(Simplex p_other);
    /**
     * Auxiliary function to implement the same function with parameter
     * type Shape.
     *
     * @param p_other a {@link geometry.planar.Circle} object.
     * @return a boolean.
     */
    boolean intersects(Circle p_other);
}
