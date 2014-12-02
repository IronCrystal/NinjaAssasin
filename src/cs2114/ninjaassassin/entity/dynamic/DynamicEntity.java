package cs2114.ninjaassassin.entity.dynamic;

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
        return tiles[Math.round(loc.getX())][Math.round(loc.getY())];
    }


    // ----------------------------------------------------------
    /**
     * Updates the entity
     */
    public abstract void update();

}
