import java.util.ArrayList;

class MemberInfo {
    private String name;
    private int gradYear;
    private boolean goodStanding;

    public MemberInfo(String name, int gradYear, boolean hasGoodStanding) {
        this.name = name;
        this.gradYear = gradYear;
        this.goodStanding = hasGoodStanding;
    }
    public int getGradYear() { return gradYear; }
    public boolean inGoodStanding() { return goodStanding; }
    public String getName() { return name; }
}

class ClubMembers {
    private ArrayList<MemberInfo> memberList;

    public ClubMembers() {
        memberList = new ArrayList<>();
    }

    // (a) - Already correct
    public void addMembers(String[] names, int gradYear) {
        for (String name : names) {
            memberList.add(new MemberInfo(name, gradYear, true));
        }
    }

    // (b) - FINAL ANSWER - This is what the chart wants
    public ArrayList<MemberInfo> removeMembers(int year) {
        ArrayList<MemberInfo> goodGraduated = new ArrayList<MemberInfo>();

        // MUST loop backwards when removing from ArrayList
        for (int i = memberList.size() - 1; i >= 0; i--) {
            MemberInfo member = memberList.get(i);
            if (member.getGradYear() <= year) {
                // If good standing, add to return list
                if (member.inGoodStanding()) {
                    goodGraduated.add(member);
                }
                // Always remove graduated, good or not
                memberList.remove(i);
            }
        }
        return goodGraduated;
    }

    public ArrayList<MemberInfo> getList() { return memberList; }
}

public class Main {
    public static void main(String[] args) {
        // Replicate your exact chart example
        ClubMembers club = new ClubMembers();
        club.getList().add(new MemberInfo("SMITH, JANE", 2019, false));
        club.getList().add(new MemberInfo("FOX, STEVE", 2018, true));
        club.getList().add(new MemberInfo("XIN, MICHAEL", 2017, false));
        club.getList().add(new MemberInfo("GARCIA, MARIA", 2020, true));

        System.out.println("BEFORE removeMembers(2018): " + club.getList().size());
        
        ArrayList<MemberInfo> returned = club.removeMembers(2018);

        System.out.println("AFTER memberList size: " + club.getList().size() + " -> Should be 2");
        for (MemberInfo m : club.getList()) {
            System.out.println("  Left: " + m.getName() + " " + m.getGradYear());
        }

        System.out.println("\nRETURNED list size: " + returned.size() + " -> Should be 1");
        for (MemberInfo m : returned) {
            System.out.println("  Returned: " + m.getName() + " " + m.getGradYear() + " " + m.inGoodStanding());
        }
    }
}