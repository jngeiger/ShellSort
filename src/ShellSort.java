import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShellSort<T extends Comparable<T>> {
        public static void main (String[] args) throws IOException
        {
        }
        public void insertionSort(List<T> list)
        {
            for (int i = 1; i < list.size(); i++)
            {
                T currentValue = list.get(i);
                int j = i;
                while (j >= 1 && currentValue.compareTo(list.get(j-1)) < 0 )
                {
                    list.set(j,list.get(j-1));
                    j--;
                }
                list.set(j,currentValue);
            }
        }
        public void shellInsertion(List<T> list, int jump)
        {
            for (int i = 1; i < list.size(); i += jump)
            {
                T currentValue = list.get(i);
                int j = i;
                while (j >= jump && currentValue.compareTo(list.get(j-jump)) < 0 )
                {
                    list.set(j,list.get(j-jump));
                    j -= jump;
                }
                list.set(j,currentValue);

            }
        }
        public void shellSort(List<T> list)
        {
            List<Integer> sequence = new ArrayList<Integer>();
            sequence = getPrattSequence(list.size());
            for (int i = sequence.size()-1; i >= 0; i--)
            {
                System.out.println(sequence.get(i));
                shellInsertion(list,sequence.get(i));
            }
        }
        public List<Integer> getPrattSequence(int listSize)
        {
            List<Integer> prattSequence = new ArrayList<Integer>();
            int result = 1;
            int counter = 2;
            while (result < listSize) {
                {
                    prattSequence.add(result);
                    result = (int) Math.pow(2, counter++) - 1;
                }
            }
            return prattSequence;
        }
}


