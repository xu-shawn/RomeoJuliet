public class Playable extends Entity
{
    Sword defaultSword = new Sword("fist", 1, 100, 1);
    Room location;
    public Playable(String name, int health, Room location)
    {
        super(name, health);
        this.location = location;
    }

    public Playable(String name, int health, Room location, Item... initialItems)
    {
        super(name, health, initialItems);
        this.location = location;
    }

    public Sword getDefaultSword() {
        return defaultSword;
    }

    public void setDefaultSword(Sword defaultSword) {
        this.defaultSword = defaultSword;
    }

    public Room getLocation() {
        return location;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    public void setWeapon(Item i)
    {
        defaultSword = (Sword) i;
    }

    public void combat(Entity enemy)
    {
        GameIO.attackStart(enemy);
        boolean playerTurn = true, defenseReady = false;
        while(getHealth() > 0 && enemy.getHealth() > 0)
        {
            if(playerTurn)
                {
                    GameIO.say("\n" + toString() + "\n\n" + enemy.toString() + "\n\n");
                    defenseReady = false;
                    if(GameIO.attackSelection())
                        {
                            defaultSword.attack(enemy);
                            GameIO.attackMessage(this, enemy, defaultSword);
                        }
                    else
                        {
                            GameIO.defenseReadyMessage();
                            defenseReady = true;
                        }
                }
            else
                {
                    double rng = Math.random();
                    if(rng > enemy.getAttackThreshold())
                        {
                            if(defenseReady)
                                {
                                    GameIO.attackedMessage(enemy, this, enemy.getAttackDamage(), defenseReady);
                                }
                            else
                                {
                                    GameIO.attackedMessage(enemy, this, enemy.getAttackDamage() , defenseReady);
                                    this.setHealth(this.getHealth() - enemy.getAttackDamage());
                                }
                        }
                    else
                        {
                            GameIO.attackMiss(enemy);
                        }
                }
            playerTurn = !playerTurn;
        }
        if(getHealth() <= 0)
            {
                GameIO.playerDie();
            }
        else
            {
                GameIO.enemyDie(enemy);
                GameIO.getLoot(enemy.getInventory());
                enemy.die(this);
            }
    }
}
