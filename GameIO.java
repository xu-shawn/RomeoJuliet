import java.util.ArrayList;
import java.util.Scanner;

public class GameIO
{
    public static Scanner scanner = new Scanner(System.in);
    public static void say(String input)
    {
        for(int i = 0;i < input.length();i ++)
            {
                System.out.print(input.charAt(i));
                try
                    {Thread.sleep((long) 10);}
                catch(Exception e)
                    {
                        System.out.println(e);
                    }
            }
    }

    public static int action()
    {
        say("What would you like to do?\n");
        System.out.println("1. Go north\n2. Go south\n3. Go east\n4. Go west");
        System.out.print("5. Dig down\n6. Use/Equip items\n7. Fight\n8. Quit\n> ");
        int action;
        try
            {
                action = Integer.parseInt(scanner.nextLine());
            }
        catch (Exception e)
        {
            return -1;
        }
        return action;
    }

    public static int selection(ArrayList<Item> input)
    {
        say("Select item to use:\n");
        for (int i = 1; i <= input.size();i ++)
            {
                say(i + ": " + input.get(i - 1).getDescription() + "\n");
            }
            System.out.print("> ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
        System.out.print("\n");
        return index;
    }

    public static int combatSelection(ArrayList<Entity> input)
    {
        say("Who do you want to fight?\n");
        for (int i = 1; i <= input.size();i ++)
            {
                say(i + ": " + input.get(i - 1).getName() + "\n");
            }
            System.out.print("> ");
        int index;
        try {
            index = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
        System.out.print("\n");
        return index;
    }

    public static void getLoot(ArrayList<Item> input)
    {
        say("Well done! You get: ");
        input.forEach((x) -> say(x.getDescription() + ", "));
        say("\n");
    }

    public static void itemBreak(Item item)
    {
        say("The " + item.getDescription() + " broke!\n");
    }

    public static boolean attackSelection()
    {
        say("Choose action:\n1. Attack\n2. Defend\n");
        System.out.print("> ");
        int index;
        while(true)
            {
                try
                    {
                        index = Integer.parseInt(scanner.nextLine());
                        if(index != 1 && index != 2)
                            {
                                throw new Exception("That's not an option!");
                            }
                        break;
                    }
                catch (Exception e)
                    {
                        say("\nThat's not an option!\n\n> ");
                    }
            }
        System.out.print("\n");
        return index == 1;
    }

    public static void attackMessage(Entity aggressor, Entity defender, Sword i)
    {
        say(aggressor.getName() + " dealt " + i.getDamage() + " points of damage to " + defender.getName() + " using " + i.getDescription() + ".\n");
    }

    public static void defenseReadyMessage()
    {
        say("You readied your defense.\n");
        System.out.print("\n");
    }

    public static void attackedMessage(Entity aggressor, Entity defender, int damage, boolean defense)
    {
        say(aggressor.getName() + " dealt " + damage + " points of damage to " + defender.getName() + ".");
        if(defense)
            {
                say(" But " + defender.getName() + " blocked the attack and negated the damage!\n");
            }
        System.out.println();
    }

    public static void playerDie()
    {
        say("You died!");
        scanner.close();
        while(true) {}
    }

    public static void enemyDie(Entity enemy)
    {
        say(enemy.getName() + " died.\n");
    }

    public static void attackMiss(Entity enemy)
    {
        say(enemy.getName() + " attacked and missed!\n");
    }

    public static void attackStart(Entity enemy)
    {
        say(enemy.getName() + " attempted to attack you!\n");
    }

    public static void introduction(Playable player)
    {
        say("You are " + player.getName() + "\n");
    }

    public static void equipSword(Sword sword)
    {
        say("Set \"" + sword.getDescription() + "\" as your default sword.\n");
    }

    public static void roomDNE()
    {
        say("You can't go there!\n");
    }

    public static void denyAction()
    {
        say("You can't do that here!\n");
    }
}
