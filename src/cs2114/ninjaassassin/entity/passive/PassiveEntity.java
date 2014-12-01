package cs2114.ninjaassassin.entity.passive;

import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.entity.Entity;

// -------------------------------------------------------------------------
/**
 * Class represents a passive entity. A passive entity is an entity in the room
 * which does not act, but can be acted upon. Instances include walls,
 * obstacles, or power-ups.
 *
 * @author Andrew Peace
 * @author Elliott Fairhurst
 * @version Nov 1, 2014
 */
public abstract class PassiveEntity
    extends Entity
{

    private float addHealth;
    private float addSpeed;


    // ----------------------------------------------------------
    /**
     * Create a new PassiveEntity object with basic entity properties to be used
     * as an obstacle.
     *
     * @param loc
     *            The location of the entity
     * @param imageName
     *            The name of the entity's image
     * @param size
     *            The size of the entity
     */
    public PassiveEntity(Location loc, String imageName, int size)
    {
        super(loc);
        addHealth = 0;
        addSpeed = 0;
    }


    // ----------------------------------------------------------
    /**
     * Create a new PassiveEntity object with additional health and additional
     * speed values for use in power-ups.
     *
     * @param loc
     *            The location of the entity
     * @param addHealth
     *            The additional health the entity provides to an active entity
     *            upon contact
     * @param addSpeed
     *            The additional speed the entity provides to an active entity
     *            upon contact
     */
    public PassiveEntity(
        Location loc,
        float addHealth,
        float addSpeed)
    {
        super(loc);
        this.addHealth = addHealth;
        this.addSpeed = addSpeed;
    }


    // ----------------------------------------------------------
    /**
     * Sets the amount of additional health the entity can provide to an active
     * entity.
     *
     * @param addHealth
     *            The additional health offered by the entity
     */
    public void setAddHealth(float addHealth)
    {
        this.addHealth = addHealth;
    }


    // ----------------------------------------------------------
    /**
     * Sets the amount of additional speed the entity can provide to an active
     * entity.
     *
     * @param addSpeed
     *            The additional speed offered by the entity
     */
    public void setAddSpeed(float addSpeed)
    {
        this.addSpeed = addSpeed;
    }


    // ----------------------------------------------------------
    /**
     * Gets the amount of additional health the entity can provide to an active
     * entity.
     *
     * @return The additional health offered by the entity
     */
    public float getAddHealth()
    {
        return addHealth;
    }


    // ----------------------------------------------------------
    /**
     * Gets the amount of additional speed the entity can provide to an active
     * entity.
     *
     * @return The additional speed offered by the entity
     */
    public float getAddSpeed()
    {
        return addSpeed;
    }

}
