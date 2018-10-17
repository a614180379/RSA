package RSA;

import java.util.ArrayList;

import com.MathTool;


public class RSA {
	class PublicKey{
		public int n;
		public int e;
		
	};
	
	class PrivateKey{
		public int d;
		public int n;
	};
	
	
	
	/**
	 * @功能 构造函数，需要两个素数，但并没有对传入的两个参数是否是素数的检查
	 * @param tp
	 * @param tq
	 */
	public RSA(int tp,int tq){
		p=tp;
		q=tq;
	};
	
	/*公钥*/
	PublicKey publicKey;
	/*私钥*/
	PrivateKey privateKey;
	/*素数*/
	int p,q;
	
	
	/**
	 *@功能: 生成公钥和私钥
	 */
	public void generateKey(){
		publicKey =new PublicKey();
		privateKey=new PrivateKey();
		
		/* n=p*q */
		publicKey.n=p*q;
		privateKey.n=publicKey.n;
		generateE();
		generateD();
		System.out.println("公钥(e,n):"+publicKey.e+","+publicKey.n
				+"  私钥(d,n):"+privateKey.d+","+privateKey.n
				);
		

	}
	
	
	/**
	 * @功能:生成E
	 */
	public void generateE(){
		int temp=(p-1)*(q-1);
		/*列出所有 小于temp 且与 temp互质的数*/
		ArrayList<Integer> alist=MathTool.getHuZhi(temp);
		System.out.print(temp+":");
		for(int i=0;i<alist.size();i++){
			System.out.print(alist.get(i)+",");
		}
		System.out.println();
		/*随机生成e*/
		publicKey.e=alist.get((int) (Math.random()*alist.size()));
	}	
	
	
	/**
	 * @功能:生成D
	 */
	public void generateD(){
		int temp=(p-1)*(q-1);
		for(int i=1;i<Integer.MAX_VALUE;i++){
			
			/*满足条件    (d*e) mod temp =1 的值*/
			if(MathTool.Mod(i*publicKey.e, temp)==1){
				privateKey.d=i;
				return ;
			}
		}
	}
	

	
	/**
	 * @功能  加密
	 * @param c:明文
	 * @return 密文
	 */
	public int E(int c){
		return fun(c,publicKey.e,publicKey.n);
	}

	/**
	 * @功能:解密
	 * @param 密文
	 * @return 明文
	 */
	public int D(int m){
		return fun(m,privateKey.d,privateKey.n);
	}
	
	
	/**
	 * @功能: 计算 a^b mod n 
	 * @param a
	 * @param b
	 * @param n
	 * @return (a^b mod n )
	 */
	public int fun(int a,int b,int n){
		int r=1;
		for(b+=1;b!=1;b--){
			r=r*a;
			r=r%n;
		}
		return r;
	}
	

}
