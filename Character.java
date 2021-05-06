package battleGame;
import java.util.*;
public class Character {
	private	String name;
	private double attackValue;
	private double maxHealthValue;
	private double currentHealthValue;
	private int numOfWins;
	private static ArrayList<Spell> spells;
	
	public Character(String name,double attackValue,double maxHealthValue, int numOfWins) {
		this.setName(name);
		this.attackValue=attackValue;
		this.maxHealthValue=maxHealthValue;
		this.currentHealthValue=maxHealthValue;
		this.numOfWins=numOfWins;
	}
	
	public String toString() {
		return "Name :   "+getName()+"   Health :    "+Math.round(currentHealthValue*100)/100.0;
	}
	public String getName() {
		return this.name;
	}
	public double getMaxHealth() {
		return this.maxHealthValue;
	}
	
	
	public double cAttack() {
		return Math.round(this.attackValue*getRandom()*100)/100.0;
	}
	
	public void takeDam(double damege) {
		this.currentHealthValue-=damege;
		System.out.println(this.getName()+" takes "+damege+" damege !!");
		if (this.getCurrentHealth()>0)
			System.out.println(this);
		else {
			System.out.println("Name :   "+this.getName()+"   Health   :0");
//			System.out.println(target.getName()+" was knocked out!");)
		}
		
	}
	
	public static double getRandom() {
		Random rnd = new Random();
		return rnd.nextDouble()*4+0.3;
	}
	
	public static void main(String[] args) {
		
//		Character.setSpells(FileIO.readSpells("spells.txt"));
//		System.out.println(getSpells().size());
	}
	
	public void incWin() {
		this.numOfWins++;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getCurrentHealth() {
		return this.currentHealthValue;
	}
	public double getAttackValue() {
		return this.attackValue;
	}
	
	public int getNumOfWins() {
		return this.numOfWins;
	}

	
	public static void setSpells(ArrayList<Spell>spells) {
		Character.spells=(ArrayList<Spell>)spells.clone();
	}
	public double castSpell(String name) {
		int i=0;
		name=name.toLowerCase();
		for(i=0; i<getSpells().size(); i++) {
			if(getSpells().get(i).getName().equals(name)==true)
				break;
		}
		if (getSpells().get(0).getName().equals(name)==false&&getSpells().get(1).getName().equals(name)==false&&
				getSpells().get(2).getName().equals(name)==false) {
			System.out.println(this.getName()+" tried to cast an unknown spell.");
			return 0;
		}
		double damege=getSpells().get(i).getDamege();
		if(damege==0) {
			System.out.println(this.getName()+" failed to cast the spell.");
			return 0;
		}
		System.out.println(this.getName()+" casted "+name+" for damege of "+damege);
		return damege;		
		
	}

	public static ArrayList<Spell> getSpells() {
		return Character.spells;
	}
}
