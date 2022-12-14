package study.springboot.domain.member;

public class Member{

    //학번
    private Integer memberId;

    // 1: 남자, 0: 여자
    private int sex;
    private String memberPassword;
    private String memberName;
    private String memberNumber;
    private Grade grade;

    public Member(Integer memberId, int sex, String memberPassword, String memberName, String memberNumber, Grade grade) {
        this.memberId = memberId;
        this.sex = sex;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberNumber = memberNumber;
        this.grade = grade;
    }

    public Member() {

    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
