
public class Attack {
	
	public int damage;
	public Element element;
	public int manaCost;
	
	public String name = "";
	
	
	public Attack(int damage, Element element, int manaCost) {
		this.damage = damage;
		this.element = element;
		this.manaCost = manaCost;
		this.name = element.toString();
	}
	
	public Attack(String name, int damage, Element element, int manaCost) {
		this.damage = damage;
		this.element = element;
		this.manaCost = manaCost;
		this.name = name;
	}
	
	public void setElement (Element element) {
		this.element = element;
	}
	
	public void addDamage (int amount) {
		damage += amount;
	}
	
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if ((o == null) || (o.getClass() != this.getClass()))
            return false;
		
		Attack attack = (Attack) o;
		if(this.damage == attack.damage && this.element == attack.element) {
			return true;
		}
		
		return false;
	}
	
}