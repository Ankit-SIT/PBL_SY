public class Q2 extends Utility{
    private static int smallestDistance(Integer[] array){
        int minIndex = 0;
        int minDistance = Math.abs(array[0] - array[1]);

        for(int i = 0; i < array.length - 1; i++){
            int currentDistance = Math.abs(array[i] - array[i+1]);
            if(currentDistance < minDistance){
                minDistance = currentDistance;
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args){
        System.out.println("ENTER VALUES: ");
	    Integer[] array = getArray();
        System.out.println("MINIMUM DISTANCE IS ON INDEX: " + smallestDistance(array));
    }
}
