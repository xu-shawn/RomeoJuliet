public class Item
{
    private String description;
    //    private Entity owner;

    public Item(String description/*, Entity owner*/)
    {
        //    this.owner = owner;
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    // public Entity getOwner()
    // {
    //     return owner;
    // }

    // public void setOwner(Entity owner)
    // {
    //     this.owner = owner;
    // }
}
