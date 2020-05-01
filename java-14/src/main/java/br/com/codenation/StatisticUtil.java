package br.com.codenation;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class StatisticUtil {

	public static int average(int[] elements)
	{
		int soma=0;
		for(int i =0; i<elements.length;i++)
			soma+=elements[i];

		return soma/elements.length;
	}

	public static int mode(int[] elements)
	{
		Map<Integer,Integer> contagem= new HashMap<>();
		stream(elements).forEach(x ->contagem.put(x,0));

		for(int num: elements){
			if(contagem.containsKey(num)){
				Integer valor = contagem.getOrDefault(num,0);
				contagem.put(num,valor+1);
			}
		}
		return contagem.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.map(Map.Entry::getKey)
				.findFirst()
				.orElseThrow(RuntimeException::new);

	}

	public static int median(int[] elements) {

		sort(elements);
		if(elements.length%2!=0){
			return elements[(elements.length-1)/2];
		}
		int[] centro = new int[2];
		centro[0]=elements[elements.length/2];
		centro[1]=elements[elements.length/2-1];
		return average(centro);
	}

	public static void sort(int[] v){
		for(int i=0;i<v.length-1;i++){
			int max=i;
			for(int j=i+1;j<v.length;j++)
				if(v[j]>v[max]) max=j;
			int temp=v[i];
			v[i]=v[max];
			v[max]=temp;

		}
	}
}