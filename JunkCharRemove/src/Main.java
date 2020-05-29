import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
	
	String fullFilePath;
	String fileName;
	
	public static void main(String[] args) {
		
		
		 Main m = new Main();
		
		 try (InputStream input = new FileInputStream("conf.properties"))
		 {
			 Properties prop = new Properties();
			 prop.load(input);
			 m.listOfFiles(new File(prop.getProperty("filePath")));
		 }
		 
		 catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}

	
	public void listOfFiles(File name)
	{
		for(File f: name.listFiles())
		{
			if(f.isDirectory())
			{
				listOfFiles(f);
			}
			
			else
			{
				fileName=f.getName();
				fullFilePath=f.getAbsolutePath();
				removeJunk(name);
			}
		}
	}
	
	
	void removeJunk(File newFolder)
	{
		System.out.println("File name is {["+fileName+"]}");
		System.out.println("Full File Path is {["+fullFilePath+"]}");
		System.out.println("Dest File Path is {["+newFolder+"]}");
		
		BufferedReader br=null;
		BufferedReader br1=null;
		BufferedWriter bw=null;
		int i = 0;
		int j = 0;
		ArrayList<String> lines = new ArrayList<String>();
		
		File f = new File(fullFilePath+"111");
		File f1 = new File(fullFilePath);
		
		try
		{

			br = new BufferedReader(new FileReader(f1));
			br1 = new BufferedReader(new FileReader(f1));
			bw = new BufferedWriter(new FileWriter(f));
			
			String line="";
			String line1="";
			while((line1 = br.readLine())!=null)
			{
				if(!line1.isEmpty())
				{
					i = i+1;
				}
			}
			
			System.out.println("Total Lines in a Raw file Without NewLine is "+i);
			while((line = br1.readLine())!=null)
			{
				line = line.trim();
				line = line.replaceAll("\r\n", "");
				line = line.replaceAll("\t", "");
				line = line.replaceAll("[\u0000-\u001f]", "");
				
				if(!line.isEmpty())
				{
					lines.add(line);	
				}
			}
			
			Collections.sort(lines);
			
			for(String textline:lines)
			{
				j = j+1;
				bw.write(textline);
				
				if(i!=j)
				{
					bw.newLine();
				}		
			}
			
				System.out.println("Total Lines in Final file Without NewLine is "+j);
			}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		finally
		{
			try {
				br.close();
				br1.close();
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("f1 path "+f1.getAbsolutePath());
		System.out.println("f path "+f1.getAbsolutePath());
		f1.delete();
		f.renameTo(f1);
		//doZip();
		//f1.delete();
	}
	
	void doZip()
	{
		ZipOutputStream zipOut=null;
		FileInputStream in=null;
		byte[] buffer = new byte[1024];
		try
		{
			String zipfile = fullFilePath.substring(0,fullFilePath.lastIndexOf(".")).concat(".zip");
			System.out.println("zipfile name "+zipfile);
			zipOut = new ZipOutputStream(new FileOutputStream(zipfile));
			
			zipOut.putNextEntry(new ZipEntry(fileName));
			
			in = new FileInputStream(fullFilePath);
		   	   
    		int len;
    		while ((len = in.read(buffer)) > 0) {
    			zipOut.write(buffer, 0, len);
    		}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		
		finally
		{
			try {
				in.close();
				zipOut.closeEntry();
				 zipOut.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
