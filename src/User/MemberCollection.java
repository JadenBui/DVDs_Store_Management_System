package User;

import java.util.Arrays;

public class MemberCollection {
    static int member = 0;
    static Member[] list;
    private static MemberCollection memberList = null;
    private MemberCollection(){};

    public static MemberCollection getList(){
        if(memberList == null){
            memberList = new MemberCollection();
            list = new Member[100];
        }
        return memberList;
    }

    public void addMember(Member newMember){
        list[member++] = newMember;
    }

    public Member searchMember(String name){
        for(int i = 0; i < member; i ++){
            if(name.toLowerCase().equals(list[i].getFullName().toLowerCase())){
                return list[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "list=" + Arrays.toString(list) +
                '}';
    }

}
