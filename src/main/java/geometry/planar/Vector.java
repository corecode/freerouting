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
 * Vector.java
 *
 * Created on 1. Februar 2003, 14:28
 */

package geometry.planar;

import java.math.BigInteger;

import datastructures.Signum;

/**
 * Abstract class describing functionality of Vectors.
 * Vectors are used for translating Points in the plane.
 *
 * @author Alfons Wirtz
 * @version $Id: $Id
 */
public abstract class Vector implements java.io.Serializable
{
    
    /**
     * returns true, if this vector is equal to the zero vector.
     *
     * @return a boolean.
     */
    public abstract boolean is_zero();
    
    /**
     * returns the Vector such that this plus this.negate() is zero
     *
     * @return a {@link geometry.planar.Vector} object.
     */
    public abstract Vector negate();
    
    /**
     * adds p_other to this vector
     *
     * @param p_other a {@link geometry.planar.Vector} object.
     * @return a {@link geometry.planar.Vector} object.
     */
    public abstract Vector add( Vector p_other);
    
    /**
     * Let L be the line from the Zero Vector to p_other.
     * The function returns
     *         Side.ON_THE_LEFT, if this Vector is on the left of L
     *         Side.ON_THE_RIGHT, if this Vector is on the right of L
     *     and Side.COLLINEAR, if this Vector is collinear with L.
     *
     * @param p_other a {@link geometry.planar.Vector} object.
     * @return a {@link geometry.planar.Side} object.
     */
    public abstract Side side_of(Vector p_other);
    
    /**
     * returns true, if the vector is horizontal or vertical
     *
     * @return a boolean.
     */
    public abstract boolean is_orthogonal();
    
    /**
     * returns true, if the vector is diagonal
     *
     * @return a boolean.
     */
    public abstract boolean is_diagonal();
    
    /**
     * Returns true, if the vector is orthogonal or diagonal
     *
     * @return a boolean.
     */
    public boolean is_multiple_of_45_degree()
    {
        return is_orthogonal() || is_diagonal();
    }
    
    /**
     * The function returns
     *   Signum.POSITIVE, if the scalar product of this vector and p_other > 0,
     *   Signum.NEGATIVE, if the scalar product Vector is < 0,
     *   and Signum.ZERO, if the scalar product is equal 0.
     *
     * @param p_other a {@link geometry.planar.Vector} object.
     * @return a {@link datastructures.Signum} object.
     */
    public abstract Signum projection(Vector p_other);
    
    /**
     * Returns an approximation of the scalar product of this vector
     * with p_other by a double.
     *
     * @param p_other a {@link geometry.planar.Vector} object.
     * @return a double.
     */
    public abstract double scalar_product(Vector p_other);
    
    /**
     * approximates the coordinates of this vector by float coordinates
     *
     * @return a {@link geometry.planar.FloatPoint} object.
     */
    public abstract FloatPoint to_float();
    
    /**
     * Turns this vector by p_factor times 90 degree.
     *
     * @param p_factor a int.
     * @return a {@link geometry.planar.Vector} object.
     */
    public abstract Vector turn_90_degree(int p_factor);
    
    /**
     * Mirrors this vector at the x axis.
     *
     * @return a {@link geometry.planar.Vector} object.
     */
    public abstract Vector mirror_at_x_axis();
    
    /**
     * Mirrors this vector at the y axis.
     *
     * @return a {@link geometry.planar.Vector} object.
     */
    public abstract Vector mirror_at_y_axis();
    
    /**
     * Standard implementation of the zero vector .
     */
    public static final IntVector ZERO = new IntVector(0, 0);
    
    /**
     * Creates a Vector (p_x, p_y) in the plane.
     *
     * @param p_x a int.
     * @param p_y a int.
     * @return a {@link geometry.planar.Vector} object.
     */
    public static Vector get_instance(int p_x, int p_y)
    {
        IntVector result = new IntVector(p_x, p_y);
        if ( Math.abs(p_x) > Limits.CRIT_INT ||
                Math.abs(p_x) > Limits.CRIT_INT )
        {
            return new RationalVector(result);
        }
        return result;
    }
    
