import java.util.ArrayList;
public class Hero extends Character{
	
	private Fight currentFight;
	
	private Attack physicalAttack = new Attack(10, Element.physical, 0);
	private Attack heal = new Attack("Heal", 10, Element.healing, 3);

	public Hero(String name, int hp, int mp, int strenght, int magic, int armor, int magicArmor) {
		super(name, hp, mp, strenght, magic, armor, magicArmor);
		
		this.attacks = new ArrayList<Attack>();
		this.attacks.add(heal);
	}
	
	public boolean addAttack (Attack attack) {
		//if attack already in list attacks, don't add it again
		for (Attack a : attacks) {
			if (attack.equals(a)) {
				return false;
			}
		}
		
		attacks.add(attack);
		return true;
	}
	
	public void myTurn (Fight fight) {
		currentFight = fight;
		print("Hero's turn\n");
		Player.chooseAction();
	}
	
	public void doPhysicalAttack () {
		Attack(physicalAttack);
	}
	public void doMagic (Attack a) {
		Attack(a);
	}
	
	public void defeat() {
		currentFight.defeat();
	}
	
	public String fightInfo() {
		
		return name + "\tHP: " + hp + "/" + maxHp + "\tMP: " + mp + "/" + maxMp;
	}
	
	
}
