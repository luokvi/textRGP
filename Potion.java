
public class Potion implements Itemable{
	public int hp;
	public int mp;
	
	
	public Potion(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
	}
	

	@Override
	public String show() {
		
		String s = getName() + ": Gives ";
		
		if (hp > mp) {
			s+= hp + " health points";
		}else {
			s+= mp + " mana points";
		}
		
		return s;	
	}

	@Override
	public void Use() {
		
		Player.getHero().heal(hp);
		Player.getHero().healMana(mp);
	}

	@Override
	public String getName() {
		if (hp > mp) {
			return "Potion";
		}
		
		return "Ether";
	}
	
}