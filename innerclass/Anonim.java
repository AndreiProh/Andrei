package innerclass;

public class Anonim {
    public int i;
    public String str;
    public Anonim(int i) {
        System.out.println("into Anonim");
        this.i = i;
    }
}
class GetAnonim {
    public Anonim getAnonim(int x) {
        return new Anonim(x) {
            {str = "String";
            System.out.println("into GetAnonim");}
        };
    }

    }

class Testanonimus{
    public static void main(String[] args) {
        GetAnonim q = new GetAnonim();
        Anonim a = new Anonim(2);
        System.out.println(q.getAnonim(3).i);
    }
}