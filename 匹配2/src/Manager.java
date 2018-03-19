import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Manager {
	public static void main(String[] args) {
		/*
		 * int[][] rawdata= { {0,1,0,0,0,0}, {1,0,0,1,0,0}, {0,0,0,0,1,1},
		 * {0,1,0,0,0,1}, {0,0,1,0,0,0}, {0,0,1,1,0,0} };
		 */

		// int n=rawdata.length;
		PeopleManager peoplemanager=new PeopleManager();
		File newfile=new File("./rawdata.txt");
		Scanner in=null;
		try {
			in = new Scanner(newfile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Manager manager=new Manager();

		while (in.hasNextLine()) {
			String temp = in.nextLine();
			if (temp.equals("end")) {
				break;
			} else {
				String[] arr = temp.split("/\\s+");
				if (arr.length != 2) {
					System.out.println("The person's information should be splited by 'end' and should only input two!");
				} else {
					String features = arr[0];
					String requirements = arr[1];
					String[] featurelist=features.split("\\s+");
					String[] requirementslist=requirements.split("\\s+");
					ArrayList<String> featurearraylist=new ArrayList<String>(Arrays.asList(featurelist));
					ArrayList<String> requirementsarraylist=new ArrayList<String>(Arrays.asList(requirementslist));
					String name=featurearraylist.remove(0);
					//System.out.println(requirementsarraylist.get(0));
					Person newperson = new Person(featurearraylist,requirementsarraylist,name);
					peoplemanager.addToPeopleCollection(newperson);
				}
			}
		}
		in.close();
		
		int[][] rawdata=peoplemanager.getMatchRawData();
		int n=peoplemanager.getNumberOfPeople();

		Group groupandoperation = new Group(n, rawdata);
		groupandoperation.grouping();
		groupandoperation.printResultarraylist();
		manager.outputTheMatch(groupandoperation, peoplemanager);
	}


	public void outputTheMatch(Group g,PeopleManager p) {
		try {
			BufferedWriter out=new BufferedWriter(new FileWriter("./output.txt"));
			out.write("The result is:");
			out.newLine();
			for(int i=0;i<g.getResultarraylist().size();i++) {
				out.write("The "+i+" th result is:");
				out.newLine();
				for(int m=0;m<g.getResultarraylist().get(0).getNumberOfPeople();m++) {
					for(int n=0;n<m;n++) {
						if(g.getResultarraylist().get(i).getArray(m, n)==1) {
							out.write(p.getPerson(m).getName());
							out.write(" ");
							out.write(p.getPerson(n).getName());
							out.newLine();
						}
					}
				}
			}
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}