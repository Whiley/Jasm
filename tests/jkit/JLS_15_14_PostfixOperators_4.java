public class JLS_15_14_PostfixOperators_4 {
    public static void main(String[] args) {
	byte c1=12;
	char c2=12121;
	short c3=12121;
	int c4=2342345;
	long c5=2342345234L;
	float c6=234234.0234234F;
	double c7=234.0289723476234;

	for(int i=0;i!=4;++i) {
	    c1++;
	    c2++;
	    c3++;
	    c4++;
	    c5++;
	    c6++;
	    c7++;
	    System.out.println(c1);
	    System.out.println(c2);
	    System.out.println(c3);
	    System.out.println(c4);
	    System.out.println(c5);
	    System.out.println(c6);
	    System.out.println(c7);
	}

	for(int i=0;i!=4;++i) {
	    c1--;
	    c2--;
	    c3--;
	    c4--;
	    c5--;
	    c6--;
	    c7--;
	    System.out.println(c1);
	    System.out.println(c2);
	    System.out.println(c3);
	    System.out.println(c4);
	    System.out.println(c5);
	    System.out.println(c6);
	    System.out.println(c7);
	}

	for(int i=0;i!=4;++i) {
	    ++c1;
	    ++c2;
	    ++c3;
	    ++c4;
	    ++c5;
	    ++c6;
	    ++c7;

	    System.out.println(c1);
	    System.out.println(c2);
	    System.out.println(c3);
	    System.out.println(c4);
	    System.out.println(c5);
	    System.out.println(c6);
	    System.out.println(c7);
	}

	for(int i=0;i!=4;++i) {
	    --c1;
	    --c2;
	    --c3;
	    --c4;
	    --c5;
	    --c6;
	    --c7;

	    System.out.println(c1);
	    System.out.println(c2);
	    System.out.println(c3);
	    System.out.println(c4);
	    System.out.println(c5);
	    System.out.println(c6);
	    System.out.println(c7);
	}

    }
}
