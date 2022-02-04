package fbuni;

import java.io.*;

public class Arquivo {

	/*
	public void gravarArquivo(String s) {
		try {
			OutputStream outStream = new FileOutputStream("arquivo");
			
			 int count = s.length()-1;
			 int count2 = 0;
			 while (count2 <= count) {
                 outStream.write(s.charAt(count2));

                 ++count2;
			 }
	    outStream.close();
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	/*
	public void lerArquivo() {
		InputStream inStream;
		
		try {
			 inStream = new FileInputStream("arquivo");

             int data = inStream.read();
             while (data != -1) {
            	 System.out.println( (char)data );

                 data = inStream.read();

             }
        inStream.close();
		} catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	*/
	
	public void gravarArquivo(int c) throws IOException{
		//FileInputStream in = null;
		FileWriter out = null;

	      try {
	         out = new FileWriter("arquivo.txt");
	         
	         //c = 123;
	         //while ((c = in.read()) != -1) {
	         out.write(c);
	         //}
	      }catch (IOException e) {
	    	  
	      
	      }finally {
	         /*if (in != null) {
	            in.close();
	         }*/
	         if (out != null) {
	            out.close();
	         }
	      }
	}
	
	public int lerArquivo() throws IOException {
		//FileInputStream in = null;
				FileReader in = null;
				int c = 0;

			      try {
			         in = new FileReader("arquivo.txt");
			         
			         c = in.read();
			         //while ((c = in.read()) != -1) {
			         //System.out.println(c);
			         
			         //}
			      }catch (IOException e) {
			    	  
			      
			      }finally {
			         /*if (in != null) {
			            in.close();
			         }*/
			         if (in != null) {
			            in.close();
			         }
			      }
			      return c;
	}
}
