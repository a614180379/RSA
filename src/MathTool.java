lpackage com;

import java.util.ArrayList;

public class MathTool {
	
	/**
	 * @功能 计算 x Mod y
	 * @param x
	 * @param y
	 * @return
	 */
	public static int Mod(int x,int y){
		int r=x%y;
		if((x>0&&y<0)||(x<0&&y>0)){
			r=0-r;
		}
		return r;
	}
	

	
	/**
	 * @功能 判断 a和b是否互质
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isRelativelyPrime(int a,int b){
		int min=a<b?a:b;
		int t=min/2;
		for(int i=2;i<=t;i++){
			if((a%i==0)&&(b%i==0)){
				return false;
			}
		}
		if((a+b-min)%min==0 )return false;
		return true;
	}
	
	
	/**
	 * @功能 列出所有小于 val 且与 val互质的数
	 * @param val
	 * @return
	 */
	public static ArrayList<Integer> getHuZhi(int val){
		ArrayList<Integer> alist=new ArrayList<>();
		for(int i=2;i<val;i++){
			if(MathTool.isRelativelyPrime(i, val)){
				alist.add(i);
			}
		}
		
		return alist;
	}
}
