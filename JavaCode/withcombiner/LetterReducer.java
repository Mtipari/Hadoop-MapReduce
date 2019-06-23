import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class LetterReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	public void reduce(Text key,Iterable<IntWritable> values,Context context)throws IOException,InterruptedException{
        int count = 0;
        IntWritable result = new IntWritable();
        for (IntWritable val : values) {
            count +=val.get();
            result.set(count);
            
        }   
        context.write(key, result); 
    }

}