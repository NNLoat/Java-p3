
import java.util.ArrayList;
public class Member {
	protected String email;
	protected String password;
	protected ArrayList<Video> videoList = new ArrayList<Video>();
	public Member(String email,String password) {
		this.email=email;
		this.password=password;
	}
	public boolean addVideo(Video vdo) {
		if(vdo==null) {return false;}
		videoList.add(vdo);
		return true;
	}
	public boolean removeVideo(Video vdo) {
		if(videoList.contains(vdo)) {
			videoList.remove(vdo);
			System.out.println(vdo.toString() + "\nis successfully removed");
			return true;
		}
		else {return false;}
	}
	public void printMemberInfo() {
	   System.out.println("Email: "+email+"(pwd: "+password+")");
	   System.out.println("List of Videos");
	   for(int i=0;i<videoList.size();i++) {
		   System.out.printf("[%d] ",i+1);
		   System.out.println(videoList.get(i).toString());
	   }
	}
}
class FreeMember extends Member{
	double FREE_LIMITED_VDOs;

	public FreeMember(String email, String password) {
		super(email, password);
		FREE_LIMITED_VDOs=3;
	
	}
	public boolean addVideo(Video vdo) {
		if(vdo==null||FREE_LIMITED_VDOs==0) {
			System.out.println(vdo.toString() +"\ncannot be downloaded because the number of the video is reaching the limit.");
			return false;
		}
		else {videoList.add(vdo);
		FREE_LIMITED_VDOs--;
		return true;
	}
}
	public boolean removeVideo(Video vdo) {
		if(videoList.contains(vdo)) {
			super.removeVideo(vdo);
			FREE_LIMITED_VDOs++;
			return true;
		}
		return false;
	}
	public void printMemberInfo() {
		 System.out.println("---- FREE MEMBER ----");
		 super.printMemberInfo();
	}
	public int getNumVideo() {
		return videoList.size();
	}
	}
class PremiumMember extends Member{
	double fee;
	public PremiumMember(String email, String password,double infee) {
		super(email, password);
		this.fee=infee;
	}
	public void printMemberInfo() {
		 System.out.println("---- PREMIUM MEMBER ----");
		 System.out.println("Member fee: "+fee);
		 //System.out.println("Email: "+email+"(pwd: "+password+")");
		 super.printMemberInfo();
		 
	}
	}	

