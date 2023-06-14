public class Demo
{
    public static void main(String[] args)
    {
        // Sword sword = new Sword("a shiny sword", 100, 10000, 3);
        // Sword shinierSword = new Sword("a shinier sword", 200, 10000, 3);
        // Sword dragonTooth = new Sword("dragon's tooth", 2000, 100000, 5);
        // Room finishRoom = new Room(null, null, null, null, "room", "An emptier room.", new Entity("Test enemy's enemy", 500, 0.7, 100, 20, shinierSword));
        // Room testRoom = new Room(null, null, null, null, "testroom", "An empty room.", new Entity("Test enemy", 1, 0.7, 100, 5, sword));
        // Room forest = new Room(null, null, finishRoom, null, "forest", "A tropical forest.",
        //                        new Entity("Dragon", 201, 0, 1000, 50, dragonTooth));
        // finishRoom.setTreasure(new Item("Amazon Gift Card"));
        // testRoom.setNorth(finishRoom);
        // testRoom.setEast(testRoom);
        // testRoom.setWest(testRoom);
        // testRoom.setSouth(testRoom);
        // finishRoom.setSouth(testRoom);
        // finishRoom.setWest(forest);
        // Playable player = new Playable("Romeo", 100, testRoom);
        // player.setStamina(10000000);
        Room start = new Room(null, null, null, null, false, "cell", "You awaken in the depth of a catacomb, to the chilling echo of clattering bones, enveloping the air around you."),
            brick = new Room(null, null, null, null, false, "cell", "The air smells fresher."),
            collectible1 = new Room(null, null, null, null, false, "newly excavated cell", "A dead end"),
            ghost1 = new Room(null, null, null, null, true, "cell", "You see footprints on the sandy ground below", new Entity("Ghost of Tybalt", 10, 0.5, 100, 1, new Sword("a brick", 9, 1, 1))),
            skeleton1 = new Room(null, null, null, null, true, "cell", "You see blood on the ground.", new Entity("A skeleton", 10, 0.5, 10, 1, new Sword("a rusty sword", 10, 1000, 3))),
            empty1 = new Room(null, null, null, null, false, "cell", "You hear a rumbling sound below you."),
            empty2 = new Room(null, null, null, null, false, "cell", "You encounter a putrid smell."),
            empty3 = new Room(null, null, null, null, false, "cell", "You step onto something soft, but doesn't dare to investigate any further."),
            empty4 = new Room(null, null, null, null, false, "cell", "Nothing interesting here"),
            empty5 = new Room(null, null, null, null, false, "cell", "You see the remnant of a painting on the wall."),
            mazeEntrance = new Room(null, null, null, null, false, "cell", "The entrance of a maze, be careful of your choices, for once you choose a room to enter, there is no turning back!"),
            water = new Room(null, null, null, null, false, "chamber of water", "You relish the warm, moist air as it gently filling your lungs."),
            fire = new Room(null, null, null, null, false, "chamber of fire", "You step inside the room. An almost unbearable wave of blistering heat struck you."),
            silver = new Room(null, null, null, null, false, "chamber of silver", "The melodic clattering of silverware reverberates off the chamber wall, leaving you yearning for food."),
            gold = new Room(null, null, null, null, false, "chamber of gold", "A room decorated with luxurious ornaments, you try to grab as many gold cups and jewels as you can, but they all seem to be glued to the surface"),
            mercury = new Room(null, null, null, null, true, "chamber of mercury", "An acrid, unnatural smell assaults your nostril, making you vomit.", new Entity("Two-headed Skeleton", 50, 0.7, 100, 3, new Sword("a double-edged sword", 30, 2000, 1))),
            ghost2 = new Room(null, null, null, null, true, "chamber of ???", "You arrive at the end of maze. The air smells especially fresh.", new Entity("Six-eyed Ghost", 300, 0.9, 1000, 5)),
            exit = new Room(null, null, null, null, false, "the catacomb exit", "A strangely conspicuous hole on the ceiling.");

        start.setNorth(brick);
        brick.setSouth(start);
        brick.setWest(collectible1);
        brick.setEast(ghost1);
        collectible1.setEast(brick);
        ghost1.setWest(brick);
        ghost1.setNorth(skeleton1);
        skeleton1.setSouth(ghost1);
        skeleton1.setNorth(empty1);
        empty1.setSouth(skeleton1);
        empty1.setEast(empty2);
        empty2.setWest(empty1);
        empty2.setSouth(empty3);
        empty3.setNorth(empty2);
        empty3.setSouth(empty4);
        empty4.setNorth(empty3);
        empty4.setWest(ghost1);
        empty1.setNorth(empty5);
        empty5.setSouth(empty1);
        empty5.setNorth(mazeEntrance);
        mazeEntrance.setNorth(fire);
        mazeEntrance.setWest(water);
        water.setWest(silver);
        water.setNorth(mercury);
        fire.setWest(mercury);
        fire.setNorth(gold);
        silver.setNorth(gold);
        mercury.setNorth(ghost2);
        gold.setWest(ghost2);
        ghost2.setNorth(exit);
        exit.setSouth(ghost2);

        collectible1.setTreasure(new Item("Mercutio's skull"));

        Playable player = new Playable("Romeo", 100, start);
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
                    destination.playerArrive(player);
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
                    destination.playerArrive(player);
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
                    destination.playerArrive(player);
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
                    destination.playerArrive(player);
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
