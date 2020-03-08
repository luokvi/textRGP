import java.util.ArrayList;
import java.util.List;

public class Character {
	private Attack attackToDo;
	
	public String name;
	public int hp;
	public int maxHp;
	public int mp;
	public int maxMp;
	
	private int strenght;
	private int magic;
	private int armor;
	private int magicArmor;
	
	private Weapon weapon = new Weapon(" ", 0, 0);
	private Protector protector = new Protector(" ", 0, 0);
	
	private Element weakness;
	private Element resistance;
	
	public List<Attack> attacks = new ArrayList<Attack>();
	public List<Itemable> items = new ArrayList<Itemable>();
	
	public Character(String name, int hp, int mp, int strenght, int magic, int armor, int magicArmor) {
		this.name = name;
		this.hp = hp;
		this.maxHp = hp;
		this.mp = mp;
		this.maxMp = mp;
		
		this.strenght = strenght;
		this.magic = magic;
		this.armor = armor;
		this.magicArmor = magicArmor;
		
	}
	
	public void setWeakness(Element weakness) {
		this.weakness = weakness;
	}


	public void setResistance(Element resistance) {
		this.resistance = resistance;
	}


	public Attack getAttackToDo() {
		return attackToDo;
	}
	public void setAttackToDo(Attack a) {
		attackToDo = a;
	}
	
	public void setWeapon (Weapon weapon) {
		this.weapon = weapon;
	}
	public Weapon getWeapon () {
		return weapon;
	}
	
	public void setProtector (Protector protector) {
		this.protector = protector;
	}
	public Protector getProtector () {
		return protector;
	}

	
	public void Attack (Attack a) {
		mp -= a.manaCost;
		
		attackToDo = a;
		if (attackToDo.element == Element.physical) {
			attackToDo.addDamage(strenght + weapon.strenght);
		} else {
			attackToDo.addDamage(magic + weapon.magic);
		}
	}
	
	public boolean receiveAttack (Attack attack) {
		int damage = attack.damage;
		
		if(attack.element == Element.healing) {
			heal(damage);
			return false;
		}
		
		if (attack.element == Element.physical) {
			damage -= armor + protector.armor;
		}else {
			
			if(attack.element == weakness || attack.element == protector.weakness) {
				damage *= 2;
			}
			if (attack.element == resistance || attack.element == protector.weakness) {
				damage /= 2;
			}
			
			damage -= magicArmor + protector.magicArmor;
			
		}
		
		if (damage < 0) {
			damage = 1;
		}
		
		hp -= damage;
		
		return hp <= 0;
	}
	
	public void heal (int amount) {
		hp += amount;
		if (hp > maxHp) {
			hp = maxHp;
		}
	}
	
	public void healMana (int amount) {
		mp += amount;
		if (mp > maxMp) {
			mp = maxMp;
		}
	}
	
	public void addItem (Itemable item) {
		items.add(item);
	}
	public void addItems (List<Itemable> items) {
		for(Itemable i : items) {
			this.items.add(i);
		}
	}
	
	public List<Itemable> getItems(){
		return items;
	}
	
	public void print (String string) {
		
		System.out.println(string);
	}
	
	public String fightInfo() {
		Double hpPrecent = (hp * 1.0) / (maxHp * 1.0) * 100.0;
		return name + "\t" + hpPrecent;
	}
	
}
