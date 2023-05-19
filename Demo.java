public class Demo
{
    public static void main(String[] args)
    {
        Sword sword = new Sword("a shiny sword", 100, 10000, 3);
        Sword shinierSword = new Sword("a shinier sword", 200, 10000, 3);
        Sword dragonTooth = new Sword("dragon's tooth", 2000, 100000, 5);
        Room finishRoom = new Room(null, null, null, null, "room", "An emptier room.", new Entity("Test enemy's enemy", 500, 0.7, 100, 20, shinierSword));
        Room testRoom = new Room(null, null, null, null, "testroom", "An empty room.", new Entity("Test enemy", 1, 0.7, 100, 5, sword));
        Room forest = new Room(null, null, finishRoom, null, "forest", "A tropical forest.",
                               new Entity("Dragon", 201, 0, 1000, 50, dragonTooth));
        finishRoom.setTreasure(new Item("Amazon Gift Card"));
        testRoom.setNorth(finishRoom);
        testRoom.setEast(testRoom);
        testRoom.setWest(testRoom);
        testRoom.setSouth(testRoom);
        finishRoom.setSouth(testRoom);
        finishRoom.setWest(forest);
        Playable player = new Playable("Romeo", 100, testRoom);
        player.setStamina(10000000);
        GameIO.introduction(player);
        while(true)
        {
            GameIO.say("\n" + player.getLocation().toString() + "\n");
            int curAction = GameIO.action();
            if (curAction == 1) {
                Room destination;
                try {
                    destination = player.getLocation().getNorth();
                    if (destination == null) {
                        System.out.print("\n");
                        GameIO.roomDNE();
                        continue;
                    }
                    player.setLocation(destination);
                } catch (Exception e) {
                }
                continue;
            }
            if (curAction == 2) {
                Room destination;
                try {
                    destination = player.getLocation().getSouth();
                    if (destination == null) {
                        System.out.print("\n");
                        GameIO.roomDNE();
                        continue;
                    }
                    player.setLocation(destination);
                } catch (Exception e) {
                }
                continue;
            }
            if (curAction == 3) {
                Room destination;
                try {
                    destination = player.getLocation().getEast();
                    if (destination == null) {
                        System.out.print("\n");
                        GameIO.roomDNE();
                        continue;
                    }
                    player.setLocation(destination);
                } catch (Exception e) {
                }
                continue;
            }
            if (curAction == 4) {
                Room destination;
                try {
                    destination = player.getLocation().getWest();
                    if (destination == null) {
                        System.out.print("\n");
                        GameIO.roomDNE();
                        continue;
                    }
                    player.setLocation(destination);
                } catch (Exception e) {
                }
                continue;
            }
            if (curAction == 5) {
                System.out.print("\n");
                if (!player.getLocation().getTreasure().isEmpty()) {
                    GameIO.getLoot(player.getLocation().getTreasure());
                    player.getLocation().getTreasure().forEach((x) -> {
                        player.addToInventory(x);
                    });
                } else {
                    GameIO.denyAction();
                }
            }
            if (curAction == 6) {
                System.out.print("\n");
                int index = GameIO.selection(player.getInventory());
                try {
                    if (player.getInventory().get(index - 1).getClass() == (new Sword(null, 0, 0, 0)).getClass()) {
                        player.setDefaultSword((Sword) player.getInventory().get(index - 1));
                        GameIO.equipSword((Sword) player.getInventory().get(index - 1));
                    }
                } catch (Exception e) {
                }
            }
            if (curAction == 7) {
                System.out.print("\n");
                int index = GameIO.combatSelection(player.getLocation().getEntities());
                try {
                    player.combat(player.getLocation().getEntities().get(index - 1));
                } catch (Exception e) {
                }
            }
            if (curAction == 8) {
                break;
            }
        }
    }
}
