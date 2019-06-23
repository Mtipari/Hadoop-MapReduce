import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LetterMap extends Mapper<LongWritable, Text, Text, IntWritable> {
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
           String line = value.toString();
        {
        	String line1=line.toLowerCase();
               char[] carr = line1.toCharArray();
        for (char c : carr) {
            if(Character.isLetter(c)){
            System.out.println(c);
            context.write(new Text(String.valueOf(c)), new IntWritable(1));
        }
       
    }
        }   
}
}