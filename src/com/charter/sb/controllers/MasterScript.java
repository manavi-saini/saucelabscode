/**
 * 
 */
package com.charter.sb.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import jxl.StringFormulaCell;
import mx4j.tools.config.DefaultConfigurationBuilder.New;






import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.Test;

//import com.sun.org.apache.bcel.internal.generic.NEW;

//import com.mercury.qualitycenter.otaclient.ITDConnection;















import com.*;
import com.charter.sb.utils.JsonUtility;
import com.charter.sb.utils.ReportingFunctions;
import com.charter.sb.utils.RunManager;
/**
 * @author Dhivya_Durairaj
 *
 */

@Test
public class MasterScript extends Initialization{
	public String[] Mod;
	public ArrayList modNameList = new ArrayList<String>();
	String strModuleName;
	String strSummary;
	String strType;
	String Wb;
	RunManager runmgr = new RunManager();
	ReportingFunctions repfn = new ReportingFunctions();
	private static List<List<HSSFCell>> cellGrid;
	

	public void FnMainTest() throws IOException, Exception{
		try{			
			/*Call to execute the test suite*/					
			runmgr.initializeReportingCSV();	//Velu
			
			String p=m1.get("PLATFORM").toString();
			if(p.equalsIgnoreCase("MAC"))
			{
				Wb=m1.get("DATASHEET_PATH").toString()+"//"+m1.get("RUNMGR").toString()+".xls";
			}else{
				Wb=m1.get("DATASHEET_PATH").toString()+"\\"+m1.get("RUNMGR").toString()+".xls";
			}
			String strPath=m1.get("RESULTS_PATH").toString();
			System.out.println("results path: "+ strPath);
			strSummary=runmgr.FnGenerateXLSummary(strPath);
			m1.put("SummaryXL",strSummary);
			strType=m1.get("TestType").toString();
			
			Mod=runmgr.FnCom_GetModule(Wb);
			JsonUtility JsonUtility=new JsonUtility();
			JsonUtility.generateJsonReports();
			
			for(int i=0;i<Mod.length;i++)
			{	System.out.println("i value" + i);
				if(Mod[i].equals("no value"))
				{
					System.out.println("null value");
				}else{
					System.out.println(Mod[i]);
					if(m1.get("TS_STATUS").toString().equals("false") && m1.get("ONERR_Exe_STOP").toString().equals("true") )
					{
						//repfn.FnUpdateTestStepResHTML("Execution Aborted", "Execution of the entire test suite is aborted", "DONE",);
						break;
					}
					System.out.println(Mod[i]);
					if(Mod[i].contains(";") )
					{
						String[] s=Mod[i].split(";");
						System.out.println(s.length);
						strModuleName=s[0];
						strBrowser=s[1];
						strEnv=s[2];
						modNameList.add(strModuleName);
						runmgr.FnCom_GetEnvParam(Wb,strEnv);
						
					}		
					runmgr.FnCom_GetParam(Wb, strModuleName, strBrowser,strEnv,strType);	
				}
			}
			runmgr.executeTask(Mod.length,modNameList);
			
			for(int i=0;i<Mod.length;i++)
			{
				
				//Velu
				
				RunManager.testmoduleuuid = "maxTimeuuid('"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new Date())+"')";
				double ModulePassPercentage = (((double)(RunManager.TestCasePass)/(double)(RunManager.TestCasePass + RunManager.TestCaseFail))*100);
				
					strPresentDir = getRelativePath();
					String[] path=strPresentDir.split("Workspace");
					System.out.println("first val: "+ path[0]);
					p=path[0]+"ExecReports";	
					
					String machinetype=m1.get("PLATFORM").toString();
					String filepath ="";
					
					if(machinetype.equalsIgnoreCase("MAC"))
					{
						filepath=p+"//ExecSummary//funtestres1.xls";
						
					}
					else{
						filepath=p+"\\ExecSummary\\funtestres1.xls";							
						}
					FileInputStream fis = new FileInputStream(filepath);
					HSSFWorkbook wb = new HSSFWorkbook(fis);
				     HSSFSheet sheet = wb.getSheet("funtestres1");
				     FileOutputStream  fos =new FileOutputStream(filepath);
				     while(RunManager.startTestModule != RunManager.intRowCounter)
				     {
				    	 HSSFRow row     = sheet.getRow(RunManager.startTestModule++);
				    	 if(null != row )
				    	 row.getCell(11).setCellValue(ModulePassPercentage);
				     }
				     
				     String Envir = null;
				     String applic = null;
				     String moduuid = null;
				     String modname = null;
				     double modres = 0.0;
				     //Anandavelu -start
				     HSSFRow row     = sheet.getRow(RunManager.startTestModule - 1);
				     if(null != row){
				      Envir = row.getCell(0).getStringCellValue();
				      applic = row.getCell(1).getStringCellValue();
				      moduuid = row.getCell(3).getStringCellValue();
				      modname = row.getCell(10).getStringCellValue();
				      modres = row.getCell(11).getNumericCellValue();
				     }
				      if(machinetype.equalsIgnoreCase("MAC"))
						{
							filepath=p+"//ExecSummary//funprojfeattestres1.xls";
							m1.put("csv2",filepath);
						}
						else
						{
							filepath=p+"\\ExecSummary\\funprojfeattestres1.xls";			
							m1.put("csv2",filepath);
						}
				      	HSSFWorkbook wb2;
				      	HSSFSheet sheet2;
				      	FileInputStream fis2 = null;
				      	
				      	if (i == 0)
						 {
					      	wb2 = new HSSFWorkbook();
							sheet2 = wb2.createSheet("funprojfeattestres1");
							 row     = sheet2.createRow(0);     	
				     		row.createCell(0).setCellValue("environment "); 
				     		row.createCell(1).setCellValue("project"); 
				     		row.createCell(2).setCellValue("feature");
				     		row.createCell(3).setCellValue("feature_run_id");
				     		row.createCell(4).setCellValue("feature_result");
						 }
				      	else
				      	{
				      		fis2 = new FileInputStream(filepath);
				      		wb2 = new HSSFWorkbook(fis2);
				      		sheet2 = wb2.getSheet("funprojfeattestres1");
				      	}				      	
			     		row     = sheet2.createRow(i+1);
			     		row.createCell(0).setCellValue(Envir); 
			     		row.createCell(1).setCellValue(applic); 
			     		row.createCell(2).setCellValue(modname);
			     		row.createCell(3).setCellValue(moduuid);
			     		row.createCell(4).setCellValue(modres);
			     		FileOutputStream fos2=new FileOutputStream(filepath);
						  wb2.write(fos2);            
					      fos2.close();
					      if(fis2 != null)
					    	  fis2.close();
				     //Anandavelu -end
				     wb.write(fos);            
				      fos.close();	
				      fis.close();
				RunManager.startTestModule = RunManager.intRowCounter;
				RunManager.modulePassPercentage[i] = ModulePassPercentage;
				RunManager.TestCasePass = RunManager.TestCaseFail = 0;
				//Velu
			
			}
		
			//Velu	
			double Sum = 0.00;
			double ProjectPassPercentage = 0.00;
			if(Mod != null  && Mod.length > 0)
			{
				for(int i=0;i<Mod.length;i++)
				{
					Sum += RunManager.modulePassPercentage[i];
				}
				ProjectPassPercentage = Sum/Mod.length;
			}
			
				strPresentDir = getRelativePath();
				String[] path=strPresentDir.split("Workspace");
				System.out.println("first val: "+ path[0]);
				p=path[0]+"ExecReports";	
				
				String machinetype=m1.get("PLATFORM").toString();
				String filepath ="";
				
				if(machinetype.equalsIgnoreCase("MAC"))
				{
					filepath=p+"//ExecSummary//funtestres1.xls";
				}
				else{
					filepath=p+"\\ExecSummary\\funtestres1.xls";							
					}
				FileInputStream fis = new FileInputStream(filepath);
				HSSFWorkbook wb = new HSSFWorkbook(fis);
			     HSSFSheet sheet = wb.getSheet("funtestres1");			     
			     //Anandavelu -start
			     String filepath1 = "";
			     if(machinetype.equalsIgnoreCase("MAC"))
					{
						filepath1=p+"//ExecSummary//funinsref1.xls";
						m1.put("csv3",filepath1);
					}
					else{
						filepath1=p+"\\ExecSummary\\funinsref1.xls";	
						m1.put("csv3",filepath1);
					}
			     	HSSFWorkbook wb4 = new HSSFWorkbook();
					HSSFSheet sheet4 = wb4.createSheet("funinsref1");					
				 //Anandavelu -end
			     while(RunManager.startTestProject != RunManager.intRowCounter)
			     {
			    	 HSSFRow row     = sheet.getRow(RunManager.startTestProject++);
			    	 if(null != row){
			    	 row.getCell(17).setCellValue(ProjectPassPercentage);
			    	 //Anandavelu -start				     
					 HSSFRow row1;
					 if(RunManager.startTestProject == 2)
					 {
						 row1     = sheet4.createRow(0);     	
						row1.createCell(0).setCellValue("project_run_id");
			     		row1.createCell(1).setCellValue("feature_run_id");
			     		row1.createCell(2).setCellValue("function_run_id");
			     		row1.createCell(3).setCellValue("api_run_id");
					 }
			     		row1     = sheet4.createRow(RunManager.startTestProject - 1);
			     		row1.createCell(0).setCellValue(row.getCell(2).getStringCellValue()); 
			     		row1.createCell(1).setCellValue(row.getCell(3).getStringCellValue()); 
			     		row1.createCell(2).setCellValue(row.getCell(4).getStringCellValue());
			     		row1.createCell(3).setCellValue(row.getCell(5).getStringCellValue());					 
				      //Anandavelu -end
			     }		}		     
			     //Anandavelu -start
			     HSSFRow row = null;
			     String Envir = null;
			     String applic= null;
			     String projuuid= null;
			     double projres= 0.0d;
			     FileOutputStream fos4 =new FileOutputStream(filepath1);
			     wb4.write(fos4);            
			      fos4.close();
			     row     = sheet.getRow(1);
			     if(null != row){
			    Envir = row.getCell(0).getStringCellValue();
			      applic = row.getCell(1).getStringCellValue();
			      projuuid = row.getCell(2).getStringCellValue();
			     projres = row.getCell(17).getNumericCellValue();
			     }
			     //Anandavelu -end
			     FileOutputStream  fos =new FileOutputStream(filepath);
			     wb.write(fos);            
			      fos.close();	
			      fis.close();
			      
			      
			      
			      //Anandavelu -start
			      if(machinetype.equalsIgnoreCase("MAC"))
					{
						filepath=p+"//ExecSummary//funprojtestres1.xls";
						m1.put("csv4",filepath);
					}
					else{
						filepath=p+"\\ExecSummary\\funprojtestres1.xls";			
						m1.put("csv4",filepath);
						}
			      	HSSFWorkbook wb1 = new HSSFWorkbook();
					HSSFSheet sheet1 = wb1.createSheet("funprojtestres1");
					
					  row     = sheet1.createRow(0);     	
			     		row.createCell(0).setCellValue("environment"); 
			     		row.createCell(1).setCellValue("project"); 
			     		row.createCell(2).setCellValue("project_run_id");
			     		row.createCell(3).setCellValue("project_result");
			     		row     = sheet1.createRow(1);
			     		row.createCell(0).setCellValue(Envir); 
			     		row.createCell(1).setCellValue(applic); 
			     		row.createCell(2).setCellValue(projuuid);
			     		row.createCell(3).setCellValue(projres);
			     		 FileOutputStream fos1 =new FileOutputStream(filepath);
					  wb1.write(fos1);            
				      fos1.close();
			        
				    	
		}
		catch(Exception e){
			System.err.println("Master Script error :");
			System.err.println("	Function : Master Script");
			System.err.println("	Message : "+e.getMessage());
			System.err.println("	Cause : "+e.getCause());
			e.printStackTrace();
		}
		
		String strWorkBookName1=m1.get("csv").toString();
		repfn.FnConverXltoCSV2(strWorkBookName1);	
		
		String strWorkBookName2=m1.get("csv5").toString();
		repfn.FnConverXltoCSV3(strWorkBookName2);
		
		String strWorkBookName3=m1.get("csv6").toString();
		repfn.FnConverXltoCSV4(strWorkBookName3);	//1/13/2016
		
		String strWorkBookName4=m1.get("csv3").toString();
		repfn.FnConverXltoCSV5(strWorkBookName4);	//1/13/2016
		
		String strWorkBookName5=m1.get("csv7").toString();
		repfn.FnConverXltoCSV6(strWorkBookName5);	//1/13/2016
		
		String strWorkBookName6=m1.get("csv2").toString();
		repfn.FnConverXltoCSV7(strWorkBookName6);	//1/13/2016
		
		//String strWorkBookName7=m1.get("csv4").toString();
		//repfn.FnConverXltoCSV8(strWorkBookName7);	//1/13/2016
		
		
		
	}


}