
public class SpellItem implements Itemable{
	
	private Attack attack;
	
	public SpellItem(Attack attack) {
		this.attack = attack;
	}

	@Override
	public String getName() {
		
		return "Spell " + attack.name;
	}

	@Override
	public String show() {
		String string = "Spell: " + attack.name + attack.damage + " (" + attack.manaCost + "MP)";
		return string;
	}

	@Override
	public void Use() {
		
		Player.getHero().addAttack(attack);
		
	}

}