    /**
     * Creates a 2-dimensinal Vector from the 3 input values.
     * If p_z != 0 it correspondents to the Vector in the plane
     * with rational number coordinates (p_x / p_z, p_y / p_z).
     *
     * @param p_x a {@link java.math.BigInteger} object.
     * @param p_y a {@link java.math.BigInteger} object.
     * @param p_z a {@link java.math.BigInteger} object.
     * @return a {@link geometry.planar.Vector} object.
     */
    public static Vector get_instance(BigInteger p_x, BigInteger p_y,
            BigInteger p_z)
    {
        if (p_z.signum() < 0)
        {
            // the dominator z of a RationalVector is expected to be positive
            p_x = p_x.negate();
            p_y = p_y.negate();
            p_z = p_z.negate();
            
        }
        if ((p_x.mod(p_z)).signum() == 0 && (p_x.mod(p_z)).signum() == 0)
        {
            // p_x and p_y can be divided by p_z
            p_x = p_x.divide(p_z);
            p_y = p_y.divide(p_z);
            p_z = BigInteger.ONE;
        }
        if (p_z.equals(BigInteger.ONE))
        {
            if ( (p_x.abs()).compareTo(Limits.CRIT_INT_BIG) <= 0 &&
                    (p_y.abs()).compareTo(Limits.CRIT_INT_BIG) <= 0 )
            {
                // the Point fits into an IntPoint
                return new IntVector(p_x.intValue(), p_y.intValue());
            }
        }
        return new RationalVector(p_x, p_y, p_z);
    }
    
    /**
     * returns an approximation of the euclidian length of this vector
     *
     * @return a double.
     */
    public double length_approx()
    {
        return this.to_float().size();
    }
    
    
    /**
     * Returns an approximation of the cosinus of the angle
     * between this vector and  p_other by a double.
     *
     * @param p_other a {@link geometry.planar.Vector} object.
     * @return a double.
     */
    public double cos_angle(Vector p_other)
    {
        double result = this.scalar_product(p_other);
        result /= this.to_float().size() * p_other.to_float().size();
        return result;
    }
    
    /**
     * Returns an approximation of the signed angle between this vector and p_other.
     *
     * @param p_other a {@link geometry.planar.Vector} object.
     * @return a double.
     */
    public double angle_approx(Vector p_other)
    {
        double result = Math.acos(cos_angle(p_other));
        if (this.side_of(p_other) == Side.ON_THE_LEFT)
        {
            result = - result;
        }
        return result;
    }
    
    /**
     * Returns an approximation of the signed angle between this vector and the x axis.
     *
     * @return a double.
     */
    public double angle_approx()
    {
        Vector other = new IntVector(1, 0);
        return other.angle_approx(this);
    }
    
    /**
     * Returns an approximation vector of this vector with the same direction and
     * length p_length.
     *
     * @param p_lenght a double.
     * @return a {@link geometry.planar.Vector} object.
     */
    public abstract Vector change_length_approx(double p_lenght);
    
    abstract Direction to_normalized_direction();
    
    
    
    // auxiliary functions needed because the virtual function mechanism
    // does not work in parameter position
    
    abstract Vector add( IntVector p_other);
    abstract Vector add( RationalVector p_other);
    
    abstract Point add_to(IntPoint p_point);
    abstract Point add_to(RationalPoint p_point);
    
    abstract Side side_of(IntVector p_other);
    abstract Side side_of(RationalVector p_other);
    
    abstract Signum projection(IntVector p_other);
    abstract Signum projection(RationalVector p_other);
    
    abstract double scalar_product(IntVector p_other);
    abstract double scalar_product(RationalVector p_other);
    
    
}
