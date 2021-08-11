package queue;

import java.util.*;

class Student implements Comparable<Student> {
	int no, score;
	
	Student(int no, int score) {
		this.no = no;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "[no: " + this.no + ", score: " + this.score + "]";
	}

	@Override
	public int compareTo(Student o) {
		return this.no - o.no;
	}
}

public class Main {
	public static void main(String[] args) {
		PriorityQueue<Student> q = new PriorityQueue<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.score - o2.score;
			}
			
		});
		
		q.offer(new Student(5, 10));
		q.offer(new Student(1, 70));
		q.offer(new Student(2, 50));
		q.offer(new Student(4, 80));
		q.offer(new Student(3, 20));
		
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
	}
}