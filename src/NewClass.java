
import java.util.Arrays;




public class NewClass {

    public static void main(String[] args) {
        int arr[] = {1,5,6,3,7,2,9};
        int i,j,n;
        for(i = 0; i<arr.length - 1;i++){
            for(j = i+1; j <arr.length;j++){
                if(arr[i]>arr[j]){
                    n = arr[i];
                    arr[i] = arr[j];
                    arr[j] = n;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
