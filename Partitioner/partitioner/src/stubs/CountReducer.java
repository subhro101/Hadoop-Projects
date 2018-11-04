package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountReducer extends Reducer<Text, Text, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
    
	  int i = 0;
// We now use a for loop to count the number of items in the iteration 
		 
		
		/* Ignore warnings that we
		 * don't use the value -- in this case, we only need to count the
		 * values, not use them.
		 */
		for (@SuppressWarnings("unused")
		Text value : values) {

		
			i++; // we increment for each i for each item on the list 
		}

context.write(key, new IntWritable(i));
  }
}
