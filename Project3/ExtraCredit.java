public class ExtraCredit {
    //Extra Credit: Birthday Collision

    /*
    * To do this problem we have to consider that if we have a group of people below 366, then there is a
    * chance that no one has the same birthday. But to calculate that someone has the same birthday,
    * there are too many conditions to consider, like what if 2 people have the same birthday, three people
    * with the same birthday and so on. this is why we subtract the whole sample space, 1, with its
    * complement, which no one has the same birthday. we would do 1 - P(A') to get our percentage. To get P(A')
    * we have to consider that no one shares the same birthday. for 2 people, we set one unique date out of the 365
    * then the other person one of the 364 days, but cannot be the same.
    * */


    public static void main(String[] args) {
        for(int i = 0; i < 366; i++)
        System.out.println("N = " + i + ": " + birthdayColl(i));
    }

    public static String birthdayColl(int p){
        if(p > 365) return "1";
        else if (p <= 1) return "0";
        double comp = 1;
        for(double i = 0; i < p; i++){
            comp *= ( (365 - i)/365);
        }
        int[] arr = new int[300];
        String result = ".";
        int i = 0;
        while(comp != 0){
            int temp = (int) ((comp * 10));
            arr[i++] = temp;
            comp = (comp*10)%1;
        }

        int size = i;

        boolean nonzero = false;

        for(; i >= 0; --i){
            if(arr[i] != 0 || nonzero){
                nonzero = true;
                arr[i] = 9 - arr[i];
            }
            else if(!nonzero && arr[i-1] != 0) arr[i-1] = -1;
        }

        for(int j = 0; j < size; j++){
            result+=arr[j];
        }
        return result;
    }
}
