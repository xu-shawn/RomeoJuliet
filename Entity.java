import java.util.ArrayList;

public class Entity
{
    protected String name;
    protected int health = 0;
    protected ArrayList<Item> inventory = new ArrayList<Item>();
    protected int stamina;

    private double attackThreshold;
    private int attackDamage;

    public Entity(String name, int health)
    {
        this.name = name;
        this.health = health;
    }

    public Entity(String name, int health, double attackThreshold, int stamina, int attackDamage)
    {
        this.name = name;
        this.health = health;
        this.attackThreshold = attackThreshold;
        this.stamina = stamina;
        this.attackDamage = attackDamage;
    }

    public Entity(String name, int health, double attackThreshold, int stamina, int attackDamage, Item... initialItems)
    {
        this.name = name;
        this.health = health;
        this.attackThreshold = attackThreshold;
        this.stamina = stamina;
        this.attackDamage = attackDamage;
        for (Item x : initialItems)
        {
            inventory.add(x);
        }
    }

    public Entity(String name, int health, Item... initialItems) {
        this(name, health);
        for (Item x : initialItems) {
            inventory.add(x);
        }
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public int getStamina()
    {
        return stamina;
    }

    public void setStamina(int stamina)
    {
        this.stamina = stamina;
    }

    public double getAttackThreshold()
    {
        return attackThreshold;
    }

    public void setAttackThreshold(double attackThreshold)
    {
        this.attackThreshold = attackThreshold;
    }

    public void addToInventory(Item... item)
    {
        for(Item x : item)
            {
                inventory.add(x);
            }
        //        item.setOwner(this);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void incrementHealth(int amount)
    {
        health += amount;
    }

    public void decrementHealth(int amount)
    {
        health -= amount;
    }

    public void die(Entity receiver)
    {
        this.inventory.forEach((n) -> receiver.addToInventory(n));
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(getName() + "'s overview:\n");
        str.append("Health: " + getHealth());
        str.append("\nStamina: " + getStamina());
        return str.toString();
    }
}
