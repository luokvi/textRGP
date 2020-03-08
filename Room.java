import java.util.Random;

public class Room {
	
	private Enemy enemy;
	private TreasureChest chest;
	
	public Room () {
		
		Generator g = new Generator();
		
		int random = new Random().nextInt(4);
		if (random % 2 == 0) {
			enemy = g.getEnemy();
		}
		if (random % 3 == 0) {
			chest = g.getChest();
		}
		
	}
	
	public void enter () {
		String s = "You enter the next room.\nYou see ";
		
		if (enemy != null) {
			s += "a monster aproaching!";
			print(s);
			Player.newFight(enemy);
			return;
		}
		if (chest != null) {
			s += "a tresure chest!";
			print(s);
			Player.newChest(chest);
			return;
		}
		
		s += "that it's empty.";
		print(s);
	}
	
	private void print (String string) {
		System.out.println(string + "\n\t***\n");
	}

}
