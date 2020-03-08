
public class Weapon implements Itemable{
	
	public String name;
	public int strenght;
	public int magic;
	
	
	public Weapon(String name, int strenght, int magic) {
		this.name = name;
		this.strenght = strenght;
		this.magic = magic;
	}


	@Override
	public String getName() {
		return name;
	}


	@Override
	public String show() {
		
		return name + ": str" + strenght + " mag" + magic;
	}


	@Override
	public void Use() {
		Weapon other = Player.getHero().getWeapon();
		if (other.strenght != 0 || other.magic != 0) {
			Player.getHero().addItem(other);
		}
		
		
		Player.getHero().setWeapon(this);
		
	}
	
}
