package JavaCollectionFramework.thuc_hanh.PhanBietHashMapVaHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Thiên",18,"ĐN");
        Student student2 = new Student("Huyền",18,"HN");
        Student student3 = new Student("Hoàng",18,"HCM");

        Map<Integer, Student> studentMap = new HashMap<Integer, Student>();
        studentMap.put(1,student1);
        studentMap.put(3,student2);
        studentMap.put(2,student3);
        studentMap.put(4,student2);

        for(Map.Entry<Integer, Student> student : studentMap.entrySet()){
            System.out.println(student.toString());
        }

        System.out.println("...........Set");
        Set<Student> students = new HashSet<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student2);

        for(Student student : students){
            System.out.println(student.toString());
        }
    }
}
