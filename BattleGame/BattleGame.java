package BattleGame;
import java.util.*;
public class BattleGame {
	public static void main(String[] args) {
		playGame();
		
//		System.out.println(FileIO.readSpells("spells.txt").toString());
	}
	
	public static void playGame() {
		///player
		Character player=FileIO.readCharacter("player.txt");
		Character.setSpells(FileIO.readSpells("spells.txt"));
		System.out.println(player);
		System.out.println("Attack :   "+player.getAttackValue());
		System.out.println("Number Of Wins :   "+player.getNumOfWins());
		///enemy
		Character enemy=FileIO.readCharacter("monster.txt");
		System.out.println(enemy);
		System.out.println("Attack :   "+enemy.getAttackValue());
		System.out.println("Number Of Wins :   "+enemy.getNumOfWins());
		///spell
		int i=0;
		while(Character.getSpells().get(i)!=null) {
			System.out.println(Character.getSpells().get(i));
			i++;
			if(i>Character.getSpells().size()-1)
				break;
		}
		while(player.getCurrentHealth()>=0&&enemy.getCurrentHealth()>=0) {
			Scanner scan=new Scanner(System.in);
			System.out.println("Attack  Or  Quit");
			String command=scan.next();
			command=command.toLowerCase();
			if(command.equals("attack")) {
				doAttack(player,enemy);
				if(enemy.getCurrentHealth()<=0)
					break;
				doAttack(enemy,player);
				}
			else if(command.equals("quit")) {
				System.out.println("GoodBye");
				break;
			}
			else {
//				System.out.println("Input was not recognized");
//				System.out.println("Attack Or Quit");
				double damege=player.castSpell(command);
				enemy.takeDam(damege);
				if(enemy.getCurrentHealth()<=0)
					break;
				doAttack(enemy,player);
			}
		}
		if(player.getCurrentHealth()<0) {
			System.out.println("Oh,no! you lost!");
			enemy.incWin();
		}
		else if(enemy.getCurrentHealth()<0) {
			System.out.println("Congraturations! you win!!");
			player.incWin();
		}
		FileIO.writeCharacter(player, "Player.txt");
		FileIO.writeCharacter(enemy, "Monster.txt");
	}
	
	public static void doAttack(Character subject, Character target) {
		double damege=subject.cAttack();
		System.out.println(subject.getName()+" attacks for "+damege+" damege !");
		target.takeDam(damege);
		if (target.getCurrentHealth()>0)
			System.out.println(target);
		else {
			System.out.println("Name :   "+target.getName()+"   Health   :0");
			System.out.println(target.getName()+" was knocked out!");
		
		}
	}
}
