import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class StudentBST {
    public StudentBSTNode root;

    public StudentBST() throws FileNotFoundException
    {
        root = null;
    }

    public StudentBSTNode insert(Student s, StudentBSTNode t){
        if(t == null) t = new StudentBSTNode(s);
        else{
            if(s.getGPA() <= t.data.getGPA()) insert(s, t.left);
            else insert(s, t.right);
        }
        return t;
    }

    public void preOrder(StudentBSTNode root){
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(StudentBSTNode root){
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    public static void postOrder(StudentBSTNode root){
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public Student findMinGPA(StudentBSTNode t){
        if(t.left == null) return t.data;
        findMinGPA(t.left);
        return null;
    }

    public StudentBSTNode findStudent(Student s, StudentBSTNode t){
        if(t.data.getGPA() == s.getGPA()) return t;
        else{
            if(s.getGPA() < t.data.getGPA()) findStudent(s, t.left);
            else findStudent(s, t.right);
        }
        return null;
    }

    public StudentBSTNode delete(Student s, StudentBSTNode t){
        if(t.data.getGPA() == s.getGPA()){
            if(t.left == null) return t.right;
            else if(t.right == null) return t.left;
            else{
                t.data = findMinGPA(t.right);
                delete(t.data, t.right);
            }
        }
        else{
            if(s.getGPA() < t.data.getGPA()) delete(s, t.left);
            else delete(s, t.right);
        }
        return null;
    }

    }
