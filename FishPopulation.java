import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nb = sc.nextInt();
        int g = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        Long ans = fishPopulation(n, nb, g, l, r);
        System.out.print(ans);
    }
    
    static Long fishPopulation(int n, int nb, int g, int l, int r){
        long fishPop = 0;
        Map<Integer,Fish> map = new HashMap<Integer,Fish>();
        int fishId=0;
        Fish fish;
        int elgToRep=0;
        for(int year=0;year<=n;year++)
        {
            Iterator <Integer> it = map.keySet().iterator();
            if(map.size()>0)
            {
                elgToRep=0;
                while(it.hasNext())  
                {  
                    int key=(int)it.next();
                    fish=map.get(key);
                    
                    if(fish.repSpan>0)
                    {
                        elgToRep++;
                        fish.repSpan--;
                    }
                    if(fish.lifeSpan>0)
                    {
                        fish.lifeSpan--;
                    }
                    else if(fish.lifeSpan==0)
                    {
                        it.remove();
                        map.remove(key);
                        elgToRep--;
                    }
                }
            nb=elgToRep*g;
            }
            for(int curFish=1;curFish<=nb;curFish++)
            {
                fish=new Fish();
                fishId++;
                fish.age=l;
                fish.childPerFish=g;
                fish.lifeSpan=l;
                fish.repSpan=r;

                map.put(fishId,fish);
            }
            fishPop=map.size();
        }
        return fishPop;
    }
}
class Fish
{
    int age;
    int childPerFish;
    int lifeSpan;
    int repSpan;
}