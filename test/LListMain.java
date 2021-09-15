public class LListMain {
    public static void main(String[] args) {
        StudentList SList = new StudentList();
        SList.append(new Student("Matthew", "Murillo", 20, 3.8));
        SList.append(new Student("Fargis", "NWord", 15, 3.9));
        SList.append(new Student("Loser", "Culo", 34, 2.5));
        SList.sortByGPA();
    }
}
