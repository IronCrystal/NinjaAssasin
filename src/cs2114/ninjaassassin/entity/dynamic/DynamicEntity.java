package cs2114.ninjaassassin.entity.dynamic;

import android.util.Log;
import cs2114.ninjaassassin.world.tile.TileType;
import cs2114.ninjaassassin.world.tile.Tile;
import cs2114.ninjaassassin.world.Room;
import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.entity.Entity;

// -------------------------------------------------------------------------
/**
 * Class represents an active entity. An active entity is anything that moves.
 *
 * @author Andrew Peace
 * @author Elliott Fairhurst
 * @version Nov 1, 2014
 */
public abstract class DynamicEntity
extends Entity
{

    private float speed;
    private float health;
    private float lethality;
    private Room  room;
    private float length;


    // ----------------------------------------------------------
    /**
     * Create a new DynamicEntity object.
     *
     * @param loc
     *            The location of the entity
     * @param speed
     *            The speed at which the entity can move
     * @param health
     *            The health of the entity
     * @param lethality
     *            The lethality of the entity
     * @param room
     *            The room in which the entity exists
     */
    public DynamicEntity(
        Location loc,
        float speed,
        float health,
        float lethality,
        Room room)
    {
        super(loc);
        this.speed = speed;
        this.health = health;
        this.lethality = lethality;
        this.room = room;
    }


    // ----------------------------------------------------------
    /**
     * Gets the health of the entity.
     *
     * @return The health of the entity.
     */
    public float getHealth()
    {
        return health;
    }


    // ----------------------------------------------------------
    /**
     * Gets the speed of the entity.
     *
     * @return The speed of the entity
     */
    public float getSpeed()
    {
        return speed;
    }


    // ----------------------------------------------------------
    /**
     * Gets the lethality of the entity, which is the amount of health
     * subtracted from another entity each time it is attacked.
     *
     * @return The lethality of the entity
     */
    public float getLethality()
    {
        return lethality;
    }


    // ----------------------------------------------------------
    /**
     * Sets the health of the entity, which determines how many times it can get
     * attacked (also depending on the lethality of the attacker) before it
     * dies.
     *
     * @param health
     *            The health of the entity.
     */
    public void setHealth(float health)
    {
        this.health = health;
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Sets the speed of the entity.
     *
     * @param speed
     *            The speed of the entity
     */
    public void setSpeed(float speed)
    {
        this.speed = speed;
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Sets the lethality of the entity, which is the health subtracted from
     * another entity in one attack.
     *
     * @param lethality
     *            The health subtracted from another entity in one attack
     */
    public void setLethality(float lethality)
    {
        this.lethality = lethality;
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Gets the room in which the entity exists
     *
     * @return The room in which the entity exists
     */
    public Room getRoom()
    {
        return room;
    }


    // ----------------------------------------------------------
    /**
     * Attacks a given active entity, reducing its health according to the
     * lethality (health subtracted per attack) of this entity.
     *
     * @param target
     *            The entity to attack
     */
    public void attack(DynamicEntity target)
    {
        target.setHealth(target.getHealth() - lethality);
    }


    // ----------------------------------------------------------
    /**
     * Returns the Tile at a given Location
     *
     * @param loc
     *            The Location
     * @return The Tile
     */
    public Tile tileAt(Location loc)
    {
        Tile[][] tiles = room.getTileMap();
        return tiles[(int) Math.floor(loc.getY())][(int) Math.floor(loc.getX())];
    }

    // ----------------------------------------------------------
    /**
     * Returns whether the entity can move to the specified location
     * @param loc The location in question
     * @return true if allowed
     */
    public boolean canMoveTo(Location loc) {
        Tile[][] tiles = room.getTileMap();
        float x1 = loc.getX(); //Top Left Corner
        float y1 = loc.getY();
        float x2 = x1 + 1; //Top Right Corner
        float y2 = y1;
        float x3 = x1; //Bottom Left Corner
        float y3 = y1 + 1;
        float x4 = x1 + 1; //Bottom Right Corner
        float y4 = y1 + 1;

        boolean b1, b2, b3, b4 = false;
        try {
            Log.i("DynamicEntity", "The size of tiles " + tiles.length);
            Log.i("DynamicEntity", "The tile at the starting location is " + tiles[18][6]);
            Log.i("DynamicEntity", "The tile at the ninja starting location is " + tiles[8][7]);
            Log.i("DynamicEntity", "The tile at a random location is " + tiles[9][7]);
            b1 = tiles[(int) Math.floor(y1)][(int) Math.floor(x1)].getType() == TileType.PATH;
            b2 = tiles[(int) Math.floor(y2)][(int) Math.floor(x2)].getType() == TileType.PATH;
            b3 = tiles[(int) Math.floor(y3)][(int) Math.floor(x3)].getType() == TileType.PATH;
            b4 = tiles[(int) Math.floor(y4)][(int) Math.floor(x4)].getType() == TileType.PATH;
            return b1 && b2 && b3 && b4;
        }catch(ArrayIndexOutOfBoundsException ex) {
            return false;
        }
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getLength() {
        return length;
    }


    // ----------------------------------------------------------
    /**
     * Updates the entity
     */
    public abstract void update();

}
