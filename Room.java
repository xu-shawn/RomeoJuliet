import java.util.ArrayList;

public class Room
{
    private Room north, south, east, west;
    private String description;
    private String shortDescription;
    private ArrayList<Item> treasure = new ArrayList<Item>();
    ArrayList<Entity> entities = new ArrayList<Entity>();

    public Room(Room north, Room south, Room east, Room west, String shortDescription, String description, Entity... entity)
    {
            this.shortDescription = shortDescription;
            this.north = north;
            this.south = south;
            this.east = east;
            this.west = west;
            this.description = description;
            for(Entity e : entity)
                {
                    entities.add(e);
                }
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public ArrayList<Entity> getEntities()
    {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities)
    {
        this.entities = entities;
    }

    public ArrayList<Item> getTreasure()
    {
        return treasure;
    }

    public void setTreasure(ArrayList<Item> treasure)
    {
        this.treasure = treasure;
    }

    public void setTreasure(Item... treasure)
    {
        for(Item i : treasure)
            {
                this.treasure.add(i);
            }
    }

    public Room getWest()
    {
        return west;
    }

    public void setWest(Room west)
    {
        this.west = west;
    }

    public Room getEast()
    {
        return east;
    }

    public void setEast(Room east)
    {
        this.east = east;
    }

    public Room getSouth()
    {
        return south;
    }

    public void setSouth(Room south)
    {
        this.south = south;
    }

    public Room getNorth()
    {
        return north;
    }

    public void setNorth(Room north)
    {
        this.north = north;
    }

    public String getShortDescription()
    {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription)
    {
        this.shortDescription = shortDescription;
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(description);
        if(north != null)
            {
                s.append("\nTo the north there is a " + north.getShortDescription() + ".");
            }
        if (south != null)
            {
                s.append("\nTo the south there is a " + south.getShortDescription() + ".");
            }
        if (east != null)
            {
                s.append("\nTo the east there is a " + east.getShortDescription() + ".");
            }
        if (west != null)
            {
                s.append("\nTo the west there is a " + west.getShortDescription() + ".");
            }
        if(!entities.isEmpty())
            {
                s.append("\nIn the room you can see: ");
                entities.forEach((x) -> {
                    s.append(x.getName() + ", ");
                });
            }
        if(!treasure.isEmpty())
            {
                s.append("\nThe ground seems very soft.");
            }
        return s.toString();
    }
}
