package Rounds;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Rounds {
	
	 HashMap<Integer, int []> map;
	 Random ran;
	 public  int generateRandom() {
		 int key = ran.nextInt(0,100);
		 return key;
	 }
	 public int []  getRound(int x) {
		 return map.get(x);
	 }
	 public Rounds() {
		 	ran = new Random();
		 	map = new HashMap<>();
	        map.put(0, new int[]{2, 10});
	        map.put(1, new int[]{3, 15});
	        map.put(2, new int[]{5, 20});
	        map.put(3, new int[]{7, 28});
	        map.put(4, new int[]{4, 16});
	        map.put(5, new int[]{6, 30});
	        map.put(6, new int[]{9, 81});
	        map.put(7, new int[]{10, 100});
	        map.put(8, new int[]{8, 32});
	        map.put(9, new int[]{12, 36});
	        map.put(10, new int[]{5, 25});
	        map.put(11, new int[]{11, 44});
	        map.put(12, new int[]{4, 64});
	        map.put(13, new int[]{3, 27});
	        map.put(14, new int[]{2, 32});
	        map.put(15, new int[]{6, 12});
	        map.put(16, new int[]{15, 45});
	        map.put(17, new int[]{7, 21});
	        map.put(18, new int[]{1, 17});
	        map.put(19, new int[]{9, 18});
	        map.put(20, new int[]{3, 24});
	        map.put(21, new int[]{10, 30});
	        map.put(22, new int[]{8, 56});
	        map.put(23, new int[]{4, 44});
	        map.put(24, new int[]{7, 49});
	        map.put(25, new int[]{5, 45});
	        map.put(26, new int[]{6, 66});
	        map.put(27, new int[]{11, 99});
	        map.put(28, new int[]{3, 18});
	        map.put(29, new int[]{2, 22});
	        map.put(30, new int[]{4, 36});
	        map.put(31, new int[]{5, 55});
	        map.put(32, new int[]{1, 64});
	        map.put(33, new int[]{9, 72});
	        map.put(34, new int[]{7, 63});
	        map.put(35, new int[]{3, 81});
	        map.put(36, new int[]{6, 24});
	        map.put(37, new int[]{8, 40});
	        map.put(38, new int[]{2, 18});
	        map.put(39, new int[]{4, 48});
	        map.put(40, new int[]{5, 35});
	        map.put(41, new int[]{3, 30});
	        map.put(42, new int[]{6, 36});
	        map.put(43, new int[]{7, 14});
	        map.put(44, new int[]{8, 64});
	        map.put(45, new int[]{9, 81});
	        map.put(46, new int[]{10, 70});
	        map.put(47, new int[]{11, 33});
	        map.put(48, new int[]{12, 96});
	        map.put(49, new int[]{2, 14});
	        map.put(50, new int[]{4, 20});
	        map.put(51, new int[]{5, 10});
	        map.put(52, new int[]{6, 18});
	        map.put(53, new int[]{7, 35});
	        map.put(54, new int[]{8, 24});
	        map.put(55, new int[]{9, 27});
	        map.put(56, new int[]{10, 60});
	        map.put(57, new int[]{11, 22});
	        map.put(58, new int[]{12, 48});
	        map.put(59, new int[]{13, 39});
	        map.put(60, new int[]{14, 28});
	        map.put(61, new int[]{15, 75});
	        map.put(62, new int[]{16, 32});
	        map.put(63, new int[]{17, 51});
	        map.put(64, new int[]{18, 36});
	        map.put(65, new int[]{19, 57});
	        map.put(66, new int[]{20, 80});
	        map.put(67, new int[]{21, 42});
	        map.put(68, new int[]{22, 66});
	        map.put(69, new int[]{23, 46});
	        map.put(70, new int[]{24, 96});
	        map.put(71, new int[]{25, 100});
	        map.put(72, new int[]{26, 78});
	        map.put(73, new int[]{27, 54});
	        map.put(74, new int[]{28, 56});
	        map.put(75, new int[]{29, 58});
	        map.put(76, new int[]{30, 90});
	        map.put(77, new int[]{31, 62});
	        map.put(78, new int[]{32, 96});
	        map.put(79, new int[]{33, 66});
	        map.put(80, new int[]{34, 68});
	        map.put(81, new int[]{35, 70});
	        map.put(82, new int[]{36, 72});
	        map.put(83, new int[]{37, 74});
	        map.put(84, new int[]{38, 76});
	        map.put(85, new int[]{39, 78});
	        map.put(86, new int[]{40, 80});
	        map.put(87, new int[]{41, 82});
	        map.put(88, new int[]{42, 84});
	        map.put(89, new int[]{43, 86});
	        map.put(90, new int[]{44, 88});
	        map.put(91, new int[]{45, 90});
	        map.put(92, new int[]{46, 92});
	        map.put(93, new int[]{47, 94});
	        map.put(94, new int[]{48, 96});
	        map.put(95, new int[]{49, 98});
	        map.put(96, new int[]{50, 100});
	        map.put(97, new int[]{25, 0});
	        map.put(98, new int[]{13, 1});
	        map.put(99, new int[]{9, 3});
	}
	
	public static void main(String[] args) {

	}

}
