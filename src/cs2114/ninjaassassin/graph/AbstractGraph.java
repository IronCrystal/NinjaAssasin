package cs2114.ninjaassassin.graph;

import cs2114.ninjaassassin.world.Location;
import java.util.HashMap;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Andrew Peace
 * @author Elliott Fairhurst
 * @version Nov 29, 2014
 */

public abstract class AbstractGraph
    implements Graph
{
    // Data Fields
    /** The number of vertices */
    private int     numV;
    /** Flag to indicate whether this is a directed graph */
    private boolean directed;
    private HashMap<Integer, Location> locMap;


    // ----------------------------------------------------------
    /**
     * Create a new AbstractGraph object.
     *
     * @param numV
     *            The number of vertices
     * @param directed
     *            Flag to indicate whether this is a directed graph
     */
    public AbstractGraph(int numV, boolean directed)
    {
        this.numV = numV;
        this.directed = directed;
        locMap = new HashMap<Integer, Location>();
        //locMap.
    }


    // ----------------------------------------------------------
    public int getNumV()
    {
        return numV;
    }


    // ----------------------------------------------------------
    public boolean isDirected()
    {
        return directed;
    }



}
