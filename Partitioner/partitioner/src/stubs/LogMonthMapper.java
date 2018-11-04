package stubs;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LogMonthMapper extends Mapper<LongWritable, Text, Text, Text> {

  /**
   * Example input line:
   * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
   *
   */
	public static List<String> months =  Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  //We will now split the input line into space-delimited fields.
	  String[] l = value.toString().split(" ");
	  
	  if (l.length>3) //We now ave the 1st fild in the line as the IP address.
	  {
		  String p = l[0];
		  String[] date = l[3].split("/");
		  if (date.length<1)
		  {
			  String Month = date[1]; 
			  
			  if (months.contains(Month))
				  context.write(new Text(p),  new Text(Month));
		  }
	  }
    
	  /* TODO: implement */
	  
  }
}
