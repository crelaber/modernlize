package com.uwen.ur.util.crawer;

public class Test3 {
	
	public static abstract class A {
		protected int age = 20;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
	
	public static class B extends A {
		protected int age = 25;

	}
	
	public static void main(String[] args) {
		//A b = new B();
		//System.out.println(b.age);
		
		 /*java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");   
         
        // 初始化数据   
        int a = 3;   
        int b = 4;   
        int c = 5;   
           
        // 计算弧度表示的角   
        double B = Math.acos((a*a + c*c - b*b)/(2.0*a*c));   
        // 用角度表示的角   
        B = 90.0d - Math.toDegrees(B);
        // 格式化数据，保留两位小数   
        String temp = df.format(B);   
        
        System.out.println(temp);*/
		
		
		java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
		
		 double a = 1;   
		 double b = 2;
		 //根据勾股定义求出直角第三边长度
         double c = Math.sqrt(a * a + b * b);
		 //sina=∠a的对边/斜边
         
		//System.out.println(Math.
		 
		 //反正切
		 //System.out.println(Math.atan(Math.tan(a/b)));
		 
		 System.out.println(Math.toDegrees(Math.atan2(a, b)));
		 
        
         
         System.out.println(c);
         
         //已知三边,求夹角
         double B = Math.acos((a*a + c*c - b*b)/(2.0*a*c));   
         // 用角度表示的角   
         B = 90.0d - Math.toDegrees(B);
         // 格式化数据，保留两位小数   
         String degrees = df.format(B); 
         
         System.out.println(degrees);
	}
}
