package misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Created by neha on 1/22/2017.
 */
public class CabCount {

    static enum EventType{
        Arrival,
        Departure;
    }

    static class  Interval{
        LocalTime time;
        EventType eventType;
    }


        public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //formatter for the time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            int n=Integer.parseInt(br.readLine());

            Interval[] times = new Interval[2*n];

            for (int i = 0; i < 2*n; i+=2) {
                String depTime=br.readLine();
                String arrivalTime=br.readLine();
                times[i]=new Interval();
                times[i+1]=new Interval();
                times[i].time=LocalTime.of(Integer.parseInt(depTime.substring(0,2)),Integer.parseInt(depTime.substring(3,5)));
                times[i].eventType=EventType.Departure;
                times[i+1].time=LocalTime.of(Integer.parseInt(arrivalTime.substring(0,2)),Integer.parseInt(arrivalTime.substring(3,5)));
                times[i+1].eventType=EventType.Arrival;
            }

            System.out.println(new CabCount().countCabs(times,n));

        }

        public int countCabs(Interval[] time,int n)
        {
            //sort as per time
            quickSort(time,0,2*n-1);
            int currentCabCount=1;
            int totalCabCount=1;

            //print sorted times here
            for (int i = 0; i < 2 * n; i++) {
                System.out.print(time[i].time.toString()+" ");
            }

            for (int i = 1; i < 2*n; i++) {
                if(time[i].eventType == EventType.Departure) //cabs not available
                {
                    currentCabCount++;
                    if(currentCabCount>totalCabCount)
                        totalCabCount=currentCabCount;
                }
                else
                {
                    currentCabCount--;
                }
            }
            return totalCabCount;
        }

        //sort according to arrival time

    public void quickSort(Interval a[],int p,int r)
    {
        if(p<r) {
            int q=partition(a,p,r);
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
    }

    public int partition(Interval a[],int p,int q)
    {
        Random random=new Random();
        int randomIndex=random.nextInt(q+1-p)+p;

        //swap first with randomIndex elem
        Interval temp=a[p];
        a[p]=a[randomIndex];
        a[randomIndex]=temp;

        //get the pivot
        Interval pivot=a[p];

        int i=p;
        //partition around the pivot
        for(int j=p+1;j<=q;j++)
        {
            if(a[j].time.isBefore(pivot.time))
            {
                i++;
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        temp=a[p];
        a[p]=a[i];
        a[i]=temp;
        return i;
    }

    }
