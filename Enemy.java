import java.util.Random;

public class Enemy extends Character{
	
	private Attack physicalAttack;
	private Attack magicAttack;

	public Enemy(String name, int hp, int mp, int strenght, int magic, int armor, int magicArmor) {
		super(name, hp, mp, strenght, magic, armor, magicArmor);
		
		this.physicalAttack = new Attack(hp / 2, Element.physical, 0);
		this.magicAttack = new Attack(hp / 2, Element.earth, mp / 3);
	}
	
	public Enemy(String name, int hp, int mp, int strenght, int magic, int armor, int magicArmor, Element weakness, Element resistance) {
		super(name, hp, mp, strenght, magic, armor, magicArmor);
		setWeakness(weakness);
		setResistance(resistance);
		
		this.physicalAttack = new Attack(hp / 2, Element.physical, 0);
		this.magicAttack = new Attack(hp / 2, resistance, 0);
	}
	
	public void myTurn () {
		print(name + "'s turn:");
		
		Attack attack;
		
		int random = new Random().nextInt(10);
		if (random % 2 == 0) {
			attack = physicalAttack;
		} else {
			attack = magicAttack;
		}
		
		Attack(attack);
		print(name + " attacks you with " + attack.name + "\n");
		return;
	}
	
	

}
