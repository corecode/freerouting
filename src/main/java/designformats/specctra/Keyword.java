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
 * Keyword.java
 *
 * Created on 8. Mai 2004, 10:23
 */
package designformats.specctra;

/**
 * Enumeration class for keywords of the specctra dsn file format
 *
 * @author  alfons
 * @version $Id: $Id
 */
public class Keyword
{

    /**
     * The only instances of the internal classes:
     *
     * ScopeKeywords  with an inividual read_scope method are defined in an extra class,
     */
    public static final Keyword ABSOLUTE = new Keyword("absolute");
    /** Constant <code>ACTIVE</code> */
    public static final Keyword ACTIVE = new Keyword("active");
    /** Constant <code>AGAINST_PREFERRED_DIRECTION_TRACE_COSTS</code> */
    public static final Keyword AGAINST_PREFERRED_DIRECTION_TRACE_COSTS = new Keyword("against_preferred_direction_trace_costs");
    /** Constant <code>ATTACH</code> */
    public static final Keyword ATTACH = new Keyword("attach");
    /** Constant <code>AUTOROUTE</code> */
    public static final Keyword AUTOROUTE = new Keyword("autoroute");
    /** Constant <code>AUTOROUTE_SETTINGS</code> */
    public static final Keyword AUTOROUTE_SETTINGS = new Keyword("autoroute_settings");
    /** Constant <code>BACK</code> */
    public static final Keyword BACK = new Keyword("back");
    /** Constant <code>BOUNDARY</code> */
    public static final Keyword BOUNDARY = new Keyword("boundary");
    /** Constant <code>CIRCUIT</code> */
    public static final Keyword CIRCUIT = new Keyword("circuit");
    /** Constant <code>CIRCLE</code> */
    public static final Keyword CIRCLE = new Keyword("circle");
    /** Constant <code>CLASS</code> */
    public static final Keyword CLASS = new Keyword("class");
    /** Constant <code>CLASS_CLASS</code> */
    public static final Keyword CLASS_CLASS = new Keyword("class_class");
    /** Constant <code>CLASSES</code> */
    public static final Keyword CLASSES = new Keyword("classes");
    /** Constant <code>COMPONENT_SCOPE</code> */
    public static final ScopeKeyword COMPONENT_SCOPE = new Component();
    /** Constant <code>CONSTANT</code> */
    public static final Keyword CONSTANT = new Keyword("constant");
    /** Constant <code>CONTROL</code> */
    public static final Keyword CONTROL = new Keyword("control");
    /** Constant <code>CLEARANCE</code> */
    public static final Keyword CLEARANCE = new Keyword("clearance");
    /** Constant <code>CLEARANCE_CLASS</code> */
    public static final Keyword CLEARANCE_CLASS = new Keyword("clearance_class");
    /** Constant <code>CLOSED_BRACKET</code> */
    public static final Keyword CLOSED_BRACKET = new Keyword(")");
    /** Constant <code>FANOUT</code> */
    public static final Keyword FANOUT = new Keyword("fanout");
    /** Constant <code>FLIP_STYLE</code> */
    public static final Keyword FLIP_STYLE = new Keyword("flip_style");
    /** Constant <code>FIX</code> */
    public static final Keyword FIX = new Keyword("fix");
    /** Constant <code>FORTYFIVE_DEGREE</code> */
    public static final Keyword FORTYFIVE_DEGREE = new Keyword("fortyfive_degree");
    /** Constant <code>FROMTO</code> */
    public static final Keyword FROMTO = new Keyword("fromto");
    /** Constant <code>FRONT</code> */
    public static final Keyword FRONT = new Keyword("front");
    /** Constant <code>GENERATED_BY_FREEROUTE</code> */
    public static final Keyword GENERATED_BY_FREEROUTE = new Keyword("generated_by_freeroute");
    /** Constant <code>HORIZONTAL</code> */
    public static final Keyword HORIZONTAL = new Keyword("horizontal");
    /** Constant <code>HOST_CAD</code> */
    public static final Keyword HOST_CAD = new Keyword("host_cad");
    /** Constant <code>HOST_VERSION</code> */
    public static final Keyword HOST_VERSION = new Keyword("host_version");
    /** Constant <code>IMAGE</code> */
    public static final Keyword IMAGE = new Keyword("image");
    /** Constant <code>KEEPOUT</code> */
    public static final Keyword KEEPOUT = new Keyword("keepout");
    /** Constant <code>LAYER</code> */
    public static final Keyword LAYER = new Keyword("layer");
    /** Constant <code>LAYER_RULE</code> */
    public static final Keyword LAYER_RULE = new Keyword("layer_rule");
    /** Constant <code>LENGTH</code> */
    public static final Keyword LENGTH = new Keyword("length");
    /** Constant <code>LIBRARY_SCOPE</code> */
    public static final ScopeKeyword LIBRARY_SCOPE = new Library();
    /** Constant <code>LOCK_TYPE</code> */
    public static final Keyword LOCK_TYPE = new Keyword("lock_type");
    /** Constant <code>LOGICAL_PART</code> */
    public static final Keyword LOGICAL_PART = new Keyword("logical_part");
    /** Constant <code>LOGICAL_PART_MAPPING</code> */
    public static final Keyword LOGICAL_PART_MAPPING = new Keyword("logical_part_mapping");
    /** Constant <code>NET</code> */
    public static final Keyword NET = new Keyword("net");
    /** Constant <code>NETWORK_OUT</code> */
    public static final Keyword NETWORK_OUT = new Keyword("network_out");
    /** Constant <code>NETWORK_SCOPE</code> */
    public static final ScopeKeyword NETWORK_SCOPE = new Network();
    /** Constant <code>NINETY_DEGREE</code> */
    public static final Keyword NINETY_DEGREE = new Keyword("ninety_degree");
    /** Constant <code>NONE</code> */
    public static final Keyword NONE = new Keyword("none");
    /** Constant <code>NORMAL</code> */
    public static final Keyword NORMAL = new Keyword("normal");
    /** Constant <code>OFF</code> */
    public static final Keyword OFF = new Keyword("off");
    /** Constant <code>ON</code> */
    public static final Keyword ON = new Keyword("on");
    /** Constant <code>OPEN_BRACKET</code> */
    public static final Keyword OPEN_BRACKET = new Keyword("(");
    /** Constant <code>ORDER</code> */
    public static final Keyword ORDER = new Keyword("order");
    /** Constant <code>OUTLINE</code> */
    public static final Keyword OUTLINE = new Keyword("outline");
    /** Constant <code>PADSTACK</code> */
    public static final Keyword PADSTACK = new Keyword("padstack");
    /** Constant <code>PART_LIBRARY_SCOPE</code> */
    public static final ScopeKeyword PART_LIBRARY_SCOPE = new PartLibrary();
    /** Constant <code>PARSER_SCOPE</code> */
    public static final ScopeKeyword PARSER_SCOPE = new Parser();
    /** Constant <code>PCB_SCOPE</code> */
    public static final ScopeKeyword PCB_SCOPE = new ScopeKeyword("pcb");
    /** Constant <code>PIN</code> */
    public static final Keyword PIN = new Keyword("pin");
    /** Constant <code>PINS</code> */
    public static final Keyword PINS = new Keyword("pins");
    /** Constant <code>PLACE</code> */
    public static final Keyword PLACE = new Keyword("place");
    /** Constant <code>PLACE_CONTROL</code> */
    public static final ScopeKeyword PLACE_CONTROL = new PlaceControl();
    /** Constant <code>PLACE_KEEPOUT</code> */
    public static final Keyword PLACE_KEEPOUT = new Keyword("place_keepout");
    /** Constant <code>PLACEMENT_SCOPE</code> */
    public static final ScopeKeyword PLACEMENT_SCOPE = new Placement();
    /** Constant <code>PLANE_SCOPE</code> */
    public static final ScopeKeyword PLANE_SCOPE = new Plane();
    /** Constant <code>PLANE_VIA_COSTS</code> */
    public static final Keyword PLANE_VIA_COSTS = new Keyword("plane_via_costs");
    /** Constant <code>PREFERRED_DIRECTION</code> */
    public static final Keyword PREFERRED_DIRECTION = new Keyword("preferred_direction");
    /** Constant <code>PREFERRED_DIRECTION_TRACE_COSTS</code> */
    public static final Keyword PREFERRED_DIRECTION_TRACE_COSTS = new Keyword("preferred_direction_trace_costs");
    /** Constant <code>SNAP_ANGLE</code> */
    public static final Keyword SNAP_ANGLE = new Keyword("snap_angle");
    /** Constant <code>POLYGON</code> */
    public static final Keyword POLYGON = new Keyword("polygon");
    /** Constant <code>POLYGON_PATH</code> */
    public static final Keyword POLYGON_PATH = new Keyword("polygon_path");
    /** Constant <code>POLYLINE_PATH</code> */
    public static final Keyword POLYLINE_PATH = new Keyword("polyline_path");
    /** Constant <code>POSITION</code> */
    public static final Keyword POSITION = new Keyword("position");
    /** Constant <code>POSTROUTE</code> */
    public static final Keyword POSTROUTE = new Keyword("postroute");
    /** Constant <code>POWER</code> */
    public static final Keyword POWER = new Keyword("power");
    /** Constant <code>PULL_TIGHT</code> */
    public static final Keyword PULL_TIGHT = new Keyword("pull_tight");
    /** Constant <code>RECTANGLE</code> */
    public static final Keyword RECTANGLE = new Keyword("rectangle");
    /** Constant <code>RESOLUTION_SCOPE</code> */
    public static final Keyword RESOLUTION_SCOPE = new Resolution();
    /** Constant <code>ROTATE</code> */
    public static final Keyword ROTATE = new Keyword("rotate");
    /** Constant <code>ROTATE_FIRST</code> */
    public static final Keyword ROTATE_FIRST = new Keyword("rotate_first");
    /** Constant <code>ROUTES</code> */
    public static final Keyword ROUTES = new Keyword("routes");
    /** Constant <code>RULE</code> */
    public static final Keyword RULE = new Keyword("rule");
    /** Constant <code>RULES</code> */
    public static final Keyword RULES = new Keyword("rules");
    /** Constant <code>SESSION</code> */
    public static final Keyword SESSION = new Keyword("session");
    /** Constant <code>SHAPE</code> */
    public static final Keyword SHAPE = new Keyword("shape");
    /** Constant <code>SHOVE_FIXED</code> */
    public static final Keyword SHOVE_FIXED = new Keyword("shove_fixed");
    /** Constant <code>SIDE</code> */
    public static final Keyword SIDE = new Keyword("side");
    /** Constant <code>SIGNAL</code> */
    public static final Keyword SIGNAL = new Keyword("signal");
    /** Constant <code>SPARE</code> */
    public static final Keyword SPARE = new Keyword("spare");
    /** Constant <code>START_PASS_NO</code> */
    public static final Keyword START_PASS_NO = new Keyword("start_pass_no");
    /** Constant <code>START_RIPUP_COSTS</code> */
    public static final Keyword START_RIPUP_COSTS = new Keyword("start_ripup_costs");
    /** Constant <code>STRING_QUOTE</code> */
    public static final Keyword STRING_QUOTE = new Keyword("string_quote");
    /** Constant <code>STRUCTURE_SCOPE</code> */
    public static final ScopeKeyword STRUCTURE_SCOPE = new Structure();
    /** Constant <code>TYPE</code> */
    public static final Keyword TYPE = new Keyword("type");
    /** Constant <code>USE_LAYER</code> */
    public static final Keyword USE_LAYER = new Keyword("use_layer");
    /** Constant <code>USE_NET</code> */
    public static final Keyword USE_NET = new Keyword("use_net");
    /** Constant <code>USE_VIA</code> */
    public static final Keyword USE_VIA = new Keyword("use_via");
    /** Constant <code>VERTICAL</code> */
    public static final Keyword VERTICAL = new Keyword("vertical");
    /** Constant <code>VIA</code> */
    public static final Keyword VIA = new Keyword("via");
    /** Constant <code>VIAS</code> */
    public static final Keyword VIAS = new Keyword("vias");
    /** Constant <code>VIA_AT_SMD</code> */
    public static final Keyword VIA_AT_SMD = new Keyword("via_at_smd");
    /** Constant <code>VIA_COSTS</code> */
    public static final Keyword VIA_COSTS = new Keyword("via_costs");
    /** Constant <code>VIA_KEEPOUT</code> */
    public static final Keyword VIA_KEEPOUT = new Keyword("via_keepout");
    /** Constant <code>VIA_RULE</code> */
    public static final Keyword VIA_RULE = new Keyword("via_rule");
    /** Constant <code>WIDTH</code> */
    public static final Keyword WIDTH = new Keyword("width");
    /** Constant <code>WINDOW</code> */
    public static final Keyword WINDOW = new Keyword("window");
    /** Constant <code>WIRE</code> */
    public static final Keyword WIRE = new Keyword("wire");
    /** Constant <code>WIRING_SCOPE</code> */
    public static final ScopeKeyword WIRING_SCOPE = new Wiring();
    /** Constant <code>WRITE_RESOLUTION</code> */
    public static final Keyword WRITE_RESOLUTION = new Keyword("write_resolution");

    /**
     * Returns the name string of this Keyword.
     * The name is used for debugging purposes.
     *
     * @return a {@link java.lang.String} object.
     */
    public String get_name()
    {
        return name;
    }
    private final String name;

    /**
     * prevents creating more instances
     *
     * @param p_name a {@link java.lang.String} object.
     */
    protected Keyword(String p_name)
    {
        name = p_name;
    }
}
