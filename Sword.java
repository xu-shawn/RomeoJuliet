public class Sword extends Item
{
    private int damage;
    private int durability;
    private int breakability = 1;
    public Sword(String description, int damage, int durability, int breakability)
    {
        super(description);
        this.durability = durability;
        this.damage = damage;
        this.breakability = breakability;
    }

    public int getBreakability()
    {
        return breakability;
    }

    public void setBreakability(int breakability)
    {
        this.breakability = breakability;
    }

    public int getDurability()
    {
        return durability;
    }

    public void setDurability(int durability)
    {
        this.durability = durability;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public int attack(Entity receiver)
    {
        try
            {
                receiver.decrementHealth(damage);
                durability -= breakability;
                if(durability <= 0)
                    {
                        damage = 0;
                        GameIO.itemBreak(this);
                        this.setDescription("(Broken) " + getDescription());
                        return 0;
                    }
                    return 1;
            }
        catch (Exception e)
            {
                return -1;
            }
    }
}
