package BattleGame;
import java.util.*;
public class Spell {
	private String name;
	private double minimumDamege;
	private double maximumDamege;
	private double chanceOfSuccessForTheSpell;
	
	public Spell(String name, double minimumDamege, double maximumDamege, double chanceOfSuccessForTheSpell ) {
		if(minimumDamege>maximumDamege||minimumDamege<0||chanceOfSuccessForTheSpell>1||chanceOfSuccessForTheSpell<0)
			throw new IllegalArgumentException("ERROR : Out of bound");
		
		try {
			this.name=name;
			this.minimumDamege=minimumDamege;
			this.maximumDamege=maximumDamege;
			this.chanceOfSuccessForTheSpell=chanceOfSuccessForTheSpell;
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		return "Name :   "+name+"   Damege :   "+minimumDamege+"-"+maximumDamege+"   Chance :   "+chanceOfSuccessForTheSpell*100+"%";
	}
	public double getDamege() {
		double damege = 0;
		Random rnd=new Random();
		if(rnd.nextDouble()>=(1.0-this.chanceOfSuccessForTheSpell))
			damege= getRandom(this.minimumDamege, this.maximumDamege);
		else 
			damege=0;
		
		return Math.round(damege*100)/100.0;
	}
	public static double getRandom(double minimumDamege,double maximumDamege) {
		Random rnd=new Random();
		return rnd.nextDouble()*(maximumDamege-minimumDamege)+minimumDamege;
	}
	public double getMinimum() {
		return this.minimumDamege;
	}
	public double getMaximum() {
		return this.maximumDamege;
	}
	public double getChance() {
		return this.chanceOfSuccessForTheSpell;
	}
	public static void main(String[] args) {
//		Character.setSpells(FileIO.readSpells("spells.txt"));
//		System.out.println(Character.getSpells().get(1).getDamege());
//		Random rnd=new Random();
//		System.out.println(rnd.nextDouble());
		
		
	}
}
