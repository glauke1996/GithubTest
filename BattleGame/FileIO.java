package BattleGame;
import java.util.*;
import java.io.*;
public class FileIO {
	public static  Character readCharacter(String filename) {
		Character c=null;
		try {
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			String name=br.readLine();
			double attackValue=Double.parseDouble(br.readLine());
			double maxHealth=Double.parseDouble(br.readLine());
			int numOfWins=Integer.parseInt(br.readLine());
			c=new Character(name, attackValue, maxHealth,numOfWins);
			
			br.close();
			fr.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("probloems with a file :"+filename);
			}
		catch(IOException e) {
			System.out.println("couldn't find a file :" + filename);
		}
		
		return c;
		
		
	}
	public static ArrayList<Spell> readSpells(String filename){
		String[] currentLine=new String[5];
		ArrayList<Spell> list=new ArrayList<Spell>();
		try {
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			
			for(int i=0; i<3;i++) {
				currentLine=br.readLine().split(" ");
				Spell spell=new Spell(currentLine[0],Double.parseDouble(currentLine[1])
						,Double.parseDouble(currentLine[2]),Double.parseDouble(currentLine[3]));
				list.add(spell);
				}
			br.close();
			fr.close();
		}
		catch(FileNotFoundException e) {
			throw new IllegalArgumentException("File is not found");
		}
		catch(IOException e) {
			throw new IllegalArgumentException("problems with a file");
		}
		return list;
		
	}
	public static void writeCharacter(Character c,String filename) {
		String output="";
		output+=c.getName()+"\n";
		output+=Double.toString(c.getAttackValue())+"\n";
		output+=Double.toString(c.getMaxHealth())+"\n";
		output+=Integer.toString(c.getNumOfWins())+"\n";
		try {
			for(int i=0; i<4; i++)
			{
				FileWriter fw=new FileWriter(filename,false);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(output);
				bw.close();
				fw.close();
			}
		}
		catch(IOException e) {
			throw new IllegalArgumentException("problems with file :"+ filename);
		}
	}
}
