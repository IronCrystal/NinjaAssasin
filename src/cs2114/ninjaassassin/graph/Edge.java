package cs2114.ninjaassassin.graph;

import cs2114.ninjaassassin.world.Location;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Elliott
 * @version Nov 29, 2014
 */

public class Edge
{
    private Location dest;  // The destination vertex for an edge
    private Location source; // The source vertex for an edge
    private float    weight; // The weight


    // ----------------------------------------------------------
    /**
     * Create a new Edge object with a source and destination.
     *
     * @param source
     *            The source vertex
     * @param dest
     *            The destination vertex
     */
    public Edge(Location source, Location dest)
    {
        this.source = source;
        this.dest = dest;
        weight = (float)Math.sqrt((dest.getX() - source.getX())/(dest.getY() - source.getY()));
    }


    // ----------------------------------------------------------
    /**
     * Create a new Edge object with a source, destination, and weight.
     *
     * @param source
     *            The source vertex
     * @param dest
     *            The destination vertex
     * @param w
     *            The weight
     */
    public Edge(Location source, Location dest, float w)
    {
        this.source = source;
        this.dest = dest;
        this.weight = w;
    }


    // ----------------------------------------------------------
    /**
     * Compares a given object to this object
     *
     * @param o
     *            The object to be compared
     * @return true if the given object is equal to this object
     */
    public boolean equals(Object o)
    {
        if (o.getClass().equals(this.getClass()))
        {
            Edge edge = (Edge)o;
            if ((edge.getDest() == this.getDest())
                && (edge.getSource() == this.getSource())
                && (edge.getWeight() == this.getWeight()))
            {
                return true;
            }
            return false;
        }
        return false;
    }


    // ----------------------------------------------------------
    /**
     * Gets the destination vertex
     *
     * @return The destination vertex
     */
    public int getDest()
    {
        return dest;
    }


    // ----------------------------------------------------------
    /**
     * Gets the source vertex
     *
     * @return The source vertex
     */
    public int getSource()
    {
        return source;
    }


    // ----------------------------------------------------------
    /**
     * Gets the weight
     *
     * @return The weight
     */
    public double getWeight()
    {
        return weight;
    }


    /**
     * Returns a string representation of the Edge.
     *
     * @return a string representation of the Edge
     */
    public String toString()
    {
        return null;

    }
}
