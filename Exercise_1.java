public class Exercise_1
{
    public int data;
    public Exercise_1 next;

    public Exercise_1 ()
    {
        this (0,null);
    }

    public Exercise_1(int data)
    {
        this (data,null);
    }

    public Exercise_1(int data, Exercise_1 next)
    {
        this.data = data;
        this.next = next;
    }
}

class LinkedIntList
{
    private Exercise_1 front;

    public LinkedIntList()
    {
        front = null;
    }

    public String toString ()
    {
        if (front == null)
        {
            return "[]";
        }
        else
        {
            String result = "[" + front.data;
            Exercise_1 current = front.next;

            while (current!=null)
            {
                result += ", " + current.data;
                current = current.next;
            }
            result += "] ";
            return result;
        }
    }

    public void add (int value){
        if (front == null)
        {
            front = new Exercise_1(value);
        }
        else
        {
            Exercise_1 current = front;

            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new Exercise_1(value);
        }
    }

    public void remove (int index)
    {
        if (index == 0)
        {
            front = front.next;
        }
        else
        {
            Exercise_1 current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    private Exercise_1 nodeAt (int index)
    {
        Exercise_1 current = front;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current;
    }

    public void set (int index, int value)
    {
        if (index == 0)
        {
            front = new Exercise_1(value, front);
        }
        else
        {
            Exercise_1 current = nodeAt(index - 1);
            current.next = new Exercise_1(value, current.next);
        }
    }
}

class Exercise1
{
    public static void main(String[] args)
    {
        LinkedIntList list1 = new LinkedIntList();

        list1.add(102);
        list1.add(95);
        list1.add(1);

        list1.set(2,20);

        System.out.println(list1);
    }
}
