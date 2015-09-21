package testgenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Used to output the test cases.
 * Used by the test generator.
 */
public class JUnitWriter 
{
	public String PackageName;
	private ArrayList<String> PackageImports;
	public String ClassName;
	// TODO: test cases
	
	
	public JUnitWriter() 
	{
		PackageImports = new ArrayList<String>();
		
		// Import basic JUnit stuff
		PackageImports.add("static org.junit.Assert.*");
		PackageImports.add("org.junit.After");
		PackageImports.add("org.junit.Before");
		PackageImports.add("org.junit.BeforeClass");
		PackageImports.add("org.junit.Test");
	}

	public void AddPackageImport(String p)
	{
		PackageImports.add(p);
	}

	public void RemovePackageImport(String p)
	{
		PackageImports.remove(p);
	}
	
	public void Save()
	{
		int indentation = 0;
		
		// Package name and imports
		String output = "package " + PackageName + ";\n\n";
		for(String s : PackageImports)
		{
			output = output + "import " + s + ";\n";
		}
		
		// Class and global variables
		output = output + "\n" + "public class " + ClassName + "{" + "\n\n";
		indentation++;
		
		// TODO: global variables
		
		// basic constructor
		output = output + "\n" + indent(indentation) + "public " + ClassName + "(){}\n\n";
		
		// TODO: TESTS
		
		
		// Close the class
		indentation--;
		output = output + indent(indentation) + "}";
		
		// Write the file
		// TODO: check if file/directory exists, make it, override otherwise
		try (FileWriter o = new FileWriter(ClassName + ".java");)
		{
			o.write(output);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String indent(int n)
	{
		String output = "";
		for(int i = 0; i < n; i++)
		{
			output = output + "\t";
		}
		return output;
	}
	
	// For debugging/testing purposes
	// TODO: remove before submitting
	public static void main(String[] args) 
	{
		JUnitWriter x = new JUnitWriter();
		x.PackageName = "Rush";
		x.ClassName = "GeddyLee";
		x.AddPackageImport("java.io.FileWriter");
		x.AddPackageImport("java.util.ArrayList");
		x.AddPackageImport("com.thoughtworks.xstream.XStream");
		x.Save();
	}
}