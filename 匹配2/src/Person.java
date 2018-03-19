import java.util.ArrayList;
import java.util.ArrayList.*;

public class Person{
	private ArrayList<String> features =new ArrayList<String>();
	private ArrayList<String> requirements=new ArrayList<String>();
	private int idnumber;
	private String name;
	
	public Person(ArrayList<String> featuresinput,ArrayList<String> requirementsinput,String nameinput) {
		features=featuresinput;
		requirements=requirementsinput;
		name=nameinput;
	}
	
	public int getIdNumber() {
		return idnumber;
	}
	
	public String getFeature(int n) {
		return features.get(n);
	}
	
	public String getRequirement(int n) {
		return requirements.get(n);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getFeaturesList(){
		return features;
	}
	
	public ArrayList<String> getRequirementsList(){
		return requirements;
	}
}