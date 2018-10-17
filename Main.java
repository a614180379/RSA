package RSA;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RSA rsa=new RSA(11, 17);
		rsa.generateKey();
		int c=128;
		int m=rsa.E(c);
		System.out.println("密文："+m);
		int jc=rsa.D(m);
		System.out.println("明文:"+jc);
	}

}
