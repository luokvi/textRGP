import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Generator {
	
	List<Enemy> enemies = new ArrayList<Enemy>();
	
	List<Itemable> items = new ArrayList<Itemable>();

	
	public Enemy getEnemy () {
		
		Enemy e = new Enemy ("Goblin", 20, 5, 5, 3, 5, 5);
		enemies.add(e);
		e = new Enemy ("Young Goblin", 10, 3, 3, 2, 3, 3);
		enemies.add(e);
		e = new Enemy ("Fire Elemental", 25, 10, 5, 10, 20, 5, Element.water, Element.fire);
		enemies.add(e);
		e = new Enemy ("Water Elemental", 25, 10, 5, 10, 20, 5, Element.fire, Element.water);
		enemies.add(e);
		e = new Enemy ("Air Elemental", 25, 10, 5, 10, 20, 5, Element.earth, Element.wind);
		enemies.add(e);
		e = new Enemy ("Ground Elemental", 25, 10, 5, 10, 20, 5, Element.wind, Element.earth);
		enemies.add(e);
		
		int random = new Random().nextInt(enemies.size());
		
		Enemy enemy = enemies.get(random);
		
		return enemy;
	}
	
	public TreasureChest getChest () {
		Potion p;
		int random = new Random().nextInt(4);
		if (random % 2 == 0) {
			p = new Potion(10, 0);
		}else {
			p = new Potion(0, 10);
		}
		items.add(p);
		
		random = new Random().nextInt(10) + 3;
		Weapon w;
		if (random % 2 == 0) {
			w = new Weapon("Sword +" + random, random, 0);
		}else {
			w = new Weapon("Staff +" + random, 0, random);
		}
		
		items.add(w);
		
		random = new Random().nextInt(10) + 3;
		Protector pr = new Protector("Armor +" + random, random, random);
		items.add(pr);
		
		random = new Random().nextInt(15) + 5;
		Element[] elements = Element.values();
		Element e = elements[new Random().nextInt(5)];
		while(e == Element.physical) {
			e = elements[new Random().nextInt(5)];
		}
		Attack a = new Attack(e.toString(), random, e, random / 2);
		SpellItem s= new SpellItem(a);
		items.add(s);
		
		random = new Random().nextInt(4);
		items.remove(random);
		
		TreasureChest c = new TreasureChest(items);
		
		return c;
	}
}
