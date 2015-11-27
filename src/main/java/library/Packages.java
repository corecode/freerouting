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
 * Packages.java
 *
 * Created on 3. Juni 2004, 09:29
 */

package library;

import java.util.Iterator;
import java.util.Vector;

import geometry.planar.Shape;

/**
 * Describes a library of component packages.
 *
 * @author  Alfons Wirtz
 * @version $Id: $Id
 */
public class Packages implements java.io.Serializable
{
    /**
     * Creates a new instance of Packages.
     * p_padstack_list is the list of padstacks used for the pins
     * of the packages in this data structure.
     *
     * @param p_padstack_list a {@link library.Padstacks} object.
     */
    public Packages(Padstacks p_padstack_list)
    {
        this.padstack_list = p_padstack_list;
    }
    
    /**
     * Returns the package with the input name and the input side or null,
     * if no such package exists.
     *
     * @param p_name a {@link java.lang.String} object.
     * @param p_is_front a boolean.
     * @return a {@link library.Package} object.
     */
    public Package get(String p_name, boolean p_is_front)
    {
        Iterator<Package> it = package_arr.iterator();
        Package other_side_package = null;
        while(it.hasNext())
        {
            Package curr_package = it.next();
            if (curr_package != null && curr_package.name.compareToIgnoreCase(p_name) == 0)
            {
                if (curr_package.is_front == p_is_front)
                {
                    return curr_package;
                }
                other_side_package = curr_package;
            }
        }
        return other_side_package;
    }
    
    /**
     * Returns the package with index p_package_no.
     * Packages numbers are from 1 to package count.
     *
     * @param p_package_no a int.
     * @return a {@link library.Package} object.
     */
    public Package get(int p_package_no)
    {
        Package result = package_arr.elementAt(p_package_no - 1);
        if (result != null && result.no != p_package_no)
        {
            System.out.println("Padstacks.get: inconsistent padstack number");
        }
        return result;
    }
    
    /**
     * Returns the count of packages in this object.
     *
     * @return a int.
     */
    public int count()
    {
        return package_arr.size();
    }
    
    /**
     * Appends a new package with the input data to this object.
     *
     * @param p_name a {@link java.lang.String} object.
     * @param p_pin_arr an array of {@link library.Package.Pin} objects.
     * @param p_outline an array of {@link geometry.planar.Shape} objects.
     * @param p_keepout_arr an array of {@link library.Package.Keepout} objects.
     * @param p_via_keepout_arr an array of {@link library.Package.Keepout} objects.
     * @param p_place_keepout_arr an array of {@link library.Package.Keepout} objects.
     * @param p_is_front a boolean.
     * @return a {@link library.Package} object.
     */
    public Package add(String p_name, Package.Pin [] p_pin_arr, Shape[] p_outline,
            Package.Keepout [] p_keepout_arr, Package.Keepout [] p_via_keepout_arr, 
            Package.Keepout [] p_place_keepout_arr, boolean p_is_front)
    {
        Package new_package = new Package(p_name, package_arr.size() + 1, p_pin_arr, p_outline,
                p_keepout_arr, p_via_keepout_arr, p_place_keepout_arr, p_is_front, this);
        package_arr.add(new_package);
        return new_package;
    }
    
    /**
     * Appends a new package with pins p_pin_arr to this object.
     * The package name is generated internally.
     *
     * @param p_pin_arr an array of {@link library.Package.Pin} objects.
     * @return a {@link library.Package} object.
     */
    public Package add(Package.Pin [] p_pin_arr)
    {
        String package_name = "Package#" + (new Integer(package_arr.size() + 1)).toString();
        
        return add(package_name, p_pin_arr, null, new Package.Keepout [0], new Package.Keepout [0],
                new Package.Keepout [0], true);
    }
    
    /** The array of packages in this object */
    private Vector<Package> package_arr = new Vector<Package>();
    
    final Padstacks padstack_list;
}
