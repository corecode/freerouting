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
 * ScreenMessageFields.java
 *
 * Created on 8. August 2003, 19:10
 */

package interactive;

import javax.swing.JLabel;

/**
 * Text fields to display messages on the screen.
 *
 * @author  arbeit
 * @version $Id: $Id
 */
public class ScreenMessages
{
    
    /**
     * Creates a new instance of ScreenMessageFields
     *
     * @param p_status_field a {@link javax.swing.JLabel} object.
     * @param p_add_field a {@link javax.swing.JLabel} object.
     * @param p_layer_field a {@link javax.swing.JLabel} object.
     * @param p_mouse_position a {@link javax.swing.JLabel} object.
     * @param p_locale a {@link java.util.Locale} object.
     */
    public ScreenMessages(JLabel p_status_field, JLabel p_add_field,
            JLabel p_layer_field, JLabel p_mouse_position, java.util.Locale p_locale)
    {
        resources = java.util.ResourceBundle.getBundle("interactive.resources.ScreenMessages", p_locale);
        locale = p_locale;
        active_layer_string = resources.getString("current_layer") + " ";
        target_layer_string = resources.getString("target_layer") + " ";
        status_field = p_status_field;
        add_field = p_add_field;
        layer_field = p_layer_field;
        mouse_position = p_mouse_position;
        add_field.setText(empty_string);
        
        this.number_format =  java.text.NumberFormat.getInstance(p_locale);
        this.number_format.setMaximumFractionDigits(4);
    }
    
    /**
     * Sets the message in the status field.
     *
     * @param p_message a {@link java.lang.String} object.
     */
    public void set_status_message(String p_message)
    {
        if (!this.write_protected)
        {
            status_field.setText(p_message);
        }
    }
    
    /**
     * Sets the displayed layer number on the screen.
     *
     * @param p_layer_name a {@link java.lang.String} object.
     */
    public void set_layer(String p_layer_name)
    {
        if (!this.write_protected)
        {
            layer_field.setText(active_layer_string + p_layer_name);
        }
    }
    
    /**
     * <p>set_interactive_autoroute_info.</p>
     *
     * @param p_found a int.
     * @param p_not_found a int.
     * @param p_items_to_go a int.
     */
    public void set_interactive_autoroute_info(int p_found, int p_not_found, int p_items_to_go)
    {
        Integer found = p_found;
        Integer failed = p_not_found;
        Integer items_to_go = p_items_to_go;
        add_field.setText(resources.getString("to_route") + " " + items_to_go.toString());
        layer_field.setText(resources.getString("found") + " " + found.toString() + ", "
                + resources.getString("failed") + " " + failed.toString());
    }

    /**
     * <p>set_batch_autoroute_info.</p>
     *
     * @param p_items_to_go a int.
     * @param p_routed a int.
     * @param p_ripped a int.
     * @param p_failed a int.
     */
    public void set_batch_autoroute_info(int p_items_to_go, int p_routed, int p_ripped, int p_failed)
    {
        Integer ripped = p_ripped;
        Integer routed = p_routed;
        Integer items_to_go = p_items_to_go;
        Integer failed = p_failed;
        add_field.setText( resources.getString("to_route") + " " + items_to_go.toString() + ", "
                + resources.getString("routed") + " " + routed.toString() + ", ");
        layer_field.setText(resources.getString("ripped") + " " + ripped.toString() + ", "
                + resources.getString("failed") + " " + failed.toString());
    }
    
    /**
     * <p>set_batch_fanout_info.</p>
     *
     * @param p_pass_no a int.
     * @param p_components_to_go a int.
     */
    public void set_batch_fanout_info(int p_pass_no, int p_components_to_go)
    {
        Integer components_to_go = p_components_to_go;
        Integer pass_no = new  Integer(p_pass_no);
        add_field.setText(resources.getString("fanout_pass") + " " +  pass_no.toString() + ": ");
        layer_field.setText(resources.getString("still") + " " 
                + components_to_go.toString() + " " + resources.getString("components"));
    }
    
    /**
     * <p>set_post_route_info.</p>
     *
     * @param p_via_count a int.
     * @param p_trace_length a double.
     */
    public void set_post_route_info( int p_via_count, double p_trace_length)
    {
        Integer via_count = p_via_count;
        add_field.setText(resources.getString("via_count") + " " + via_count.toString());
        layer_field.setText(resources.getString("trace_length") + " " + this.number_format.format(p_trace_length));
    }
    
    /**
     * Sets the displayed layer of the nearest target item
     * in interactive routing.
     *
     * @param p_layer_name a {@link java.lang.String} object.
     */
    public void set_target_layer(String p_layer_name)
    {
        if (!(p_layer_name.equals(prev_target_layer_name) || this.write_protected))
        {
            add_field.setText(target_layer_string +  p_layer_name);
            prev_target_layer_name = p_layer_name;
        }
    }
    
    /**
     * <p>set_mouse_position.</p>
     *
     * @param p_pos a {@link geometry.planar.FloatPoint} object.
     */
    public void set_mouse_position(geometry.planar.FloatPoint p_pos)
    {
        if (p_pos == null || this.mouse_position == null || this.write_protected)
        {
            return;
        }
        this.mouse_position.setText(p_pos.to_string(this.locale));
    }
    
    /**
     * Clears the additional field, which is among others used to
     * display the layer of the nearest target item.
     */
    public void clear_add_field()
    {
        if (!this.write_protected)
        {
            add_field.setText(empty_string);
            prev_target_layer_name = empty_string;
        }
    }
    
    /**
     * Clears the status field and the additional field.
     */
    public void clear()
    {
        if (!this.write_protected)
        {
            status_field.setText(empty_string);
            clear_add_field();
            layer_field.setText(empty_string);
        }
    }
    
    /**
     * As long as write_protected is set to true, the set functions in this class will do nothing.
     *
     * @param p_value a boolean.
     */
    public void set_write_protected(boolean p_value)
    {
        write_protected = p_value;
    }
    
    private final java.util.ResourceBundle resources;
    private final java.util.Locale locale;
    private final String active_layer_string;
    private final String target_layer_string;
    static private final String empty_string = "            ";
    
    private JLabel add_field;
    private JLabel status_field;
    private JLabel layer_field;
    private JLabel mouse_position;
    private String prev_target_layer_name = empty_string;
    private boolean write_protected = false;
    
    /** The number format for displaying the trace lengtht */
    private final java.text.NumberFormat number_format;
}
