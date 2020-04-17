package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	private static List<Integer> list = new ArrayList<>();
	public static List<Integer> fibonacci() {

		if(list.isEmpty()) {
			int before_prev = 0;
			int prev = 1;
			int current = 0;
			list.add(before_prev);
			list.add(prev);
			while (current < 350) {
				current = prev + before_prev;
				list.add(current);
				before_prev = prev;
				prev = current;
			}
		}
		return list;
	}

	public static Boolean isFibonacci(Integer a) {
		return list.contains(a);
	}

}