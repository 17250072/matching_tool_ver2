import java.util.ArrayList;
import java.util.ArrayList.*;

public class PeopleManager {
	private ArrayList<Person> peoplecollection = new ArrayList<Person>();
	private int[][] matchrawdata;

	public void addToPeopleCollection(Person person) {
		peoplecollection.add(person);
	}

	public Person getPerson(int n) {
		return peoplecollection.get(n);
	}

	public boolean isMatch(Person p1, Person p2) {
		boolean result = true;
		if (p1 == null || p2 == null) {
			System.out.println("The person is not correct! does not exist!");
		//} else if (p1.getFeaturesList().size() != p2.getRequirementsList().size()) {
		//	System.out.println("The person 1 and the person 2 does not have the same number of features!");
		//	System.out.println("The 1 is "+p1.getFeaturesList().size()+" and the 2 is "+p2.getFeaturesList().size());
		//	result=false;
		} else {
			for (int i = 0; i < p1.getFeaturesList().size(); i++) {
				if ((!p1.getFeaturesList().get(i).equals(p2.getRequirementsList().get(i))||!p1.getRequirementsList().get(i).equals(p2.getFeaturesList().get(i)))&&!p1.getRequirementsList().get(i).equals("*")&&!p2.getRequirementsList().get(i).equals("*")) {
					result = false;
				}
			}
		}
		System.out.println(result);
		return result;
	}

	public int[][] getMatchRawData() {
		matchrawdata = new int[peoplecollection.size()][peoplecollection.size()];
		for (int i = 0; i < peoplecollection.size(); i++) {
			for (int j = 0; j < peoplecollection.size(); j++) {
				if (i == j) {
					matchrawdata[i][j] = 0;
				} else {
					if (isMatch(peoplecollection.get(i), peoplecollection.get(j)) == true) {
						matchrawdata[i][j]=1;
					}
				}
			}
		}
		return matchrawdata;
	}
	
	public int getNumberOfPeople() {
		return peoplecollection.size();
	}
}