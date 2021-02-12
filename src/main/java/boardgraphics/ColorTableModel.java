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
 * ColorTableModel.java
 *
 * Created on 5. August 2003, 10:18
 */
package boardgraphics;

import javax.swing.table.AbstractTableModel;

/**
 * Abstract class to store colors used for drawing the board.
 *
 * @author Alfons Wirtz
 * @version $Id: $Id
 */
public abstract class ColorTableModel extends AbstractTableModel
{

    /**
     * <p>Constructor for ColorTableModel.</p>
     *
     * @param p_row_count a int.
     * @param p_locale a {@link java.util.Locale} object.
     */
    protected ColorTableModel(int p_row_count, java.util.Locale p_locale)
    {
        this.data = new Object[p_row_count] [];
        this.locale = p_locale;
    }
    
    /**
     * <p>Constructor for ColorTableModel.</p>
     *
     * @param p_stream a {@link java.io.ObjectInputStream} object.
     * @throws java.io.IOException if any.
     * @throws java.lang.ClassNotFoundException if any.
     */
    protected ColorTableModel(java.io.ObjectInputStream p_stream)
            throws java.io.IOException, java.lang.ClassNotFoundException
    {
        this.data = (Object[][]) p_stream.readObject();
        this.locale = (java.util.Locale) p_stream.readObject();
    }

    /**
     * <p>getRowCount.</p>
     *
     * @return a int.
     */
    public int getRowCount()
    {
        return data.length;
    }

    /** {@inheritDoc} */
    public Object getValueAt(int p_row, int p_col)
    {
        return data[p_row][p_col];
    }

    /** {@inheritDoc} */
    public void setValueAt(Object p_value, int p_row, int p_col)
    {
        data[p_row][p_col] = p_value;
        fireTableCellUpdated(p_row, p_col);
    }

    /**
     * {@inheritDoc}
     *
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class<?> getColumnClass(int p_c)
    {
        return getValueAt(0, p_c).getClass();
    }

    
    /**
     * <p>write_object.</p>
     *
     * @param p_stream a {@link java.io.ObjectOutputStream} object.
     * @throws java.io.IOException if any.
     */
    protected void write_object(java.io.ObjectOutputStream p_stream)
            throws java.io.IOException
    {
        p_stream.writeObject(this.data);
        p_stream.writeObject(this.locale);
    }
    
    protected final Object[][] data;
    protected final java.util.Locale locale;
}
