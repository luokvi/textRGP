
public class Fight {
	
	Enemy enemy;
	
	
	public Fight(Enemy enemy) {
		
		this.enemy = enemy;
		
		
		start();
	}
	
	private void start() {
		print(enemy.name + " Aproaches!!");
		herosTurn();
	}
	
	private void herosTurn () {
		print(enemy.fightInfo());
		print(Player.getHero().fightInfo());
		
		Player.getHero().myTurn(this);
		
		
		Attack attack = Player.getHero().getAttackToDo();
		Player.getHero().setAttackToDo(new Attack(0, Element.physical, 0));
		
		boolean enemyDied = false;
		if (attack.element == Element.healing) {
			Player.getHero().heal(attack.damage);
			
		} else {
			enemyDied = enemy.receiveAttack(attack);
		}
		
		
		if (!enemyDied) {
			enemysTurn();
			
		} else {
			
			victory();
		}
		
	}
	
	private void enemysTurn () {
		print(enemy.fightInfo());
		print(Player.getHero().fightInfo());
		
		enemy.myTurn();
		
		Attack attack = enemy.getAttackToDo();
		enemy.setAttackToDo(new Attack(0, Element.physical, 0));
		Boolean heroDied = Player.getHero().receiveAttack(attack);
		
		if (!heroDied) {
			herosTurn();
			
		} else {
			
			defeat();
		}
		
	}
	
	private void victory () {
		print("\n" + enemy.name + " defeated\nVictory!");
		
		endFight();
	}
	
	public void defeat () {
		if(Player.getHero().hp <= 0) {
			Player.getHero().hp = 1;
		}
		
		print("Defeat");
		endFight();
		
	}
	
	private void endFight() {
		
	}
	
	private void print (String string) {
		System.out.println(string + "\n\t***\n");
	}
}
