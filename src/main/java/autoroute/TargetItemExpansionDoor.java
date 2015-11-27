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
 * TargetItemExpansionDoor.java
 *
 * Created on 2. Februar 2004, 12:59
 */
package autoroute;

import geometry.planar.Simplex;
import geometry.planar.TileShape;
import board.Item;
import board.ShapeSearchTree;

/**
 * An expansion door leading to a start or destination item of the autoroute algorithm.
 *
 * @author  Alfons Wirtz
 * @version $Id: $Id
 */
public class TargetItemExpansionDoor implements ExpandableObject
{

    /**
     * Creates a new instance of ItemExpansionInfo
     *
     * @param p_item a {@link board.Item} object.
     * @param p_tree_entry_no a int.
     * @param p_room a {@link autoroute.CompleteExpansionRoom} object.
     * @param p_search_tree a {@link board.ShapeSearchTree} object.
     */
    public TargetItemExpansionDoor(Item p_item, int p_tree_entry_no, CompleteExpansionRoom p_room, ShapeSearchTree p_search_tree)
    {
        item = p_item;
        tree_entry_no = p_tree_entry_no;
        room = p_room;
        if (room == null)
        {
            this.shape = Simplex.EMPTY;
        }
        else
        {
            TileShape item_shape = item.get_tree_shape(p_search_tree, tree_entry_no);
            this.shape = item_shape.intersection(room.get_shape());
        }
        maze_search_info = new MazeSearchElement();
    }

    /**
     * <p>get_shape.</p>
     *
     * @return a {@link geometry.planar.TileShape} object.
     */
    public TileShape get_shape()
    {
        return this.shape;
    }

    /**
     * <p>get_dimension.</p>
     *
     * @return a int.
     */
    public int get_dimension()
    {
        return 2;
    }

    /**
     * <p>is_destination_door.</p>
     *
     * @return a boolean.
     */
    public boolean is_destination_door()
    {
        ItemAutorouteInfo item_info = this.item.get_autoroute_info();
        return !item_info.is_start_info();
    }

    /** {@inheritDoc} */
    public CompleteExpansionRoom other_room(CompleteExpansionRoom p_room)
    {
        return null;
    }

    /** {@inheritDoc} */
    public MazeSearchElement get_maze_search_element(int p_no)
    {
        return maze_search_info;
    }

    /**
     * <p>maze_search_element_count.</p>
     *
     * @return a int.
     */
    public int maze_search_element_count()
    {
        return 1;
    }

    /**
     * <p>reset.</p>
     */
    public void reset()
    {
        maze_search_info.reset();
    }
    
    public final Item item;
    public final int tree_entry_no;
    public final CompleteExpansionRoom room;
    private final TileShape shape;
    private final MazeSearchElement maze_search_info;
}
