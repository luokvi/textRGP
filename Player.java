import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Player {
	
	private static Hero hero;
	
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void newHero () {
		
		print("Your name? ");
		String name = keyboard.nextLine();
		
		hero = new Hero(name, 30, 10, 5, 5, 5, 5);
		
		 Element randElem = Element.values()[new Random().nextInt(Element.values().length)];
		 while (randElem == Element.physical || randElem == Element.healing) {
			 randElem = Element.values()[new Random().nextInt(Element.values().length)];
		 }
		 
		Attack attack = new Attack (10, randElem, 3);
		hero.addAttack(attack);
		
		Potion potion = new Potion(15, 0);
		hero.addItem(potion);
		potion = new Potion(0, 10);
		hero.addItem(potion);
		
	}
	
	public static Hero getHero () {
		return hero;
	}
	
	
	public static void newRoom() {
		Room room = new Room();
		room.enter();
		
		endOfRoom();
	}
	
	private static void endOfRoom () {
		while(true) {
			
			print("Move to the next room? y/n");
			print("-----");
			print(hero.fightInfo());
			print("(1) items \t(2) magic \t(3) equipment");
			
			String string = keyboard.nextLine();
			
			if(string.equals("y")) {
				newRoom();
				break;
			}
			if(string.equals("1")) {
				useItems();
				continue;
			}
			if (string.equals("2")) {
				openMagic();
				continue;
			}
			if (string.equals("3")) {
				openEquipment();
				continue;
			}
	
		}
	}

	
	public static void newFight(Enemy enemy) {
		
		new Fight(enemy);
	}
	
	public static void newChest (TreasureChest chest) {
		print("Open it? y/n");
		String answer = keyboard.nextLine();
		if (answer.equals("y")) {
			print(chest.show());
			
			print("Take items? y/n");
			String take = keyboard.nextLine();
			if (take.equals("y")) {
				
				hero.addItems(chest.take());
				
			}
			return;
			
		}else {
			return;
		}
	}
	
	public static void chooseAction () {
		print("Choose an action: \n(1) Attack \t(2) Magic \t(3) Items \t(4) Flee");
		
		while (true) {
			
			int action = keyboard.nextInt();
			
			if (action == 1) {
				hero.doPhysicalAttack();
				print("Attacking!");
				
				break;
			}
			if (action == 2) {
				useMagicInFight();
				
				break;
			}
			if (action == 3) {
				useItemsInFight();
				
				break;
			}
			
			if (action == 4) {
				
				print("Fleeing...");
				hero.defeat();
				endOfRoom();
			}
		}
	}
	
	private static void useItemsInFight() {
		boolean b = useItems();
		
		if (!b) {
			chooseAction();
		}
		
		return;
	}
	
	private static boolean useItems() {
		List<Itemable> items = hero.getItems();
		
		int i = 1;
		String string = "";
		for (Itemable item : items) {
			string += "(" + i + ") " + item.show() + "\n";
			i++;
		}
		print("(0) return");
		print(string);
		
		
		while(true) {
			int index = keyboard.nextInt();
			
			if(index == 0) {
				return false;
			}
			
			index -= 1;
			
			items.get(index).Use();
			print("Using " + items.get(index).getName());
			items.remove(index);
			return true;
		}
	}
	
	private static void useMagicInFight() {
		boolean b = openMagic();
		
		if(!b) {
			chooseAction();
		}
		
		return;
	}
	
	private static boolean openMagic () {
		print("Choose spell");
		
		List<Attack> usableSpells = new ArrayList<Attack>();
		int i = 1;
		for (Attack a : hero.attacks) {
			if (a.manaCost < hero.mp) {
				String toPrint = "(" + i + ") " + a.name + a.damage +  " " + a.manaCost + "MP\t";
				print(toPrint);
				usableSpells.add(a);
				i++;
			}
		}
		
		print("(0) return");
		
		while(true) {
			int chosen = keyboard.nextInt();
			
			if(chosen == 0) {
				return false;
			}
			
			int index = chosen - 1;
			
			hero.doMagic(usableSpells.get(index));
			print("Casting spell " + usableSpells.get(index).name + "!");
			return true;
		}
		
	}
	
	private static void openEquipment () {
		
		print("Currently equiped:");
		print("\tWeapon: " + hero.getWeapon().show());
		print("\tProtector: " + hero.getProtector().show());
		print("Attacks: ");
		for (Attack a : hero.attacks) {
			print("\t" + a.name + a.damage);
		}
		
		print("\n(0) return");
		
		while(true) {
			int chosen = keyboard.nextInt();
			
			if(chosen == 0) {
				return;
			}
		}
	}
	
	private static void print (String string) {
		System.out.println(string);
	}
	
}
