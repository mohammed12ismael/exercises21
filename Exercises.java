

public class Exercises
{
    // 7
    public static void main(String[] args)
    {
        //a
        double[] list1 = {2.1, 1.1, 4.1, 5.1, 3.1};
        //b
        double[] list2 = createArray(10, 5.0, 3.5);
        //c
        list1 = addNumbers(list1, 9.9, 6.6, 2.2, 7.7);
        //d
        list2 = addNumbers(list2, 9.9, 6.6, 8.8);
        //e
        list2 = arrayGreaterThan(list2, 4);
        //f
        double[][] list2d = new double[4][];
        list2d[0] = new double[] {6.2, 3.1, 1.5};
        list2d[1] = new double[] {3.4, 1.5, 3.4, 2.9, 1, 3.4};
        list2d[2] = list1;
        list2d[3] = list2;

        //g
        list2d = removeRows(list2d, 1);

        //h
        reverseRows(list2d);
    }

    public static void printArray(double[] array)
    {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    public static void printMatrix(double[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            printArray(matrix[i]);
            System.out.println();
        }
    }

    //1
    public static double[] createArray(int size, double firstElement,
                                       double increment)
    {
        double[] out = new double[size];
        out[0] = firstElement;
        for (int i = 1; i < size; i++)
            out[i] = out[i-1] + increment;
        return out;
    }

    //2
    public static double[] reversePart(double[] array,
                                       int first, int end)
    {
        if (first < 0 || first > array.length-1
                || end < 0 || end > array.length-1)
            return array;
        /* if the end is less than the first it will not enter the loop
        * because the condition of the loop is first < end*/
        for (int i = first; i < end+1; end--, i++)
        {
            double temp = array[i];
            array[i] = array[end];
            array[end] = temp;
        }
        return array;
    }

    //3
    public static double[] addNumbers(double[] array, double... args)
    {
        boolean sorted = true;
        for (int i = 0; i < array.length-1; i++)
        {
            if (array[i] > array[i+1])
            {
                sorted = false;
                break;
            }
        }

        double[] temp = new double[array.length+args.length];
        int arrayIndex = 0, argsIndex = 0;
        for (int i = 0; i < temp.length; i++)
        {
            if (i > array.length-1)
                temp[i] = args[argsIndex++];
            else
                temp[i] = array[arrayIndex++];
        }

        if (sorted)
        {
            // sort the temp array (Bubble sort)
            boolean needNextIteration = true;
            while (needNextIteration)
            {
                needNextIteration = false;
                for (int i = 0; i < temp.length-1; i++)
                {
                    if (temp[i] > temp[i+1])
                    {
                        // interchange
                        double temp_ = temp[i];
                        temp[i] = temp[i+1];
                        temp[i+1] = temp_;
                        needNextIteration = true;
                    }
                }
            }
        }
        return temp;
    }

    //4
    public static double[] arrayGreaterThan(double[] array, double value)
    {
        int newSize = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] < value)
                array[i] = value-1;
            else
                newSize++;
        }

        double[] newArray = new double[newSize];
        int index = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] != value-1)
                newArray[index++] = array[i];
        }

        return newArray;
    }

    // 5
    public static double[][] removeRows(double[][] matrix, int rowIndex)
    {
        if (rowIndex < 0 || rowIndex > matrix.length-1)
            return matrix;

        double[][] newMatrix = new double[matrix.length-1][];
        int index = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            if (i != rowIndex)
                newMatrix[index++] = matrix[i];
        }
        return newMatrix;
    }

    // 6
    public static void reverseRows(double[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
            matrix[i] = reversePart(matrix[i], 0, matrix[i].length-1);
    }

}
