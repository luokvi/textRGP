
public class Protector implements Itemable{
	public String name;
	public int armor;
	public int magicArmor;
	
	public Element weakness;
	public Element resistance;
	
	
	public Protector(String name, int armor, int magicArmor) {
		this.name = name;
		this.armor = armor;
		this.magicArmor = magicArmor;
		
	}


	public Protector(String name, int armor, int magicArmor, Element weakness, Element resistance) {
		this.name = name;
		this.armor = armor;
		this.magicArmor = magicArmor;
		this.weakness = weakness;
		this.resistance = resistance;
	}


	@Override
	public String show() {
		String string = name + ": +" + armor + ", +" + magicArmor;
		
		if (weakness != null) {
			string += " weak: " + weakness.toString() + " res: " + resistance.toString();
		}
		
		return string;
	}


	@Override
	public void Use() {
		Protector other = Player.getHero().getProtector();
		if (other.armor != 0 || other.magicArmor != 0) {
			Player.getHero().addItem(other);
		}
		
		Player.getHero().setProtector(this);
		
	}


	@Override
	public String getName() {
		return name;
	}
	
	
	
}
